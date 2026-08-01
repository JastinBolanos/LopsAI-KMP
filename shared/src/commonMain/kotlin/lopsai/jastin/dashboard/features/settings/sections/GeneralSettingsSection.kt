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
    isDarkMode: Boolean = true,
    onThemeToggle: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    var showThemeDropdown by remember { mutableStateOf(false) }

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
                color = TextPrimaryDark,
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
                            color = TextPrimaryDark,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Outlined.ArrowDropDown,
                            contentDescription = "Select Theme",
                            tint = TextPrimaryDark
                        )
                    }

                    // Menú flotante real al hacer clic
                    DropdownMenu(
                        expanded = showThemeDropdown,
                        onDismissRequest = { showThemeDropdown = false },
                        modifier = Modifier.background(Color.White)
                    ) {
                        DropdownMenuItem(
                            text = { Text("Dark", color = Color.Black) },
                            onClick = {
                                showThemeDropdown = false
                                if (!isDarkMode) onThemeToggle()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Light", color = Color.Black) },
                            onClick = {
                                showThemeDropdown = false
                                if (isDarkMode) onThemeToggle()
                            }
                        )
                    }
                }
            }
        }

        SettingsDivider()
        SettingsRowWithSwitch("Always show code when using data analyst", false)
        SettingsDivider()
        SettingsRowWithSwitch("Show follow up suggestions in chats", true)
        SettingsDivider()
        SettingsRowWithDropdown("Language", "English (US)")
        SettingsDivider()
        SettingsRowWithButton("Archived chats", "Manage")
        SettingsDivider()
        SettingsRowWithButton("Archive all chats", "Archive all")
        SettingsDivider()
        SettingsRowWithButton("Delete all Chats", "Delete all", Color(0xFFFF5252))
        SettingsDivider()
        SettingsRowWithButton("Log out on this device", "Log out")
        Spacer(modifier = Modifier.height(16.dp))
    }
}