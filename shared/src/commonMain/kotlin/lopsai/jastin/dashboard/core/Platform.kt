package lopsai.jastin.dashboard.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform