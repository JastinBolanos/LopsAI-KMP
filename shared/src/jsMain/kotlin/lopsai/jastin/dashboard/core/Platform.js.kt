package lopsai.jastin.dashboard.core

import web.navigator.navigator

class JsPlatform : Platform {
    override val name: String = try {

        val userAgent = navigator.userAgent
        val browserList = listOf("Edg", "Chrome", "Firefox", "Safari")
        val match = userAgent.findAnyOf(browserList, ignoreCase = true)

        if (match != null) {
            val (startIndex, browserName) = match
            val fullNameAndVersion = userAgent.substring(startIndex).substringBefore(" ")
            if (browserName.equals("Edg", ignoreCase = true)) {
                fullNameAndVersion.replace("Edg", "Edge", ignoreCase = true)
            } else {
                fullNameAndVersion
            }
        } else {
            "Unknown Browser"
        }
    } catch (e: Throwable) {
        "Non-Browser JS Environment"
    }
}

actual fun getPlatform(): Platform = JsPlatform()