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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.ActionButtonBlack
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.SubtleShadowElevation
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun OmniInput(
    value: String,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit,
    isChatActive: Boolean,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val isVerySmallScreen = maxWidth < 380.dp
        val isCompactWidth = maxWidth < 440.dp

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
            // ==========================================
            // 1. ÁREA DE TEXTO
            // ==========================================
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

            // ==========================================
            // 2. BOTONES INFERIORES ADAPTATIVOS
            // ==========================================
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Grupo izquierdo (Cambia según el estado del chat)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    if (isChatActive) {
                        // MODO CHAT: Interfaz minimalista (+ y Tools)
                        Icon(
                            imageVector = Icons.Outlined.Add,
                            contentDescription = "Add",
                            tint = TextSecondaryDark,
                            modifier = Modifier.size(24.dp).padding(4.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Outlined.Tune, contentDescription = "Tools", tint = TextSecondaryDark, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Tools", color = TextSecondaryDark, fontSize = 14.sp)
                        }
                    } else {
                        // MODO DASHBOARD: Píldoras grandes (Llamando a nuestro nuevo archivo)
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
                    }, label = "SendButtonAnimation"
                ) { hasText ->
                    if (hasText) {
                        // ==================================
                        // BOTÓN ENVIAR (Aparece al escribir)
                        // ==================================
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
                        // ==================================
                        // BOTÓN VOICE (Por defecto)
                        // ==================================
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
    }
}