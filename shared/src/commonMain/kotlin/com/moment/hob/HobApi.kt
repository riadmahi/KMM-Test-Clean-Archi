package com.moment.hob

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url

class HobApi {
    private val client = HttpClient()

    private var address = Url("http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet")

    suspend fun signIn(email: String, password: String): String {
        return client.get {
            url(address.toString())
        }.toString()
    }
}