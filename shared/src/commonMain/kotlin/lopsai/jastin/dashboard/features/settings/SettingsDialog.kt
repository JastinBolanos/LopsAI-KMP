package lopsai.jastin.dashboard.features.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark
import lopsai.jastin.dashboard.features.settings.components.*
import lopsai.jastin.dashboard.features.settings.sections.*

@Composable
fun SettingsDialog(
    isMobile: Boolean = false,
    onClose: () -> Unit = {}
) {
    var selectedCategory by remember { mutableStateOf("General") }

    Dialog(
        onDismissRequest = onClose,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(if (isMobile) 0.95f else 0.7f),
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
            shadowElevation = 8.dp
        ) {
            Column {
                // 1. Cabecera principal
                SettingsHeader(onClose)
                HorizontalDivider(color = InputBorderColor.copy(alpha = 0.5f), thickness = 1.dp)

                // 2. ADAPTACIÓN MÓVIL: Pestañas superiores horizontales
                if (isMobile) {
                    MobileTabsSection(
                        selectedCategory = selectedCategory,
                        onCategorySelected = { selectedCategory = it }
                    )
                    HorizontalDivider(color = InputBorderColor.copy(alpha = 0.3f), thickness = 1.dp)
                }

                // 3. Cuerpo (Sidebar PC + Contenido)
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)) {

                    if (!isMobile) {
                        SettingsSidebar(
                            selectedCategory = selectedCategory,
                            onCategorySelected = { selectedCategory = it },
                            modifier = Modifier.weight(0.3f)
                        )
                        VerticalDivider(
                            color = InputBorderColor.copy(alpha = 0.5f),
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxHeight()
                        )
                    }

                    // 4. NAVEGACIÓN DINÁMICA DE SECCIONES
                    val contentModifier = Modifier
                        .weight(if (isMobile) 1f else 0.7f)
                        .padding(horizontal = if (isMobile) 16.dp else 32.dp, vertical = 24.dp)

                    when (selectedCategory) {
                        "General" -> GeneralSettingsSection(modifier = contentModifier)
                        "Personalization" -> PersonalizationSettingsSection(modifier = contentModifier)
                        "Speech" -> SpeechSettingsSection(modifier = contentModifier)
                        "Data controls" -> DataControlsSettingsSection(modifier = contentModifier)
                        // =============================
                        "Builder profile" -> BuilderProfileSettingsSection(modifier = contentModifier)
                        "Connected apps" -> ConnectedAppsSettingsSection(modifier = contentModifier)
                        "Security" -> SecuritySettingsSection(modifier = contentModifier)
                        else -> {
                            Box(modifier = contentModifier, contentAlignment = Alignment.Center) {
                                Text("Coming soon...", color = TextSecondaryDark)
                            }
                        }
                    }
                }
            }
        }
    }
}