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
fun SettingsDivider() {
    HorizontalDivider(color = InputBorderColor.copy(alpha = 0.3f), thickness = 1.dp, modifier = Modifier.padding(vertical = 12.dp))
}

@Composable
private fun SettingsRowBase(label: String, content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, color = TextPrimaryDark, fontSize = 13.sp, modifier = Modifier.weight(1f).padding(end = 16.dp))
        content()
    }
}

@Composable
fun SettingsRowWithDropdown(label: String, selectedValue: String) {
    SettingsRowBase(label) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .border(1.dp, InputBorderColor.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                .clickable { }
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(selectedValue, color = TextPrimaryDark, fontSize = 13.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Outlined.ArrowDropDown, contentDescription = null, tint = TextSecondaryDark, modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun SettingsRowWithSwitch(label: String, checked: Boolean) {
    SettingsRowBase(label) {
        Switch(
            checked = checked,
            onCheckedChange = { },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White, checkedTrackColor = Color.Black,
                uncheckedThumbColor = Color.White, uncheckedTrackColor = InputBorderColor.copy(alpha = 0.5f), uncheckedBorderColor = Color.Transparent
            )
        )
    }
}

@Composable
fun SettingsRowWithButton(
    label: String,
    buttonLabel: String,
    buttonColor: Color = ChatBgColor,
    onClick: () -> Unit = {}
) {
    SettingsRowBase(label) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor,
                contentColor = if (buttonColor == ChatBgColor) TextPrimaryDark else Color.White
            ),
            shape = RoundedCornerShape(20.dp),
            border = if (buttonColor == ChatBgColor) BorderStroke(1.dp, InputBorderColor.copy(alpha = 0.5f)) else null,
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp)
        ) {
            Text(buttonLabel, fontSize = 13.sp)
        }
    }
}