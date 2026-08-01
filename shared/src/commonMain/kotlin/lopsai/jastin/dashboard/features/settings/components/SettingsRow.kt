package lopsai.jastin.dashboard.features.settings.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun SettingsDivider(isDarkMode: Boolean = false) {
    val dividerColor = if (isDarkMode) Color(0xFF32323A) else InputBorderColor.copy(alpha = 0.3f)
    HorizontalDivider(
        color = dividerColor,
        thickness = 1.dp,
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Composable
private fun SettingsRowBase(
    label: String,
    isDarkMode: Boolean,
    content: @Composable RowScope.() -> Unit
) {
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark

    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = 13.sp,
            modifier = Modifier.weight(1f).padding(end = 16.dp)
        )
        content()
    }
}

@Composable
fun SettingsRowWithDropdown(
    label: String,
    selectedValue: String,
    isDarkMode: Boolean = false
) {
    val borderColor = if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor.copy(alpha = 0.5f)
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val iconTint = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark

    SettingsRowBase(label, isDarkMode) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .border(1.dp, borderColor, RoundedCornerShape(8.dp))
                .clickable { }
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(selectedValue, color = textColor, fontSize = 13.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Outlined.ArrowDropDown, contentDescription = null, tint = iconTint, modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun SettingsRowWithSwitch(
    label: String,
    checked: Boolean,
    isDarkMode: Boolean = false
) {
    val trackChecked = if (isDarkMode) Color(0xFFF3F4F6) else Color.Black
    val thumbChecked = if (isDarkMode) Color(0xFF16161C) else Color.White
    val trackUnchecked = if (isDarkMode) Color(0xFF32323A) else InputBorderColor.copy(alpha = 0.5f)
    val thumbUnchecked = if (isDarkMode) Color(0xFFA1A1AA) else Color.White

    SettingsRowBase(label, isDarkMode) {
        Switch(
            checked = checked,
            onCheckedChange = { },
            colors = SwitchDefaults.colors(
                checkedThumbColor = thumbChecked,
                checkedTrackColor = trackChecked,
                uncheckedThumbColor = thumbUnchecked,
                uncheckedTrackColor = trackUnchecked,
                uncheckedBorderColor = Color.Transparent
            )
        )
    }
}

@Composable
fun SettingsRowWithButton(
    label: String,
    buttonLabel: String,
    buttonColor: Color = ChatBgColor,
    isDarkMode: Boolean = false,
    onClick: () -> Unit = {}
) {
    val isSecondary = buttonColor == ChatBgColor

    val actualBg = if (isSecondary) {
        if (isDarkMode) Color(0xFF262630) else ChatBgColor
    } else buttonColor

    val actualText = if (isSecondary) {
        if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    } else Color.White

    val actualBorder = if (isSecondary) {
        BorderStroke(1.dp, if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor.copy(alpha = 0.5f))
    } else null

    SettingsRowBase(label, isDarkMode) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = actualBg,
                contentColor = actualText
            ),
            shape = RoundedCornerShape(20.dp),
            border = actualBorder,
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp)
        ) {
            Text(buttonLabel, fontSize = 13.sp)
        }
    }
}