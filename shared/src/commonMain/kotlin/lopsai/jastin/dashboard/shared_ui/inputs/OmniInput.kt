package lopsai.jastin.dashboard.shared_ui.inputs

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.*
import lopsai.jastin.dashboard.features.chat.components.ChatTool
import lopsai.jastin.dashboard.features.chat.components.ToolsTray

@Composable
fun OmniInput(
    value: String,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit,
    isChatActive: Boolean,
    modifier: Modifier = Modifier
) {
    var showToolsTray by remember { mutableStateOf(false) }
    var selectedTool by remember { mutableStateOf<ChatTool?>(null) }
    val celesteColor = Color(0xFF007AFF)

    // 1. BOX EXTERNO: Permite que la bandeja flote por encima sin deformar la caja blanca
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomStart
    ) {
        val isVerySmallScreen = 360.dp < 380.dp
        val isCompactWidth = 360.dp < 440.dp

        // =========================================================
        // 2. TARJETA PRINCIPAL DEL INPUT (Fondo blanco con borde)
        // =========================================================
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = if (isChatActive) 4.dp else SubtleShadowElevation,
                    shape = RoundedCornerShape(24.dp),
                    clip = false
                )
                .background(ChatBgColor, RoundedCornerShape(24.dp))
                .border(1.dp, InputBorderColor, RoundedCornerShape(24.dp))
                .padding(16.dp)
        ) {
            // Área de texto
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(onSend = { onSend() }),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp, max = 150.dp),
                textStyle = TextStyle(
                    color = TextPrimaryDark,
                    fontSize = 16.sp
                ),
                cursorBrush = SolidColor(TextPrimaryDark),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = "Ask anything",
                            color = TextSecondaryDark,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(if (isChatActive) 16.dp else 32.dp))

            // Fila inferior de botones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Grupo izquierdo (Acciones y herramientas)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    if (isChatActive) {
                        // --- MODO CHAT ---

                        // Botón +
                        IconButton(
                            onClick = { /* Acción Attach */ },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(Icons.Outlined.Add, contentDescription = "Add", tint = Color.Black)
                        }

                        // Botón con la palabra exacta "Tools"
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .clickable { showToolsTray = !showToolsTray }
                                .padding(horizontal = 8.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Tools",
                                color = if (showToolsTray) celesteColor else TextPrimaryDark,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        selectedTool?.let { tool ->
                            Spacer(modifier = Modifier.width(4.dp))
                            // Separador vertical gris suave |
                            Box(
                                modifier = Modifier
                                    .size(width = 1.dp, height = 16.dp)
                                    .background(Color(0xFFE0E0E0))
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            // Píldora Celeste [Icono] Nombre ×
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { selectedTool = null } // Al tocar se remueve
                                    .padding(horizontal = 6.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = tool.icon,
                                    contentDescription = null,
                                    tint = celesteColor,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = tool.shortName,
                                    color = celesteColor,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Icon(
                                    imageVector = Icons.Outlined.Close,
                                    contentDescription = "Remove tool",
                                    tint = celesteColor,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    } else {
                        // --- MODO DASHBOARD ---
                        ActionPill(icon = Icons.Outlined.Add, text = "Attach")
                        ActionPill(icon = Icons.Outlined.Language, text = "Search")

                        if (!isVerySmallScreen) {
                            ActionPill(icon = Icons.Outlined.Lightbulb, text = "Reason")
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Grupo derecho ANIMADO (Micrófono <-> Flecha de Enviar)
                AnimatedContent(
                    targetState = value.isNotEmpty(),
                    transitionSpec = {
                        scaleIn() togetherWith scaleOut()
                    },
                    label = "SendButtonAnimation"
                ) { hasText ->
                    if (hasText) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(ActionButtonBlack)
                                .clickable { onSend() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowUpward,
                                contentDescription = "Send",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    } else {
                        Row(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(if (isChatActive) Color.Transparent else ActionButtonBlack)
                                .clickable { /* Acción Voice */ },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Mic,
                                contentDescription = "Voice",
                                tint = if (isChatActive) ActionButtonBlack else Color.White,
                                modifier = Modifier.padding(8.dp).size(20.dp)
                            )

                            if (!isCompactWidth && !isChatActive) {
                                Text(
                                    text = "Voice",
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(end = 12.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // =========================================================
        // 3. CAPA SUPERIOR: BANDEJA FLOTANTE INDEPENDIENTE
        // =========================================================
        if (showToolsTray) {
            ToolsTray(
                onToolSelected = { tool ->
                    selectedTool = tool
                    showToolsTray = false
                },
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 60.dp)
            )
        }
    }
}
