package com.moment.hob.dto

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(val email: String, val password: String)