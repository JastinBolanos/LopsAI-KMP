package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun SpeechSettingsSection(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false,
    onVoiceClick: () -> Unit = {},
    onMainLanguageClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val dividerColor = if (isDarkMode) Color(0xFF32323A) else InputBorderColor

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // --- VOICE ROW ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onVoiceClick)
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Voice",
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = "Select Voice",
                tint = textColor,
                modifier = Modifier.size(20.dp)
            )
        }

        HorizontalDivider(
            color = dividerColor,
            thickness = 1.dp
        )

        // --- MAIN LANGUAGE ROW ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onMainLanguageClick)
                .padding(top = 16.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Main Language",
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Auto-Detect",
                    color = textColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "Select Main Language",
                    tint = textColor,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        // --- DESCRIPTION TEXT ---
        Text(
            text = "For best results, select the language you mainly speak. If it's not listed,\nit may still be supported via auto-detection.",
            color = secondaryTextColor,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 16.dp)
        )
    }
}