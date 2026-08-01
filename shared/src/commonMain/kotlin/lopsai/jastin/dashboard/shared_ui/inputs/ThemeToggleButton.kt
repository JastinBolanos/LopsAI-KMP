package lopsai.jastin.dashboard.shared_ui.inputs

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ThemeToggleButton(
    isDarkMode: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val rotation by animateFloatAsState(
        targetValue = if (isDarkMode) 360f else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "ThemeIconRotate"
    )

    Box(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(
                color = if (isDarkMode) Color(0xFF1E1E24) else Color(0xFFEEEEF0),
                shape = CircleShape
            )
            .clickable { onToggle() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (isDarkMode) Icons.Outlined.DarkMode else Icons.Outlined.LightMode, // <-- YA TIENE SU ELSE CORRECTAMENTE
            contentDescription = "Toggle Dark/Light Mode",
            tint = if (isDarkMode) Color(0xFF00F2FE) else Color(0xFF1E293B),
            modifier = Modifier
                .size(20.dp)
                .rotate(rotation)
        )
    }
}