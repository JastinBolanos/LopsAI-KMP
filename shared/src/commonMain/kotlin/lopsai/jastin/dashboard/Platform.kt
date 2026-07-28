package lopsai.jastin.dashboard

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform