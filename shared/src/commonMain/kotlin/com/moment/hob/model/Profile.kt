package com.moment.hob.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val email: String,
    @SerialName("display_name") var displayName: String,
    @SerialName("birth_date") val birthDate: String,
    var biography: String
)