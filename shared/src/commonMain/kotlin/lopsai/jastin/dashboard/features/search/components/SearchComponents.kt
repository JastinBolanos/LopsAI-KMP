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
    val DialogBgLight = Color(0xFFEFEFEF)
    val DialogBgDark = Color(0xFF18181B)

    val SelectedItemBgLight = Color(0xFFDFDFDF)
    val SelectedItemBgDark = Color(0xFF262630)

    val TextMutedLight = Color(0xFF888888)
    val TextMutedDark = Color(0xFFA1A1AA)

    val HighlightBlue = Color(0xFF007AFF)
}

@Composable
fun SectionHeader(title: String, isDarkMode: Boolean = false) {
    Text(
        text = title,
        color = if (isDarkMode) SearchColors.TextMutedDark else SearchColors.TextMutedLight,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 12.dp, top = 16.dp, bottom = 8.dp)
    )
}

@Composable
fun RecentChatRow(
    title: String,
    isSelected: Boolean,
    onSelectChat: (String) -> Unit,
    isDarkMode: Boolean = false
) {
    val textColor = if (isDarkMode) Color.White else TextPrimaryDark
    val iconColor = if (isDarkMode) SearchColors.TextMutedDark else TextPrimaryDark
    val bgSelected = if (isDarkMode) SearchColors.SelectedItemBgDark else SearchColors.SelectedItemBgLight

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(if (isSelected) bgSelected else Color.Transparent)
            .clickable { onSelectChat(title) }
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.ChatBubbleOutline,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(title, fontSize = 14.sp, color = textColor)
        }

        if (isSelected) {
            Icon(
                imageVector = Icons.Outlined.KeyboardReturn,
                contentDescription = "Select",
                tint = if (isDarkMode) Color.White else TextSecondaryDark,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}