package lopsai.jastin.dashboard.features.premium

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import lopsai.jastin.dashboard.features.premium.components.PlanTierCard
import lopsai.jastin.dashboard.features.premium.components.PremiumHeader
import lopsai.jastin.dashboard.features.premium.data.MockPlansData

@Composable
fun PremiumUpgradeDialog(
    isDarkMode: Boolean,
    onDismiss: () -> Unit
) {
    val dialogBgColor = if (isDarkMode) Color(0xFF16161C) else Color(0xFFFFFFFF)

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.85f)
                .clip(RoundedCornerShape(24.dp))
                .background(dialogBgColor)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // 1. HEADER (título y subtítulo)
                PremiumHeader(isDarkMode = isDarkMode)

                // 2. LISTA DE PLANES (Las 3 bandejas apiladas con scroll)
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(MockPlansData.plans) { plan ->
                        PlanTierCard(plan = plan, isDarkMode = isDarkMode)
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                // 3. FOOTER (Botón para cerrar el modal)
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Maybe Later",
                        color = if (isDarkMode) Color.Gray else Color.DarkGray
                    )
                }
            }
        }
    }
}