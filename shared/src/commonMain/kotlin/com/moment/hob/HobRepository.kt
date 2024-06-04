package com.moment.hob

class HobRepository(private val api: HobApi) {
    suspend fun signIn(email: String, password: String): String {
        return api.signIn(email, password)
    }

}