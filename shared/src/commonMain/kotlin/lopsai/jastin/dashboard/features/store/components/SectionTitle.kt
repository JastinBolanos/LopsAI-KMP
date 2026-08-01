package lopsai.jastin.dashboard.features.store.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun SectionTitle(
    title: String,
    subtitle: String,
    isDarkMode: Boolean = false
) {
    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color.White else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark

    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = textColor)
        Text(subtitle, fontSize = 13.sp, color = secondaryTextColor)
    }
}