package lopsai.jastin.dashboard.shared_ui.layout

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import lopsai.jastin.dashboard.core.models.AppScreen
import lopsai.jastin.dashboard.features.chat.data.MockChatsData
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

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
    isDarkMode: Boolean = false,
    modifier: Modifier = Modifier
) {
    // 🎨 PALETA DINÁMICA CON NEGRO ULTRA OSCURO (OLED BLACK #050507)
    val sidebarBg = if (isDarkMode) Color(0xFF050507) else Color(0xFFF9F9F9)
    val hoverBg = if (isDarkMode) Color(0xFF16161A) else Color(0xFFECECEC)
    val textColorPrimary = if (isDarkMode) Color(0xFFEDEDED) else Color(0xFF111111)
    val textColorSecondary = if (isDarkMode) Color(0xFF9CA3AF) else Color(0xFF6B7280)
    val searchBg = if (isDarkMode) Color(0xFF16161A) else Color(0xFFFFFFFF)
    val searchBorder = if (isDarkMode) Color(0xFF28282E) else Color(0xFFDCDCDC)
    val commandBadgeBg = if (isDarkMode) Color(0xFF222228) else Color(0xFFF0F0F0)
    val cardBg = if (isDarkMode) Color(0xFF111114) else Color(0xFFFFFFFF)
    val baseWashColor = if (isDarkMode) Color(0xFFFFFFFF) else Color(0xFF111111)

    var comingSoonText by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(comingSoonText) {
        if (comingSoonText != null) {
            delay(2000L)
            comingSoonText = null
        }
    }

    // 🌐 FONDO EN EL BOX RAÍZ -> Cubre hasta el techo (píxel 0) detrás de la hora/batería
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(sidebarBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            // =========================================================================
            // ✨ 1. TOP FIJO: ESTRELLA RODANTE + REVELADO CINEMÁTICO "LopsAI"
            // =========================================================================
            val headerTransition = rememberInfiniteTransition(label = "LopsAiRevealAnim")

            val revealProgress by headerTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 2800, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "RevealProgress"
            )

            val starWheelRotation by headerTransition.animateFloat(
                initialValue = 0f,
                targetValue = 720f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 2800, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "StarWheelRotate"
            )

            // =========================================================================
            // 🌊 EL BAÑO LÍQUIDO: BASE DINÁMICA + OLA QUE MANCHA Y SE RETIRA
            // =========================================================================
            val washOffset by headerTransition.animateFloat(
                initialValue = -350f,
                targetValue = 550f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 3500, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                ),
                label = "LiquidWashOffset"
            )

            val lopsAiWashBrush = remember(washOffset, baseWashColor) {
                Brush.linearGradient(
                    colors = listOf(
                        baseWashColor,     // 1. Color de texto normal antes de la ola
                        baseWashColor,     //    Margen de color normal
                        Color(0xFF00F2FE), // 2. Entrada de agua (Cian cristalino)
                        Color(0xFFA855F7), // 3. Centro vibrante (Púrpura perlado)
                        Color(0xFFEC4899), // 4. Estela neón (Rosa)
                        baseWashColor,     // 5. Retorno al color normal
                        baseWashColor      //    Retirada total
                    ),
                    start = Offset(washOffset, 0f),
                    end = Offset(washOffset + 300f, 0f)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 16.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val maxTextWidthPx = with(androidx.compose.ui.platform.LocalDensity.current) { 88.dp.toPx() }

                Box(
                    modifier = Modifier
                        .height(36.dp)
                        .width(120.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .drawWithContent {
                                val currentWidth = maxTextWidthPx * revealProgress
                                clipRect(
                                    left = 0f,
                                    top = 0f,
                                    right = currentWidth,
                                    bottom = size.height
                                ) {
                                    this@drawWithContent.drawContent()
                                }
                            },
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "LopsAI",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            maxLines = 1,
                            style = androidx.compose.ui.text.TextStyle(
                                brush = lopsAiWashBrush
                            ),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .offset {
                                val currentX = (maxTextWidthPx * revealProgress).roundToInt()
                                IntOffset(x = currentX, y = 0)
                            }
                            .size(28.dp)
                            .graphicsLayer {
                                rotationZ = starWheelRotation
                                clip = false
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AutoAwesome,
                            contentDescription = "LopsAI Animated Star",
                            modifier = Modifier.size(22.dp),
                            tint = Color(0xFF6366F1)
                        )
                    }
                }

                Icon(
                    imageVector = Icons.Outlined.ViewSidebar,
                    contentDescription = "Close Sidebar",
                    tint = textColorSecondary,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .epicClickBurst { onClose() }
                        .padding(6.dp)
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

                    // 1. Botón New Chat
                    val isNewChatActive = currentScreen == AppScreen.Dashboard
                    val activeBrush = if (isNewChatActive) {
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF6366F1).copy(alpha = if (isDarkMode) 0.25f else 0.12f),
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
                            if (isNewChatActive) {
                                Box(
                                    modifier = Modifier
                                        .width(3.dp)
                                        .height(24.dp)
                                        .clip(RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp))
                                        .background(Color(0xFF6366F1))
                                )
                            } else {
                                Spacer(modifier = Modifier.width(3.dp))
                            }

                            Box(modifier = Modifier.weight(1f)) {
                                SidebarItem(
                                    icon = Icons.Outlined.Edit,
                                    text = "New chat",
                                    tint = textColorPrimary
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // 2. Search Box
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(searchBg, RoundedCornerShape(10.dp))
                            .drawBehind {
                                drawRoundRect(
                                    color = searchBorder,
                                    size = size,
                                    cornerRadius = CornerRadius(10.dp.toPx()),
                                    style = Stroke(1.dp.toPx())
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
                            Text(
                                text = "Search chats...",
                                fontSize = 13.sp,
                                color = textColorPrimary,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(commandBadgeBg)
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "⌘K",
                                fontSize = 11.sp,
                                color = textColorSecondary,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // 3. Botón Library -> AHORA PASA tint = textColorPrimary (BLANCO EN DARK MODE)
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
                        SidebarItem(
                            icon = Icons.Outlined.LibraryBooks,
                            text = "Library",
                            trailingText = "11",
                            tint = textColorPrimary // ⚡ SOLUCIONADO
                        )
                    }

                    // 4. SORA -> AHORA PASA tint = textColorPrimary (BLANCO EN DARK MODE)
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                comingSoonText = "Sora: Próximamente..."
                            }
                    ) {
                        SidebarItem(
                            icon = Icons.Outlined.PlayCircleOutline,
                            text = "Sora",
                            tint = textColorPrimary // ⚡ SOLUCIONADO
                        )
                    }

                    // 5. Botón GPTs -> AHORA PASA tint = textColorPrimary (BLANCO EN DARK MODE)
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
                        SidebarItem(
                            icon = Icons.Outlined.GridView,
                            text = "GPTs",
                            tint = textColorPrimary // ⚡ SOLUCIONADO
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Content",
                        fontSize = 12.sp,
                        color = textColorSecondary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )

                    // 6. CANVA -> AHORA PASA tint = textColorPrimary (BLANCO EN DARK MODE)
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                comingSoonText = "Canva: Próximamente..."
                            }
                    ) {
                        SidebarItem(
                            icon = Icons.Outlined.Brush,
                            text = "Canva",
                            tint = textColorPrimary // ⚡ SOLUCIONADO
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Chats",
                        fontSize = 12.sp,
                        color = textColorSecondary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                val chatsList = MockChatsData.chatTitles

                items(chatsList) { chatTitle ->
                    Text(
                        text = chatTitle,
                        fontSize = 13.sp,
                        color = textColorPrimary,
                        maxLines = 1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .epicClickBurst {
                                onSelectChat(chatTitle)
                                if (isMobile) onClose()
                            }
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                    )
                }
            }

            // =========================================================
            // ✨ 3. BOTTOM FIJO: AURORA VIP UPGRADE CARD
            // =========================================================
            val vipTransition = rememberInfiniteTransition(label = "VipCardAnim")

            val starRotation by vipTransition.animateFloat(
                initialValue = -10f,
                targetValue = 10f,
                animationSpec = infiniteRepeatable(
                    animation = tween(2500, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "StarRotate"
            )

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
                    .background(cardBg, RoundedCornerShape(12.dp))
                    .drawBehind {
                        drawRoundRect(
                            brush = auroraBorderBrush,
                            size = size,
                            cornerRadius = CornerRadius(12.dp.toPx()),
                            style = Stroke(width = 1.5.dp.toPx())
                        )
                    }
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { }
                    .padding(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.AutoAwesome,
                        contentDescription = "Upgrade",
                        modifier = Modifier
                            .size(24.dp)
                            .graphicsLayer {
                                rotationZ = starRotation
                            },
                        tint = Color(0xFF6366F1)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Upgrade plan",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = textColorPrimary
                        )
                        Text(
                            text = "More access to the best models",
                            fontSize = 11.sp,
                            color = textColorSecondary
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
                        .background(if (isDarkMode) Color(0xFF222228) else Color(0xFF222222), RoundedCornerShape(50))
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

// =====================================================================
// MODIFICADOR: EXPLOSIÓN DE PARTÍCULAS + ONDA DE CHOQUE (SKIA)
// =====================================================================
@Composable
fun Modifier.epicClickBurst(
    onClick: () -> Unit
): Modifier {
    val scale = remember { Animatable(1f) }
    val burstProgress = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    return this
        .scale(scale.value)
        .pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    scale.animateTo(0.93f, tween(100, easing = FastOutSlowInEasing))
                    tryAwaitRelease()
                    coroutineScope.launch {
                        scale.animateTo(
                            targetValue = 1f,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        )
                    }
                },
                onTap = {
                    onClick()
                    coroutineScope.launch {
                        burstProgress.snapTo(0f)
                        burstProgress.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(450, easing = FastOutSlowInEasing)
                        )
                    }
                }
            )
        }
        .drawBehind {
            val p = burstProgress.value
            if (p > 0f && p < 1f) {
                val maxRadius = size.width.coerceAtLeast(size.height) * 0.7f
                val centerOffset = Offset(size.width / 2f, size.height / 2f)
                val alpha = (1f - p).coerceIn(0f, 1f)

                // CAPA 1: ONDA DE CHOQUE CIRCULAR
                drawCircle(
                    color = Color(0xFF6366F1).copy(alpha = alpha * 0.7f),
                    radius = maxRadius * p,
                    center = centerOffset,
                    style = Stroke(width = 3.dp.toPx() * (1f - p))
                )

                // CAPA 2: 6 PARTÍCULAS NEÓN
                val particleCount = 6
                val angleStep = (2 * PI) / particleCount
                val particleDistance = maxRadius * 1.1f * p

                for (i in 0 until particleCount) {
                    val angle = i * angleStep
                    val dx = cos(angle).toFloat() * particleDistance
                    val dy = sin(angle).toFloat() * particleDistance
                    val particleCenter = centerOffset + Offset(dx, dy)

                    val particleColor = if (i % 2 == 0) Color(0xFF00F2FE) else Color(0xFFEC4899)

                    drawCircle(
                        color = particleColor.copy(alpha = alpha),
                        radius = 4.dp.toPx() * (1f - (p * 0.5f)),
                        center = particleCenter
                    )
                }
            }
        }
}