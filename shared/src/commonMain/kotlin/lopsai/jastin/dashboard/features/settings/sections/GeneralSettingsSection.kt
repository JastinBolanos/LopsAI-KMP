package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import lopsai.jastin.dashboard.features.settings.components.*

@Composable
fun GeneralSettingsSection(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(modifier = modifier.verticalScroll(scrollState)) {
        SettingsRowWithDropdown("Theme", "System")
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