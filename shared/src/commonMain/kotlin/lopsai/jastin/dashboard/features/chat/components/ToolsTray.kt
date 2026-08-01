package lopsai.jastin.dashboard.features.chat.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

// 1. Modelo con el nombre completo para la bandeja y el nombre corto para el chip
enum class ChatTool(
    val fullName: String,
    val shortName: String,
    val icon: ImageVector,
    val trailingText: String? = null
) {
    IMAGE("Create an image", "Image", Icons.Outlined.Brush),
    SEARCH("Search the web", "Search", Icons.Outlined.Language),
    CODE("Write or code", "Code", Icons.Outlined.Edit),
    RESEARCH("Run deep research", "Research", Icons.Outlined.ManageSearch, "5 left"),
    REASON("Think for longer", "Reason", Icons.Outlined.Lightbulb)
}

// 2. Componente visual de la bandeja flotante
@Composable
fun ToolsTray(
    onToolSelected: (ChatTool) -> Unit,
    isDarkMode: Boolean = false,
    modifier: Modifier = Modifier
) {
    // 🎨 PALETA DINÁMICA DE LA BANDEJA
    val bgColor = if (isDarkMode) Color(0xFF18181B) else Color.White
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark.copy(alpha = 0.7f)

    Surface(
        modifier = modifier
            .width(260.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp),
        color = bgColor,
        shadowElevation = 12.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp)
        ) {
            ChatTool.entries.forEach { tool ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .clickable { onToolSelected(tool) }
                        .padding(horizontal = 14.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = tool.icon,
                            contentDescription = null,
                            tint = textColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        Text(
                            text = tool.fullName,
                            color = textColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    if (tool.trailingText != null) {
                        Text(
                            text = tool.trailingText,
                            color = secondaryTextColor,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
    }
}