package lopsai.jastin.dashboard.features.share

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun ShareChatDialog(
    onClose: () -> Unit,
    onUpdateLinkClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    isDarkMode: Boolean = false
) {
    // 🎨 PALETA DINÁMICA
    val surfaceBg = if (isDarkMode) Color(0xFF18181B) else ChatBgColor
    val textColor = if (isDarkMode) Color.White else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val dividerColor = if (isDarkMode) Color.White.copy(alpha = 0.1f) else InputBorderColor.copy(alpha = 0.6f)
    val borderColor = if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor

    // 🎛️ BOTÓN INVERTIDO: Destaca perfectamente en cualquier modo
    val buttonBgColor = if (isDarkMode) Color.White else Color.Black
    val buttonContentColor = if (isDarkMode) Color.Black else Color.White

    Dialog(
        onDismissRequest = onClose,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .width(540.dp)
                .fillMaxWidth(0.92f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(24.dp),
            color = surfaceBg,
            shadowElevation = 16.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                // ==========================================
                // 1. CABECERA (TÍTULO Y BOTÓN CERRAR)
                // ==========================================
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Update public link to chat",
                        color = textColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(
                        onClick = onClose,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = "Close",
                            tint = textColor,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = dividerColor, thickness = 1.dp)
                Spacer(modifier = Modifier.height(20.dp))

                // ==========================================
                // 2. TEXTO INFORMATIVO SUPERIOR
                // ==========================================
                val privacyText = buildAnnotatedString {
                    append("Your name, custom instructions, and any messages you add after sharing stay private. ")
                    withStyle(
                        style = SpanStyle(
                            color = textColor,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Learn more")
                    }
                }

                Text(
                    text = privacyText,
                    color = textColor,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                // ==========================================
                // 3. CAMPO DE ENLACE + BOTÓN ACCIÓN
                // ==========================================
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50),
                    color = Color.Transparent,
                    border = BorderStroke(1.dp, borderColor)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 18.dp, top = 6.dp, bottom = 6.dp, end = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "https://lopsai.com/share/..",
                            color = secondaryTextColor.copy(alpha = 0.7f),
                            fontSize = 14.sp,
                            modifier = Modifier.weight(1f).padding(end = 8.dp)
                        )

                        // Botón de acción
                        Button(
                            onClick = {
                                onUpdateLinkClick()
                                onClose()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = buttonBgColor,
                                contentColor = buttonContentColor
                            ),
                            shape = RoundedCornerShape(50),
                            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
                            elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Link,
                                contentDescription = null,
                                tint = buttonContentColor,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Update link",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // ==========================================
                // 4. TEXTO INFORMATIVO INFERIOR
                // ==========================================
                val footerText = buildAnnotatedString {
                    append("A past version of this chat has already been shared. Manage previously shared chats via ")
                    withStyle(
                        style = SpanStyle(
                            color = secondaryTextColor,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Settings")
                    }
                    append(".")
                }

                Text(
                    text = footerText,
                    color = secondaryTextColor,
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier.clickable {
                        onClose()
                        onSettingsClick()
                    }
                )
            }
        }
    }
}