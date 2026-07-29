package lopsai.jastin.dashboard.shared_ui.layout

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.IosShare
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun TopHeader(
    isSidebarVisible: Boolean,
    isChatActive: Boolean,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val isMobile = maxWidth < 600.dp
        val showButtonText = maxWidth > 380.dp

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // ==========================================
            // IZQUIERDA: Menú Hamburguesa y Selector de Modelo
            // ==========================================
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (!isSidebarVisible) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = "Open Menu",
                        tint = TextSecondaryDark,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .clickable { onMenuClick() }
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }

                // BOX ANCLA PARA EL MENÚ DESPLEGABLE
                Box {
                    var isModelMenuExpanded by remember { mutableStateOf(false) }

                    // Estados para simular la selección de modelos (¡Excelente toque lo de GPT-5!)
                    var selectedModel by remember { mutableStateOf("GPT-5") }
                    var isReasoningExtended by remember { mutableStateOf(true) }

                    // Animación de rotación para la flechita
                    val arrowRotation by animateFloatAsState(
                        targetValue = if (isModelMenuExpanded) 180f else 0f,
                        animationSpec = spring(dampingRatio = Spring.DampingRatioNoBouncy, stiffness = Spring.StiffnessLow),
                        label = "ArrowRotation"
                    )

                    // El Título Clicable
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { isModelMenuExpanded = true }
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text("LopsAI", color = TextPrimaryDark, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Menu",
                            tint = TextSecondaryDark,
                            modifier = Modifier
                                .size(20.dp)
                                .graphicsLayer { rotationZ = arrowRotation }
                        )
                    }

                    // EL MENÚ DESPLEGABLE
                    MaterialTheme(
                        shapes = MaterialTheme.shapes.copy(extraSmall = RoundedCornerShape(16.dp))
                    ) {
                        DropdownMenu(
                            expanded = isModelMenuExpanded,
                            onDismissRequest = { isModelMenuExpanded = false },
                            offset = DpOffset(x = 0.dp, y = 8.dp),
                            modifier = Modifier
                                .width(340.dp)
                                .background(Color.White)
                                .padding(vertical = 8.dp)
                        ) {
                            ChatGptModelItem(
                                title = "GPT-4o mini",
                                subtitle = "Faster everyday responses",
                                isSelected = selectedModel == "GPT-4o mini",
                                badgeText = "New",
                                onClick = { selectedModel = "GPT-4o mini"; isModelMenuExpanded = false }
                            )

                            ChatGptModelItem(
                                title = "GPT-4o",
                                subtitle = "General assistance",
                                isSelected = selectedModel == "GPT-4o",
                                badgeText = "New",
                                onClick = { selectedModel = "GPT-4o"; isModelMenuExpanded = false }
                            )

                            ChatGptModelItem(
                                title = "GPT-5",
                                subtitle = "Math & advanced programming",
                                isSelected = selectedModel == "GPT-5",
                                onClick = { selectedModel = "GPT-5"; isModelMenuExpanded = false }
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 8.dp),
                                color = InputBorderColor.copy(alpha = 0.5f)
                            )

                            ChatGptModelItem(
                                title = "GPT-5.5",
                                subtitle = "Extended reasoning for complex...",
                                isSelected = isReasoningExtended,
                                onClick = {
                                    isReasoningExtended = !isReasoningExtended
                                    isModelMenuExpanded = false
                                }
                            )
                        }
                    }
                }
            }

            // ==========================================
            // DERECHA: Botón Animado pegado al Avatar
            // ==========================================
            Row(verticalAlignment = Alignment.CenterVertically) {
                AnimatedContent(
                    targetState = isChatActive,
                    transitionSpec = { fadeIn(tween(400)) togetherWith fadeOut(tween(400)) },
                    label = "HeaderButtonTransition"
                ) { active ->
                    if (active) {
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .border(1.dp, InputBorderColor, RoundedCornerShape(50))
                                .clickable { }
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Outlined.IosShare, contentDescription = "Share", tint = TextPrimaryDark, modifier = Modifier.size(16.dp))
                            if (showButtonText && !isMobile) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Share", color = TextPrimaryDark, fontSize = 13.sp)
                            }
                        }
                    } else {
                        val interactionSource = remember { MutableInteractionSource() }
                        val isPressed by interactionSource.collectIsPressedAsState()

                        val buttonScale by animateFloatAsState(
                            targetValue = if (isPressed) 0.92f else 1f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow),
                            label = "ButtonScale"
                        )
                        val iconRotation by animateFloatAsState(
                            targetValue = if (isPressed) 72f else 0f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow),
                            label = "IconRotation"
                        )

                        Row(
                            modifier = Modifier
                                .graphicsLayer { scaleX = buttonScale; scaleY = buttonScale }
                                .clip(if (showButtonText) RoundedCornerShape(50) else CircleShape)
                                .background(Color(0xFFEDE9FE))
                                .clickable(interactionSource = interactionSource, indication = null) { }
                                .padding(horizontal = if (showButtonText) 14.dp else 8.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.AutoAwesome, contentDescription = "Sparkle",
                                tint = Color(0xFF6366F1), modifier = Modifier.size(16.dp).graphicsLayer { rotationZ = iconRotation }
                            )
                            if (showButtonText) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Get started", color = Color(0xFF6366F1), fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier.size(32.dp).clip(CircleShape).background(Color(0xFF10A37F)).clickable { },
                    contentAlignment = Alignment.Center
                ) {
                    Text("JA", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            }
        }
    }
}