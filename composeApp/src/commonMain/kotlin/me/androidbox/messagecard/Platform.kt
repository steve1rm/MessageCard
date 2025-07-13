package me.androidbox.messagecard

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform