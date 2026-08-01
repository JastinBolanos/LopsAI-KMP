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
    isMobile: Boolean,
    onClose: () -> Unit,
    isDarkMode: Boolean = false,
    onThemeToggle: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf("General") }

    // 🎨 PALETA ADAPTATIVA PARA EL MODAL PRINCIPAL
    val dialogBg = if (isDarkMode) Color(0xFF16161C) else Color.White
    val dividerColor = if (isDarkMode) Color(0xFF32323A) else InputBorderColor.copy(alpha = 0.5f)
    val emptyTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark

    Dialog(
        onDismissRequest = onClose,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(if (isMobile) 0.95f else 0.7f),
            shape = RoundedCornerShape(16.dp),
            color = dialogBg,
            shadowElevation = 8.dp
        ) {
            Column {
                // 1. Cabecera principal
                SettingsHeader(onClose = onClose, isDarkMode = isDarkMode)
                HorizontalDivider(color = dividerColor, thickness = 1.dp)

                // 2. ADAPTACIÓN MÓVIL: Pestañas superiores horizontales
                if (isMobile) {
                    MobileTabsSection(
                        selectedCategory = selectedCategory,
                        isDarkMode = isDarkMode,
                        onCategorySelected = { selectedCategory = it }
                    )
                    HorizontalDivider(color = dividerColor, thickness = 1.dp)
                }

                // 3. Cuerpo (Sidebar PC + Contenido)
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)) {

                    if (!isMobile) {
                        SettingsSidebar(
                            selectedCategory = selectedCategory,
                            isDarkMode = isDarkMode,
                            onCategorySelected = { selectedCategory = it },
                            modifier = Modifier.weight(0.3f)
                        )
                        VerticalDivider(
                            color = dividerColor,
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxHeight()
                        )
                    }

                    // 4. NAVEGACIÓN DINÁMICA DE SECCIONES
                    val contentModifier = Modifier
                        .weight(if (isMobile) 1f else 0.7f)
                        .padding(horizontal = if (isMobile) 16.dp else 32.dp, vertical = 24.dp)

                    // ⚡ AHORA TODAS LAS SECCIONES RECIBEN EL MODO OSCURO
                    when (selectedCategory) {
                        "General" -> GeneralSettingsSection(
                            isDarkMode = isDarkMode,
                            onThemeToggle = onThemeToggle,
                            modifier = contentModifier
                        )
                        "Personalization" -> PersonalizationSettingsSection(
                            isDarkMode = isDarkMode,
                            modifier = contentModifier
                        )
                        "Speech" -> SpeechSettingsSection(
                            isDarkMode = isDarkMode,
                            modifier = contentModifier
                        )
                        "Data controls" -> DataControlsSettingsSection(
                            isDarkMode = isDarkMode,
                            modifier = contentModifier
                        )
                        "Builder profile" -> BuilderProfileSettingsSection(
                            isDarkMode = isDarkMode,
                            modifier = contentModifier
                        )
                        "Connected apps" -> ConnectedAppsSettingsSection(
                            isDarkMode = isDarkMode,
                            modifier = contentModifier
                        )
                        "Security" -> SecuritySettingsSection(
                            isDarkMode = isDarkMode,
                            modifier = contentModifier
                        )
                        else -> {
                            Box(modifier = contentModifier, contentAlignment = Alignment.Center) {
                                Text("Coming soon...", color = emptyTextColor)
                            }
                        }
                    }
                }
            }
        }
    }
}