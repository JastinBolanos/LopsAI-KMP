package lopsai.jastin.dashboard.features.settings.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark

@Composable
fun SettingsHeader(onClose: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, top = 20.dp, end = 24.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Settings", color = TextPrimaryDark, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        IconButton(onClick = onClose, modifier = Modifier.size(24.dp)) {
            Icon(Icons.Outlined.Close, contentDescription = "Cerrar", tint = TextPrimaryDark, modifier = Modifier.size(20.dp))
        }
    }
}