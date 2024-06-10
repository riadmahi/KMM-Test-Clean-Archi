package com.moment.hob.model

import io.realm.kotlin.types.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class Token(
    var refresh: String,
    var access: String
) : RealmObject {
    constructor() : this("", "")
}