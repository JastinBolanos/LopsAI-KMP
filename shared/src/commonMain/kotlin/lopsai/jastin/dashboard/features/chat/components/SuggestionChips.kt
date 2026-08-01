package lopsai.jastin.dashboard.features.chat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuggestionChips(
    isDarkMode: Boolean = false,
    modifier: Modifier = Modifier
) {
    // 🎨 PALETA ADAPTATIVA ESTILO VIDRIO ESMERILADO
    val chipBg = if (isDarkMode) Color(0xFF16161A).copy(alpha = 0.85f) else Color.White.copy(alpha = 0.85f)
    val chipBorder = if (isDarkMode) Color(0xFF2E2E38) else Color(0xFFE4E4E7)
    val chipText = if (isDarkMode) Color(0xFFE4E4E7) else Color(0xFF3F3F46)

    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ChipItem(
            icon = Icons.Outlined.Lightbulb,
            iconTint = Color(0xFFEAB308),
            text = "Brainstorm",
            bgColor = chipBg,
            borderColor = chipBorder,
            textColor = chipText
        )
        ChipItem(
            icon = Icons.Outlined.Code,
            iconTint = Color(0xFF3B82F6),
            text = "Code",
            bgColor = chipBg,
            borderColor = chipBorder,
            textColor = chipText
        )
        ChipItem(
            icon = Icons.Outlined.Description,
            iconTint = Color(0xFFF97316),
            text = "Summarize text",
            bgColor = chipBg,
            borderColor = chipBorder,
            textColor = chipText
        )
        ChipItem(
            icon = Icons.Outlined.School,
            iconTint = Color(0xFF6366F1),
            text = "Get advice",
            bgColor = chipBg,
            borderColor = chipBorder,
            textColor = chipText
        )

        // El botón "More"
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(chipBg)
                .border(1.dp, chipBorder, CircleShape)
                .clickable { /* Acción More */ }
                .padding(horizontal = 16.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("More", color = chipText, fontSize = 14.sp)
        }
    }
}

@Composable
private fun ChipItem(
    icon: ImageVector,
    iconTint: Color,
    text: String,
    bgColor: Color,
    borderColor: Color,
    textColor: Color
) {
    Row(
        modifier = Modifier
            .clip(CircleShape)
            .background(bgColor)
            .border(1.dp, borderColor, CircleShape)
            .clickable { /* Acción */ }
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = text, tint = iconTint, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, color = textColor, fontSize = 14.sp)
    }
}