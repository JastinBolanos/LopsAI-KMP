package lopsai.jastin.dashboard.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark
import lopsai.jastin.dashboard.features.search.components.SearchColors
import lopsai.jastin.dashboard.features.search.sections.DefaultRecentSection
import lopsai.jastin.dashboard.features.search.sections.SimulatedResultsSection

@Composable
fun SearchChatsDialog(
    onClose: () -> Unit,
    onSelectChat: (String) -> Unit = {},
    isDarkMode: Boolean = false
) {
    var query by remember { mutableStateOf("") }

    // 🎨 PALETA DINÁMICA
    val surfaceBg = if (isDarkMode) SearchColors.DialogBgDark else SearchColors.DialogBgLight
    val textColor = if (isDarkMode) Color.White else TextPrimaryDark
    val mutedText = if (isDarkMode) SearchColors.TextMutedDark else SearchColors.TextMutedLight
    val closeBtnBg = if (isDarkMode) Color(0xFF32323A) else Color(0xFFE0E0E0)
    val closeBtnIcon = if (isDarkMode) Color.White else TextSecondaryDark
    val dividerColor = if (isDarkMode) Color.White.copy(alpha = 0.1f) else Color.Black.copy(alpha = 0.06f)

    Dialog(
        onDismissRequest = onClose,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .width(620.dp)
                .fillMaxHeight(0.85f)
                .padding(16.dp),
            shape = RoundedCornerShape(28.dp),
            color = surfaceBg,
            shadowElevation = 16.dp
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // ==========================================
                // 1. BARRA DE BÚSQUEDA SUPERIOR
                // ==========================================
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search",
                        tint = textColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(14.dp))

                    Box(modifier = Modifier.weight(1f)) {
                        BasicTextField(
                            value = query,
                            onValueChange = { query = it },
                            singleLine = true,
                            textStyle = TextStyle(color = textColor, fontSize = 18.sp),
                            cursorBrush = SolidColor(textColor),
                            modifier = Modifier.fillMaxWidth()
                        )
                        if (query.isEmpty()) {
                            Text(
                                text = "Search chats..",
                                color = mutedText,
                                fontSize = 18.sp
                            )
                        }
                    }

                    // Botón X para limpiar o cerrar
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(closeBtnBg)
                            .clickable { if (query.isNotEmpty()) query = "" else onClose() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = "Close",
                            tint = closeBtnIcon,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                HorizontalDivider(color = dividerColor, thickness = 1.dp)

                // ==========================================
                // 2. CONTENIDO DINÁMICO (VACÍO vs BÚSQUEDA)
                // ==========================================
                if (query.isEmpty()) {
                    DefaultRecentSection(
                        onSelectChat = { onSelectChat(it); onClose() },
                        isDarkMode = isDarkMode
                    )
                } else {
                    SimulatedResultsSection(
                        query = query,
                        onSelectChat = { onSelectChat(it); onClose() },
                        isDarkMode = isDarkMode
                    )
                }
            }
        }
    }
}