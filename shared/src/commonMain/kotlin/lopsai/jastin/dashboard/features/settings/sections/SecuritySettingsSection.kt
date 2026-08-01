package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun SecuritySettingsSection(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false,
    onEnableMfaClick: () -> Unit = {},
    onLogOutAllDevicesClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    // 🎨 COLOR DEL DIVISOR DINÁMICO
    val dividerColor = if (isDarkMode) Color(0xFF32323A) else InputBorderColor.copy(alpha = 0.6f)

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // --- MULTI-FACTOR AUTHENTICATION ---
        SecuritySettingRow(
            title = "Multi-factor authentication",
            description = "Require an extra security challenge when logging in. If you are unable to pass this challenge, you will have the option to recover your account via email.",
            buttonText = "Enable",
            isDarkMode = isDarkMode,
            onClick = onEnableMfaClick
        )

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(
            color = dividerColor,
            thickness = 1.dp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // --- LOG OUT OF ALL DEVICES ---
        SecuritySettingRow(
            title = "Log out of all devices",
            description = "Log out of all active sessions across all devices, including your current session. It may take up to 30 minutes for other devices to be logged out.",
            buttonText = "Log out all",
            isDarkMode = isDarkMode,
            onClick = onLogOutAllDevicesClick
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun SecuritySettingRow(
    title: String,
    description: String,
    buttonText: String,
    isDarkMode: Boolean,
    onClick: () -> Unit
) {
    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val btnBgColor = if (isDarkMode) Color(0xFF262630) else ChatBgColor
    val btnBorderColor = if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 24.dp)
        ) {
            Text(
                text = title,
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                color = secondaryTextColor,
                fontSize = 13.sp,
                lineHeight = 18.sp
            )
        }

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = btnBgColor,
                contentColor = textColor
            ),
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, btnBorderColor),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
        ) {
            Text(
                text = buttonText,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}