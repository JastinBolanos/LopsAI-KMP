package lopsai.jastin.dashboard.features.store.components

import androidx.compose.foundation.layout.widthIn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.fillMaxWidthInDesktop(): Modifier = this.widthIn(max = 700.dp)