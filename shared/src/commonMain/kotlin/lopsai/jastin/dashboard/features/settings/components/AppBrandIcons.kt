package lopsai.jastin.dashboard.features.settings.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun GoogleDriveIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        val w = size.width
        val h = size.height

        val yellowPath = Path().apply {
            moveTo(w * 0.35f, h * 0.9f)
            lineTo(w * 0.95f, h * 0.9f)
            lineTo(w * 0.65f, h * 0.38f)
            close()
        }
        drawPath(yellowPath, Color(0xFFFBBC05))

        val bluePath = Path().apply {
            moveTo(w * 0.65f, h * 0.38f)
            lineTo(w * 0.95f, h * 0.9f)
            lineTo(w * 0.68f, h * 0.1f)
            close()
        }
        drawPath(bluePath, Color(0xFF4285F4))

        val greenPath = Path().apply {
            moveTo(w * 0.05f, h * 0.9f)
            lineTo(w * 0.35f, h * 0.9f)
            lineTo(w * 0.68f, h * 0.1f)
            lineTo(w * 0.38f, h * 0.1f)
            close()
        }
        drawPath(greenPath, Color(0xFF34A853))
    }
}

@Composable
fun OneDriveIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        val w = size.width
        val h = size.height

        drawCircle(
            color = Color(0xFF0067B8),
            radius = w * 0.22f,
            center = Offset(w * 0.3f, h * 0.55f)
        )
        drawCircle(
            color = Color(0xFF0078D4),
            radius = w * 0.28f,
            center = Offset(w * 0.6f, h * 0.55f)
        )
        drawCircle(
            color = Color(0xFF28A8EA),
            radius = w * 0.22f,
            center = Offset(w * 0.78f, h * 0.62f)
        )
    }
}

@Composable
fun AppleIntelligenceIcon() {
    Canvas(modifier = Modifier.size(24.dp)) {
        val strokeWidth = 2.dp.toPx()
        val radius = size.width * 0.32f
        val center = Offset(size.width / 2, size.height / 2)

        drawCircle(
            color = Color(0xFFFF8A00),
            radius = radius,
            center = center.copy(x = center.x - 3f, y = center.y - 3f),
            style = Stroke(width = strokeWidth)
        )
        drawCircle(
            color = Color(0xFFE52583),
            radius = radius,
            center = center.copy(x = center.x + 3f, y = center.y - 3f),
            style = Stroke(width = strokeWidth)
        )
        drawCircle(
            color = Color(0xFF00A2FF),
            radius = radius,
            center = center.copy(y = center.y + 4f),
            style = Stroke(width = strokeWidth)
        )
    }
}