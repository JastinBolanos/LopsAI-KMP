package lopsai.jastin.dashboard.features.chat.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun AITypingBubble(fullText: String, isTyping: Boolean) {
    var displayedText by remember { mutableStateOf(if (isTyping) "" else fullText) }
    var showActions by remember { mutableStateOf(!isTyping) }

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
            color = TextPrimaryDark,
            fontSize = 15.sp,
            lineHeight = 24.sp,
            modifier = Modifier.padding(end = 24.dp)
        )

        AnimatedVisibility(
            visible = showActions,
            enter = fadeIn(tween(400)) + slideInVertically(tween(400)) { it / 2 }
        ) {
            Row(modifier = Modifier.padding(top = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.ContentCopy, contentDescription = "Copy", tint = TextSecondaryDark, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Icon(Icons.Outlined.ThumbUp, contentDescription = "Like", tint = TextSecondaryDark, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Icon(Icons.Outlined.ThumbDown, contentDescription = "Dislike", tint = TextSecondaryDark, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Icon(Icons.Outlined.VolumeUp, contentDescription = "Listen", tint = TextSecondaryDark, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Icon(Icons.Outlined.Refresh, contentDescription = "Regenerate", tint = TextSecondaryDark, modifier = Modifier.size(16.dp))
            }
        }
    }
}