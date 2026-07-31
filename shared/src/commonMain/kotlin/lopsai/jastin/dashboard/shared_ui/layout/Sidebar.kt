package lopsai.jastin.dashboard.shared_ui.layout

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.PI
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.drawscope.clipRect
import kotlin.math.roundToInt

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
            // =========================================================================
            // ✨ 1. TOP FIJO: ESTRELLA RODANTE + REVELADO CINEMÁTICO "LopsAI"
            // =========================================================================
            val headerTransition = rememberInfiniteTransition(label = "LopsAiRevealAnim")

            // 1. Progreso maestro de revelado (0f = Oculto en la izquierda -> 1f = Todo revelado a la derecha)
            val revealProgress by headerTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 2800, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse // Va dibujando hacia la derecha y regresa suave
                ),
                label = "RevealProgress"
            )

            // 2. Rotación de las puntas de la estrella mientras rueda hacia la derecha
            val starWheelRotation by headerTransition.animateFloat(
                initialValue = 0f,
                targetValue = 720f, // 2 vueltas completas de 360° durante el trayecto
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 2800, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "StarWheelRotate"
            )

            // =========================================================================
            // 🌊 EL BAÑO LÍQUIDO: BASE NEGRA + OLA QUE MANCHA Y SE RETIRA
            // =========================================================================
            val washOffset by headerTransition.animateFloat(
                initialValue = -350f, // Nace oculta a la izquierda (texto 100% negro)
                targetValue = 550f,   // Termina a la derecha (texto vuelve a 100% negro)
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 3500, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                ),
                label = "LiquidWashOffset"
            )

            // Pincel: Base NEGRA pura -> Ola líquida vibrante -> Retorno a NEGRO puro
            val lopsAiWashBrush = remember(washOffset) {
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF111111), // 1. Negro profundo (antes de la ola)
                        Color(0xFF111111), //    Margen negro
                        Color(0xFF00F2FE), // 2. Entrada de agua (Cian cristalino)
                        Color(0xFFA855F7), // 3. Centro vibrante (Púrpura perlado)
                        Color(0xFFEC4899), // 4. Estela neón (Rosa)
                        Color(0xFF111111), // 5. Negro profundo (después de la ola)
                        Color(0xFF111111)  //    Retirada total
                    ),
                    start = Offset(washOffset, 0f),
                    end = Offset(washOffset + 300f, 0f) // Ancho concentrado de la ola
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
                // =========================================================================
                // 🚀 CABEZAL OPTIMIZADO POR GPU: 0 RECOMPOSICIONES (60/120 FPS FLUIDOS)
                // =========================================================================
                val maxTextWidthPx = with(androidx.compose.ui.platform.LocalDensity.current) { 88.dp.toPx() }

                Box(
                    modifier = Modifier
                        .height(36.dp)
                        .width(120.dp),
                    // Ancho fijo: cero cálculos de layout durante la animación
                    contentAlignment = Alignment.CenterStart
                ) {
                    // =========================================================
                    // CAPA 1 (ATRÁS): TEXTO REVELADO POR GPU (clipRect en Skia)
                    // =========================================================
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            // Recorte directo en la tarjeta gráfica sin tocar la CPU
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
                                brush = lopsAiWashBrush // La ola líquida negra/neón
                            ),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    // =========================================================
                    // CAPA 2 (FRENTE): ESTRELLA EN FASE DE LAYOUT (LAMBDA OFFSET)
                    // =========================================================
                    Box(
                        modifier = Modifier
                            // USO DE LAMBDA { ... } -> Evita recomponer en cada frame
                            .offset {
                                val currentX = (maxTextWidthPx * revealProgress).roundToInt()
                                IntOffset(x = currentX, y = 0)
                            }
                            .size(28.dp)
                            .graphicsLayer {
                                rotationZ = starWheelRotation
                                // Forzamos composición en capa de hardware (GPU Render Node)
                                clip = false
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AutoAwesome,
                            contentDescription = "LopsAI Animated Star",
                            modifier = Modifier.size(22.dp),
                            tint = Color(0xFF6366F1) // Índigo Premium
                        )
                    }
                }

                // BOTÓN DE CERRAR BARRA LATERAL CON EXPLOSIÓN ÉPICA
                Icon(
                    imageVector = Icons.Outlined.ViewSidebar,
                    contentDescription = "Close Sidebar",
                    tint = TextSecondaryDark,
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
                    Text(
                        text = chatTitle,
                        fontSize = 13.sp,
                        color = TextPrimaryDark,
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

// =====================================================================
// 💥 MODIFICADOR ÉPICO: EXPLOSIÓN DE PARTÍCULAS + ONDA DE CHOQUE (SKIA)
// =====================================================================
@Composable
fun Modifier.epicClickBurst(
    onClick: () -> Unit
): Modifier {
    // 1. Estado para el rebote elástico (Scale)
    val scale = remember { Animatable(1f) }
    // 2. Estado para la expansión de la explosión (0f a 1f)
    val burstProgress = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    return this
        .scale(scale.value)
        .pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    // Compresión inmediata al pulsar
                    scale.animateTo(0.93f, tween(100, easing = FastOutSlowInEasing))
                    tryAwaitRelease()
                    // Rebote elástico al soltar
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
                    // Disparo simultáneo de la explosión de partículas
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

                // CAPA 1: ONDA DE CHOQUE CIRCULAR (SHOCKWAVE RING)
                drawCircle(
                    color = Color(0xFF6366F1).copy(alpha = alpha * 0.7f),
                    radius = maxRadius * p,
                    center = centerOffset,
                    style = Stroke(width = 3.dp.toPx() * (1f - p))
                )

                // CAPA 2: 6 PARTÍCULAS NEÓN DISPARADAS EN 360 GRADOS
                val particleCount = 6
                val angleStep = (2 * PI) / particleCount
                val particleDistance = maxRadius * 1.1f * p

                for (i in 0 until particleCount) {
                    val angle = i * angleStep
                    val dx = cos(angle).toFloat() * particleDistance
                    val dy = sin(angle).toFloat() * particleDistance
                    val particleCenter = centerOffset + Offset(dx, dy)

                    // Alternamos colores premium entre Cian Eléctrico y Rosa Neón
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