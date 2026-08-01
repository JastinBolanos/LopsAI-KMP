package lopsai.jastin.dashboard.features.store.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark

@Composable
fun SeeMoreButton(isDarkMode: Boolean = false) {

    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color.White else TextPrimaryDark
    val borderColor = if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50))
            .border(1.dp, borderColor, RoundedCornerShape(50))
            .clickable { }
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("See more", fontSize = 14.sp, color = textColor)
    }
}