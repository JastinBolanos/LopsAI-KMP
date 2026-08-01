package lopsai.jastin.dashboard.features.chat.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import lopsai_kmp.shared.generated.resources.Res
import lopsai_kmp.shared.generated.resources.bg_subwoofer_dark
import lopsai_kmp.shared.generated.resources.bg_subwoofer_light
import org.jetbrains.compose.resources.painterResource

@Composable
fun LivingWallpaperBg(
    isDarkMode: Boolean,
    isChatActive: Boolean = false,
    modifier: Modifier = Modifier
) {
    // 1. MOTOR DEL EFECTO VIVO (BOMBEO DE SOMBRA / SUBWOOFER KICK)
    val transition = rememberInfiniteTransition(label = "LivingShadowEngine")

    // Bombeo de la sombra
    val shadowPulse by transition.animateFloat(
        initialValue = 0.25f,
        targetValue = 0.55f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "ShadowPulse"
    )

    // Expansión del radio de luz central
    val glowRadiusPulse by transition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "GlowRadius"
    )

    // =========================================================================
    // 🧠 2. INTELIGENCIA DE ATENUACIÓN DEL CHAT (AMBIENT DIMMING)
    // =========================================================================
    val chatDimAlpha by animateFloatAsState(
        targetValue = if (isChatActive) 0.75f else 0.0f,
        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
        label = "ChatDimmerAnimation"
    )
    val dimmingColor = if (isDarkMode) Color(0xFF050507) else Color(0xFFF9F9F9)

    Box(modifier = modifier.fillMaxSize()) {

        // =====================================================================
        // CAPA 1: TU IMAGEN DE PARED REAL (CON CAMBIO SUAVE OSCURO <-> CLARO)
        // =====================================================================
        Crossfade(
            targetState = isDarkMode,
            animationSpec = tween(durationMillis = 500),
            label = "WallpaperThemeCrossfade"
        ) { dark ->
            val imageRes = if (dark) Res.drawable.bg_subwoofer_dark else Res.drawable.bg_subwoofer_light

            Image(
                painter = painterResource(imageRes),
                contentDescription = "Living Ambient Wallpaper",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // =====================================================================
        // CAPA 2: EFECTO DE SOMBRA Y LUZ VIVA (PULSO DE SUBWOOFER)
        // =====================================================================
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val maxRadius = (w.coerceAtLeast(h)) * 0.65f * glowRadiusPulse
            val vignetteColor = if (isDarkMode) Color.Black else Color.White
            drawRect(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.Transparent,
                        vignetteColor.copy(alpha = shadowPulse)
                    ),
                    center = Offset(w * 0.5f, h * 0.45f),
                    radius = maxRadius
                )
            )
        }

        // =====================================================================
        // 🧠 CAPA 3: VELO INTELIGENTE (SE ACTIVA SOLO DURANTE EL CHAT)
        // =====================================================================
        if (chatDimAlpha > 0f) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(dimmingColor.copy(alpha = chatDimAlpha))
            )
        }
    }
}