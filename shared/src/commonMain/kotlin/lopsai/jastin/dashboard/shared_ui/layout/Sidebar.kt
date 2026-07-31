package lopsai.jastin.dashboard.shared_ui.layout

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import lopsai.jastin.dashboard.core.models.AppScreen
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark
import lopsai.jastin.dashboard.features.chat.data.MockChatsData
import androidx.compose.animation.core.*
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun Sidebar(
    currentScreen: AppScreen,
    onClose: () -> Unit,
    onNavigateToGpts: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    onNavigateToLibrary: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onSelectChat: (String) -> Unit = {},
    isMobile: Boolean = false,
    modifier: Modifier = Modifier
) {
    val sidebarBg = Color(0xFFF9F9F9)
    val hoverBg = Color(0xFFECECEC)
    var comingSoonText by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(comingSoonText) {
        if (comingSoonText != null) {
            delay(2000L)
            comingSoonText = null
        }
    }

    Box(modifier = modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(sidebarBg)
        ) {
            // ==========================================
            // 1. TOP FIJO (Logo y Cerrar manualmente)
            // ==========================================
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 16.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.AutoAwesome,
                    contentDescription = "Logo",
                    modifier = Modifier.size(24.dp).padding(4.dp),
                    tint = TextPrimaryDark
                )
                Icon(
                    imageVector = Icons.Outlined.ViewSidebar,
                    contentDescription = "Close Sidebar",
                    tint = TextSecondaryDark,
                    modifier = Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .clickable { onClose() }
                        .padding(4.dp)
                )
            }

            // ==========================================
            // 2. ZONA CON SCROLL (Menú + Chats)
            // ==========================================
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    // 1. Botón New Chat (Estilo Linear App Active Accent)
                    val isNewChatActive = currentScreen == AppScreen.Dashboard
                    val activeBrush = if (isNewChatActive) {
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF6366F1).copy(alpha = 0.12f),
                                Color.Transparent
                            )
                        )
                    } else {
                        Brush.linearGradient(listOf(Color.Transparent, Color.Transparent))
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(activeBrush)
                            .clickable {
                                onNavigateToHome()
                                if (isMobile) onClose()
                            }
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            // PÍLDORA NEÓN VERTICAL
                            if (isNewChatActive) {
                                Box(
                                    modifier = Modifier
                                        .width(3.dp)
                                        .height(24.dp)
                                        .clip(RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp))
                                        .background(Color(0xFF6366F1)) // Acento Índigo
                                )
                            } else {
                                Spacer(modifier = Modifier.width(3.dp))
                            }

                            Box(modifier = Modifier.weight(1f)) {
                                SidebarItem(icon = Icons.Outlined.Edit, text = "New chat")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // 2. Search Box
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFFFFFFF), RoundedCornerShape(10.dp))
                            .drawBehind {
                                // Sutil contorno metálico/vidrio de 1px
                                drawRoundRect(
                                    color = Color(0xFFDCDCDC),
                                    size = size,
                                    cornerRadius = CornerRadius(10.dp.toPx()),
                                    style = androidx.compose.ui.graphics.drawscope.Stroke(1.dp.toPx())
                                )
                            }
                            .clickable {
                                onSearchClick()
                                if (isMobile) onClose()
                            }
                            .padding(horizontal = 12.dp, vertical = 9.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = "Search",
                                modifier = Modifier.size(16.dp),
                                tint = Color(0xFF6366F1)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Search chats...", fontSize = 13.sp, color = TextPrimaryDark, fontWeight = FontWeight.Medium)
                        }
                        // Píldora de comando estilo teclado nativo
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFFF0F0F0))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text("⌘K", fontSize = 11.sp, color = TextSecondaryDark, fontWeight = FontWeight.SemiBold)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // 3. Botón Library
                    val libraryBg = if (currentScreen == AppScreen.Library) hoverBg else Color.Transparent
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(libraryBg)
                            .clickable {
                                onNavigateToLibrary()
                                if (isMobile) onClose()
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.LibraryBooks, text = "Library", trailingText = "11")
                    }

                    // ========================================================
                    // 4. SORA (TOCABLE CON AVISO TEMPORAL "PRÓXIMAMENTE")
                    // ========================================================
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                comingSoonText = "Sora: Próximamente..."
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.PlayCircleOutline, text = "Sora")
                    }

                    // 5. Botón GPTs
                    val gptsBg = if (currentScreen == AppScreen.GptStore) hoverBg else Color.Transparent
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(gptsBg)
                            .clickable {
                                onNavigateToGpts()
                                if (isMobile) onClose()
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.GridView, text = "GPTs")
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Content", fontSize = 12.sp, color = TextSecondaryDark, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

                    // ========================================================
                    // 6. CANVA (TOCABLE CON AVISO TEMPORAL "PRÓXIMAMENTE")
                    // ========================================================
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                comingSoonText = "Canva: Próximamente..."
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.Brush, text = "Canva")
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Chats", fontSize = 12.sp, color = TextSecondaryDark, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
                }

                val chatsList = MockChatsData.chatTitles

                items(chatsList) { chatTitle ->
                    val interactionSource = remember { MutableInteractionSource() }
                    Text(
                        text = chatTitle,
                        fontSize = 13.sp,
                        color = TextPrimaryDark,
                        maxLines = 1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .clickable(interactionSource = interactionSource, indication = null) {
                                onSelectChat(chatTitle)
                                if (isMobile) onClose()
                            }
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                    )
                }
            }

            // =========================================================
            // ✨ 3. BOTTOM FIJO: AURORA VIP UPGRADE CARD (ESTILO CHATGPT PLUS)
            // =========================================================
            val vipTransition = rememberInfiniteTransition(label = "VipCardAnim")

            // 1. Rotación lenta y elegante de la estrella VIP
            val starRotation by vipTransition.animateFloat(
                initialValue = -10f,
                targetValue = 10f,
                animationSpec = infiniteRepeatable(
                    animation = tween(2500, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "StarRotate"
            )

            // 2. Desplazamiento del resplandor Aurora en el borde
            val auroraOffset by vipTransition.animateFloat(
                initialValue = 0f,
                targetValue = 800f,
                animationSpec = infiniteRepeatable(
                    animation = tween(4500, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                ),
                label = "AuroraOffset"
            )

            val auroraBorderBrush = remember(auroraOffset) {
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF6366F1), // Índigo
                        Color(0xFFA855F7), // Púrpura
                        Color(0xFFEC4899), // Rosa Neón
                        Color(0xFF00F2FE), // Cian
                        Color(0xFF6366F1)  // Cierre de bucle
                    ),
                    start = Offset(auroraOffset, 0f),
                    end = Offset(auroraOffset + 300f, 300f)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    // Borde Aurora de 1.5.dp con esquinas de 12.dp
                    .background(Color(0xFFFFFFFF), RoundedCornerShape(12.dp))
                    .drawBehind {
                        drawRoundRect(
                            brush = auroraBorderBrush,
                            size = size,
                            cornerRadius = CornerRadius(12.dp.toPx()),
                            // Dibujamos solo el contorno externo
                            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.5.dp.toPx())
                        )
                    }
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { }
                    .padding(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AutoAwesome,
                        contentDescription = "Upgrade",
                        modifier = Modifier
                            .size(24.dp)
                            .graphicsLayer {
                                rotationZ = starRotation
                            },
                        tint = Color(0xFF6366F1) // Color Índigo Premium
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Upgrade plan",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimaryDark
                        )
                        Text(
                            text = "More access to the best models",
                            fontSize = 11.sp,
                            color = TextSecondaryDark
                        )
                    }
                }
            }
        }

        // ================================================================
        // 4. BANNER EPÍMERO ANIMADO (TOAST MULTIPLATAFORMA)
        // ================================================================
        AnimatedVisibility(
            visible = comingSoonText != null,
            enter = fadeIn() + slideInVertically(initialOffsetY = { 40 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { 40 }),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
                .padding(horizontal = 16.dp)
        ) {
            comingSoonText?.let { text ->
                Row(
                    modifier = Modifier
                        .shadow(8.dp, RoundedCornerShape(50))
                        .background(Color(0xFF222222), RoundedCornerShape(50))
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = text,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}