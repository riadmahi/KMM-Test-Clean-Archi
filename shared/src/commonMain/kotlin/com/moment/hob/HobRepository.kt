package com.moment.hob

import com.moment.hob.model.Token
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HobRepository(private val api: HobApi) {

    private val realm: Realm by lazy {
        val configuration = RealmConfiguration.create(schema = setOf(Token::class))
        Realm.open(configuration)
    }

    suspend fun signIn(email: String, password: String): Boolean {
        val result = api.signIn(email, password)
        if (result is Result.Success) {
            removeToken()
            addToken(result.data)
            return true
        }
        return false
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

    fun getToken(): Token = realm.query<Token>().find().first()
}