package com.moment.hob

import com.moment.hob.model.Profile
import com.moment.hob.model.Token
import com.moment.hob.state.ProfileUiState
import com.moment.hob.state.SignInUiState
import com.moment.hob.state.UpdateUiState
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.lighthousegames.logging.logging

class HobRepository(private val api: HobApi) {

    private var token = Token()
    private var _profileUiState = MutableStateFlow<ProfileUiState>(ProfileUiState.None)
    val profileUiState = _profileUiState.asStateFlow()
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
            SignInUiState.Error((result as Result.Error).message)
        }
    }

    suspend fun checkToken(): Boolean {
        token = getToken() ?: return false
        val result = api.checkToken(token.access)
        if (result is Result.Success) _profileUiState.update { getProfile() }
        return result is Result.Success
    }

    private suspend fun getProfile(): ProfileUiState {
        val result = api.getProfile(token.access)
        return if (result is Result.Success) {
            ProfileUiState.Success(result.data)
        } else {
            ProfileUiState.Error((result as Result.Error).message)
        }
    }

    suspend fun updateProfile(profile: Profile): ProfileUiState {
        val result = api.updateProfile(token.access, profile)
        return if (result is Result.Success) {
            _profileUiState.emit(ProfileUiState.Success(result.data))
            ProfileUiState.Success(result.data)
        } else {
            ProfileUiState.Error((result as Result.Error).message)
        }
    }

    /**
     * Local DB
     */
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