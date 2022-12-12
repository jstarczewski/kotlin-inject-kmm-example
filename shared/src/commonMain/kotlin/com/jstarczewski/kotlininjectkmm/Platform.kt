package com.jstarczewski.kotlininjectkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform