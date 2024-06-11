package com.moment.hob

import com.moment.hob.model.Token
import com.moment.hob.state.SignInUiState
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import org.lighthousegames.logging.logging

class HobRepository(private val api: HobApi) {

    private val realm: Realm by lazy {
        val configuration = RealmConfiguration.create(schema = setOf(Token::class))
        Realm.open(configuration)
    }

    suspend fun signIn(email: String, password: String): SignInUiState {
        val result = api.signIn(email, password)
        return if (result is Result.Success) {
            removeToken()
            addToken(result.data)
            SignInUiState.Success
        } else {
            SignInUiState.Error("Sign in failed")
        }
    }

    suspend fun checkToken(): Boolean {
        val token = getToken() ?: return false
        val result = api.checkToken(token.access)
        return result is Result.Success
    }


    private fun addToken(token: Token) {
        realm.writeBlocking {
            copyToRealm(token)
        }
    }

    private fun removeToken() {
        realm.writeBlocking {
            val results = query<Token>().find()
            delete(results)
        }
    }

    private fun getToken(): Token? = realm.query<Token>().find().firstOrNull()

    companion object {
        val log = logging()
    }

}