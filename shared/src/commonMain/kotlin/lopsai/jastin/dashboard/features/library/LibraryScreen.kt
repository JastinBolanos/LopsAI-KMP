package lopsai.jastin.dashboard.features.library

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import lopsai.jastin.dashboard.features.library.components.*

@Composable
fun LibraryScreen(
    isMobile: Boolean = false,
    isDarkMode: Boolean = false,
    onCreateImageClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onHelpClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val cards = getMockLibraryCardGradients()

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = if (isMobile) 16.dp else 48.dp)
        ) {
            // 1. Cabecera superior
            LibraryTopBar(
                isMobile = isMobile,
                isDarkMode = isDarkMode,
                onCreateImageClick = onCreateImageClick,
                onProfileClick = onProfileClick
            )

            // 2. Cuadrícula de tarjetas con gradientes
            LazyVerticalGrid(
                columns = GridCells.Fixed(if (isMobile) 2 else 4),
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(cards) { card ->
                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(24.dp))
                            .background(card.brush)
                            .clickable { }
                    )
                }
            }
        }

        // 3. Botón "?" flotante inferior derecho
        FloatingHelpButton(
            isDarkMode = isDarkMode,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            onClick = onHelpClick
        )
    }
}