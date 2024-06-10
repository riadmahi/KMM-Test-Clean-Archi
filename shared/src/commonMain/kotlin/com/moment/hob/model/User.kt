package com.moment.hob.model
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
@Serializable
data class User(
    @SerialName("firstname")
    val firstname: String,
    @SerialName("email")
    val email: String,
    @SerialName("biography")
    val biography: String,
    @SerialName("size")
    val size: Int,
    @SerialName("date_of_birth")
    val dateOfBirth: String
)