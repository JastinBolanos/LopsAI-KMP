package lopsai.jastin.dashboard.features.chat.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun AITypingBubble(
    fullText: String,
    isTyping: Boolean,
    isDarkMode: Boolean = true // <-- SOPORTE DE MODO OSCURO
) {
    var displayedText by remember { mutableStateOf(if (isTyping) "" else fullText) }
    var showActions by remember { mutableStateOf(!isTyping) }

    // 🎨 PALETA DINÁMICA: BLANCO NÍTIDO Y PLOMO CLARO EN MODO OSCURO
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val actionTint = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark

    LaunchedEffect(fullText) {
        if (isTyping) {
            for (i in 1..fullText.length) {
                displayedText = fullText.substring(0, i)
                delay(12)
            }
            showActions = true
        }
    }

    Column {
        Text(
            text = displayedText,
            color = textColor, // <-- LETRAS BLANCAS EN DARK MODE
            fontSize = 15.sp,
            lineHeight = 24.sp,
            modifier = Modifier.padding(end = 24.dp)
        )

        AnimatedVisibility(
            visible = showActions,
            enter = fadeIn(tween(400)) + slideInVertically(tween(400)) { it / 2 }
        ) {
            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.ContentCopy,
                    contentDescription = "Copy",
                    tint = actionTint,
                    modifier = Modifier.size(16.dp).clickable { /* Copy */ }
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Outlined.ThumbUp,
                    contentDescription = "Like",
                    tint = actionTint,
                    modifier = Modifier.size(16.dp).clickable { /* Like */ }
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Outlined.ThumbDown,
                    contentDescription = "Dislike",
                    tint = actionTint,
                    modifier = Modifier.size(16.dp).clickable { /* Dislike */ }
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Outlined.VolumeUp,
                    contentDescription = "Listen",
                    tint = actionTint,
                    modifier = Modifier.size(16.dp).clickable { /* Listen */ }
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Outlined.Refresh,
                    contentDescription = "Regenerate",
                    tint = actionTint,
                    modifier = Modifier.size(16.dp).clickable { /* Regenerate */ }
                )
            }
        }
    }
}