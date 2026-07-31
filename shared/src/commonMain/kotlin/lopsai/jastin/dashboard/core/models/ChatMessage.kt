package lopsai.jastin.dashboard.core.models

import org.jetbrains.compose.resources.DrawableResource

data class ChatMessage(
    val text: String,
    val isUser: Boolean = false,
    val isTyping: Boolean = false,
    val imageRes: DrawableResource? = null
)