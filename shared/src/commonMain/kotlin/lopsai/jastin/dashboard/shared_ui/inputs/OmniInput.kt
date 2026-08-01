package lopsai.jastin.dashboard.shared_ui.inputs

import androidx.compose.animation.*
import androidx.compose.animation.core.*
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
    isDarkMode: Boolean = false,
    modifier: Modifier = Modifier
) {
    var showToolsTray by remember { mutableStateOf(false) }
    var selectedTool by remember { mutableStateOf<ChatTool?>(null) }
    val celesteColor = Color(0xFF007AFF)

    // 🎨 PALETA NEGRO PLOMO SEMITRANSPARENTE (DARK) VS BLANCO (LIGHT)
    val inputBg = if (isDarkMode) Color(0xFF16161C).copy(alpha = 0.88f) else ChatBgColor
    val textPrimary = if (isDarkMode) Color(0xFFFFFFFF) else TextPrimaryDark
    val textSecondary = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val pillBg = if (isDarkMode) Color(0xFF262630) else Color(0xFFF4F4F5)
    val pillBorderColor = if (isDarkMode) Color(0xFF3F3F4E) else Color(0xFFE4E4E7)
    val actionButtonColor = if (isDarkMode) Color(0xFFFFFFFF) else ActionButtonBlack
    val actionButtonIconTint = if (isDarkMode) Color(0xFF16161C) else Color.White
    val dividerColor = if (isDarkMode) Color(0xFF32323A) else Color(0xFFE0E0E0)

    val infiniteTransition = rememberInfiniteTransition(label = "CirculatingBorder")

    val borderOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "BorderOffset"
    )

    val circulatingBrush = remember(borderOffset) {
        Brush.linearGradient(
            colors = listOf(
                Color(0xFF6366F1),
                Color(0xFFA855F7),
                Color(0xFFEC4899),
                Color(0xFF00F2FE),
                Color(0xFF6366F1)
            ),
            start = Offset(borderOffset, 0f),
            end = Offset(borderOffset + 400f, 400f)
        )
    }

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomStart
    ) {
        val isVerySmallScreen = 360.dp < 380.dp
        val isCompactWidth = 360.dp < 440.dp

        // =========================================================
        // 🚀 TARJETA PRINCIPAL BLINDADA CONTRA RECTÁNGULOS FANTASMA
        // =========================================================
        Column(
            modifier = Modifier
                .fillMaxWidth()
                // ⚡ 1. EXTERMINIO DEL CUADRADO: Sombra 0.dp en Dark Mode y recorte estricto activado (clip = true)
                .shadow(
                    elevation = if (isDarkMode) 0.dp else if (isChatActive) 4.dp else 2.dp,
                    shape = RoundedCornerShape(24.dp),
                    clip = true
                )
                // ⚡ 2. RECORTE MATEMÁTICO: Obliga al lienzo a curvarse a 24.dp antes de pintar el fondo
                .clip(RoundedCornerShape(24.dp))
                .background(inputBg)
                .border(
                    width = 2.dp,
                    brush = circulatingBrush,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(16.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(onSend = { onSend() }),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp, max = 150.dp),
                textStyle = TextStyle(
                    color = textPrimary,
                    fontSize = 16.sp
                ),
                cursorBrush = SolidColor(textPrimary),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = "Ask anything",
                            color = textSecondary,
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(if (isChatActive) 16.dp else 32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    if (isChatActive) {
                        IconButton(
                            onClick = { /* Acción Attach */ },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(Icons.Outlined.Add, contentDescription = "Add", tint = textPrimary)
                        }

                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .clickable { showToolsTray = !showToolsTray }
                                .padding(horizontal = 8.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Tools",
                                color = if (showToolsTray) celesteColor else textPrimary,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        selectedTool?.let { tool ->
                            Spacer(modifier = Modifier.width(4.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 1.dp, height = 16.dp)
                                    .background(dividerColor)
                            )
                            Spacer(modifier = Modifier.width(8.dp))

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { selectedTool = null }
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
                        ActionPill(
                            icon = Icons.Outlined.Add,
                            text = "Attach",
                            bgColor = pillBg,
                            borderColor = pillBorderColor,
                            contentColor = textPrimary
                        )
                        ActionPill(
                            icon = Icons.Outlined.Language,
                            text = "Search",
                            bgColor = pillBg,
                            borderColor = pillBorderColor,
                            contentColor = textPrimary
                        )

                        if (!isVerySmallScreen) {
                            ActionPill(
                                icon = Icons.Outlined.Lightbulb,
                                text = "Reason",
                                bgColor = pillBg,
                                borderColor = pillBorderColor,
                                contentColor = textPrimary
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                AnimatedContent(
                    targetState = value.isNotEmpty(),
                    transitionSpec = { scaleIn() togetherWith scaleOut() },
                    label = "SendButtonAnimation"
                ) { hasText ->
                    if (hasText) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(actionButtonColor)
                                .clickable { onSend() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowUpward,
                                contentDescription = "Send",
                                tint = actionButtonIconTint,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    } else {
                        Row(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(if (isChatActive) Color.Transparent else actionButtonColor)
                                .clickable { /* Acción Voice */ },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Mic,
                                contentDescription = "Voice",
                                tint = if (isChatActive) textPrimary else actionButtonIconTint,
                                modifier = Modifier.padding(8.dp).size(20.dp)
                            )

                            if (!isCompactWidth && !isChatActive) {
                                Text(
                                    text = "Voice",
                                    color = actionButtonIconTint,
                                    fontSize = 13.sp,
                                    modifier = Modifier.padding(end = 12.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        if (showToolsTray) {
            ToolsTray(
                onToolSelected = { tool ->
                    selectedTool = tool
                    showToolsTray = false
                },
                isDarkMode = isDarkMode,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 60.dp)
            )
        }
    }
}

@Composable
private fun ActionPill(
    icon: ImageVector,
    text: String,
    bgColor: Color = Color(0xFFF4F4F5),
    borderColor: Color = Color(0xFFE4E4E7),
    contentColor: Color = Color.Black
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(bgColor)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { /* Acción de la herramienta */ }
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = contentColor,
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = text,
            color = contentColor,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium
        )
    }
}