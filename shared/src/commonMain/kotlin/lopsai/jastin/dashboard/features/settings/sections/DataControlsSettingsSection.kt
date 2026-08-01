package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.features.settings.components.SettingsDivider
import lopsai.jastin.dashboard.features.settings.components.SettingsRowWithButton

@Composable
fun DataControlsSettingsSection(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false,
    onImproveModelClick: () -> Unit = {},
    onManageSharedLinksClick: () -> Unit = {},
    onExportDataClick: () -> Unit = {},
    onDeleteAccountClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // --- IMPROVE THE MODEL FOR EVERYONE ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onImproveModelClick)
                .padding(vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Improve the model for everyone",
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "On",
                    color = textColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Outlined.ChevronRight,
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        SettingsDivider(isDarkMode = isDarkMode)

        // --- SHARED LINKS ---
        SettingsRowWithButton(
            label = "Shared links",
            buttonLabel = "Manage",
            isDarkMode = isDarkMode,
            onClick = onManageSharedLinksClick
        )

        SettingsDivider(isDarkMode = isDarkMode)

        // --- EXPORT DATA ---
        SettingsRowWithButton(
            label = "Export data",
            buttonLabel = "Export",
            isDarkMode = isDarkMode,
            onClick = onExportDataClick
        )

        SettingsDivider(isDarkMode = isDarkMode)

        // --- DELETE ACCOUNT ---
        SettingsRowWithButton(
            label = "Delete account",
            buttonLabel = "Delete",
            buttonColor = Color(0xFFFF4A4A),
            isDarkMode = isDarkMode,
            onClick = onDeleteAccountClick
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}