package com.moment.hob

import com.moment.hob.dto.SignInRequest
import com.moment.hob.model.Token
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class HobApi {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                encodeDefaults = true
            })
        }
    }

    private var address = Url("http://192.168.1.161:8000/")

    suspend fun signIn(email: String, password: String): Result<Token> {
        val response = client.post {
            url(address.toString() + "login")
            contentType(ContentType.Application.Json)
            setBody(SignInRequest(email, password))
        }

        return if (response.status == HttpStatusCode.OK) {
            Result.Success(response.body<Token>())
        } else {
            Result.Error(response.bodyAsText())
        }
    }
}