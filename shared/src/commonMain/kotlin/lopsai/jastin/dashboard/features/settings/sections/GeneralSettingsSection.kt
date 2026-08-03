package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.features.settings.components.*
import lopsai.jastin.dashboard.shared_ui.inputs.ThemeToggleButton

@Composable
fun GeneralSettingsSection(
    isDarkMode: Boolean = false,
    onThemeToggle: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    var showThemeDropdown by remember { mutableStateOf(false) }

    // ⚡ ESTADOS TEMPORALES PARA LOS SWITCHES (Efecto Demo)
    var showCodeActive by remember { mutableStateOf(false) }
    var showSuggestionsActive by remember { mutableStateOf(true) }

    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val dropdownBg = if (isDarkMode) Color(0xFF262630) else Color.White

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // =================================================================
        // ✨ FILA INTERACTIVA DE TEMA (DROPDOWN + BOTÓN TÁCTIL)
        // =================================================================
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Theme",
                color = textColor,
                fontSize = 14.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // 1. Botón táctil con física de resorte (Sol / Luna)
                ThemeToggleButton(
                    isDarkMode = isDarkMode,
                    onToggle = onThemeToggle
                )

                // 2. Dropdown interactivo (Dark / Light)
                Box {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { showThemeDropdown = true }
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (isDarkMode) "Dark" else "Light",
                            color = textColor,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Outlined.ArrowDropDown,
                            contentDescription = "Select Theme",
                            tint = textColor
                        )
                    }

                    MaterialTheme(
                        shapes = MaterialTheme.shapes.copy(extraSmall = RoundedCornerShape(16.dp)),
                        colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme()
                    ) {
                        DropdownMenu(
                            expanded = showThemeDropdown,
                            onDismissRequest = { showThemeDropdown = false },
                            modifier = Modifier.background(dropdownBg)
                        ) {
                            DropdownMenuItem(
                                text = { Text("Dark", color = textColor) },
                                onClick = {
                                    showThemeDropdown = false
                                    if (!isDarkMode) onThemeToggle()
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Light", color = textColor) },
                                onClick = {
                                    showThemeDropdown = false
                                    if (isDarkMode) onThemeToggle()
                                }
                            )
                        }
                    }
                }
            }
        }

        SettingsDivider(isDarkMode = isDarkMode)
        SettingsRowWithSwitch(
            label = "Always show code when using data analyst",
            isChecked = showCodeActive,
            onCheckedChange = { showCodeActive = it },
            isDarkMode = isDarkMode
        )
        SettingsDivider(isDarkMode = isDarkMode)
        SettingsRowWithSwitch(
            label = "Show follow up suggestions in chats",
            isChecked = showSuggestionsActive,
            onCheckedChange = { showSuggestionsActive = it },
            isDarkMode = isDarkMode
        )
        SettingsDivider(isDarkMode = isDarkMode)
        SettingsRowWithDropdown("Language", "English (US)", isDarkMode = isDarkMode)
        SettingsDivider(isDarkMode = isDarkMode)
        SettingsRowWithButton("Archived chats", "Manage", isDarkMode = isDarkMode)
        SettingsDivider(isDarkMode = isDarkMode)
        SettingsRowWithButton("Archive all chats", "Archive all", isDarkMode = isDarkMode)
        SettingsDivider(isDarkMode = isDarkMode)
        SettingsRowWithButton("Delete all Chats", "Delete all", Color(0xFFFF5252), isDarkMode = isDarkMode)
        SettingsDivider(isDarkMode = isDarkMode)
        SettingsRowWithButton("Log out on this device", "Log out", isDarkMode = isDarkMode)
        Spacer(modifier = Modifier.height(16.dp))
    }
}