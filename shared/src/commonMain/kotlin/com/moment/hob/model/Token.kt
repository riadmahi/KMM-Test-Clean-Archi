package com.moment.hob.model

import io.realm.kotlin.types.RealmObject
import kotlinx.serialization.Serializable

@Serializable
data class Token(val refresh: String, val access: String): RealmObject