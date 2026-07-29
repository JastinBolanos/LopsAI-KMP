package lopsai.jastin.dashboard.features.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.KeyboardReturn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

object SearchColors {
    val DialogBg = Color(0xFFEFEFEF)
    val SelectedItemBg = Color(0xFFDFDFDF)
    val HighlightBlue = Color(0xFF007AFF)
    val TextMuted = Color(0xFF888888)
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        color = SearchColors.TextMuted,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 12.dp, top = 16.dp, bottom = 8.dp)
    )
}

@Composable
fun RecentChatRow(
    title: String,
    isSelected: Boolean,
    onSelectChat: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(if (isSelected) SearchColors.SelectedItemBg else Color.Transparent)
            .clickable { onSelectChat(title) }
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.ChatBubbleOutline,
                contentDescription = null,
                tint = TextPrimaryDark,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(title, fontSize = 14.sp, color = TextPrimaryDark)
        }

        if (isSelected) {
            Icon(
                imageVector = Icons.Outlined.KeyboardReturn,
                contentDescription = "Select",
                tint = TextSecondaryDark,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}