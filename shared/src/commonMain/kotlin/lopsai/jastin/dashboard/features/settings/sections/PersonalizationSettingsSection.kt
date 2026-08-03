package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun PersonalizationSettingsSection(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false
) {
    val scrollState = rememberScrollState()
    var memoryActive by remember { mutableStateOf(true) }

    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val dividerColor = if (isDarkMode) Color(0xFF32323A) else InputBorderColor

    // PALETA DEL SWITCH
    val trackChecked = if (isDarkMode) Color(0xFFF3F4F6) else Color.Black
    val thumbChecked = if (isDarkMode) Color(0xFF16161C) else Color.White
    val trackUnchecked = if (isDarkMode) Color(0xFF32323A) else InputBorderColor.copy(alpha = 0.5f)
    val thumbUnchecked = if (isDarkMode) Color(0xFFA1A1AA) else Color.White

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // --- CUSTOMIZATION SECTION ---
        Text(
            text = "Customization",
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        HorizontalDivider(color = dividerColor, thickness = 1.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Custom instructions", color = textColor, fontSize = 14.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("On", color = textColor, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Outlined.ChevronRight, contentDescription = null, tint = textColor, modifier = Modifier.size(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- MEMORY SECTION ---
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Memory", color = textColor, fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable { }) {
                Text("Learn more", color = textColor, fontSize = 13.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Outlined.HelpOutline, contentDescription = "Help", tint = secondaryTextColor, modifier = Modifier.size(16.dp))
            }
        }

        HorizontalDivider(color = dividerColor, thickness = 1.dp)

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f).padding(end = 16.dp)) {
                Text("Reference saved memories", color = textColor, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(2.dp))
                Text("Let LopsAI save and use memories when responding.", color = secondaryTextColor, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Manage memories",
                    color = secondaryTextColor,
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { }
                )
            }

            Switch(
                checked = memoryActive,
                onCheckedChange = { memoryActive = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = thumbChecked,
                    checkedTrackColor = trackChecked,
                    uncheckedThumbColor = thumbUnchecked,
                    uncheckedTrackColor = trackUnchecked,
                    uncheckedBorderColor = Color.Transparent
                )
            )
        }

        HorizontalDivider(color = dividerColor, thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "LopsAI may use Memory to personalize queries to search providers, such as Bing.",
            color = secondaryTextColor,
            fontSize = 12.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Learn more",
            color = secondaryTextColor,
            fontSize = 12.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { }
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}