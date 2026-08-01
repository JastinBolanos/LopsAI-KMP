package lopsai.jastin.dashboard.features.library.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun LibraryTopBar(
    isMobile: Boolean,
    isDarkMode: Boolean = false,
    onCreateImageClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val btnBgColor = if (isDarkMode) Color(0xFF262630) else ChatBgColor
    val btnBorderColor = if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "My Library",
            color = textColor,
            fontSize = if (isMobile) 22.sp else 24.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = onCreateImageClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = btnBgColor,
                contentColor = textColor
            ),
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, btnBorderColor),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp)
        ) {
            Text(text = "+ Create image", fontSize = 13.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun FloatingHelpButton(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false,
    onClick: () -> Unit = {}
) {
    // 🎨 PALETA DINÁMICA
    val bgColor = if (isDarkMode) Color(0xFF262630) else ChatBgColor
    val borderColor = if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor
    val textColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark

    Box(
        modifier = modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(bgColor)
            .border(1.dp, borderColor, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text("?", color = textColor, fontSize = 15.sp, fontWeight = FontWeight.Medium)
    }
}