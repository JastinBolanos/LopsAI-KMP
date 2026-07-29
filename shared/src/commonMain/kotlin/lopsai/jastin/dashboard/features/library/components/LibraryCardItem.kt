package lopsai.jastin.dashboard.features.library.components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class LibraryCardItem(val id: Int, val brush: Brush)

fun getMockLibraryCardGradients(): List<LibraryCardItem> {
    return listOf(
        LibraryCardItem(1, Brush.radialGradient(listOf(Color(0xFFE55D2D), Color(0xFF0F3A85), Color(0xFF030D1A)), Offset(200f, 400f), 500f)),
        LibraryCardItem(2, Brush.linearGradient(listOf(Color(0xFF3868C9), Color(0xFF88D2E7), Color(0xFF32CFA5)))),
        LibraryCardItem(3, Brush.linearGradient(listOf(Color(0xFFDCEFE3), Color(0xFF6DE87D), Color(0xFF2CBF42)))),
        LibraryCardItem(4, Brush.radialGradient(listOf(Color(0xFF8FF036), Color(0xFF0C240E), Color.Black), Offset(300f, 100f), 450f)),
        LibraryCardItem(5, Brush.radialGradient(listOf(Color(0xFFF39818), Color(0xFFD63118), Color(0xFF0A0F33)), Offset(200f, 200f), 450f)),
        LibraryCardItem(6, Brush.linearGradient(listOf(Color(0xFFEDEDFA), Color(0xFFE8424E), Color(0xFF14AED6)))),
        LibraryCardItem(7, Brush.radialGradient(listOf(Color(0xFF4DB9F2), Color(0xFF7E0CE8), Color.Black), Offset(100f, 100f), 500f)),
        LibraryCardItem(8, Brush.linearGradient(listOf(Color(0xFFFF851B), Color(0xFFFF630B)))),
        LibraryCardItem(9, Brush.linearGradient(listOf(Color(0xFF7182F5), Color(0xFF275BE8), Color(0xFF1B3FC2)))),
        LibraryCardItem(10, Brush.radialGradient(listOf(Color(0xFFB510F5), Color(0xFF0F57EB), Color.Black), Offset(150f, 100f), 400f)),
        LibraryCardItem(11, Brush.radialGradient(listOf(Color(0xFF90F510), Color(0xFF10A1F5), Color.Black), Offset(300f, 100f), 450f))
    )
}