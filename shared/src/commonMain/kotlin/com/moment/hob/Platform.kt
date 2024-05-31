package com.moment.hob

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform