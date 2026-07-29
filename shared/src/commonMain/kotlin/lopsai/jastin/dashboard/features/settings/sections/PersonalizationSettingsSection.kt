package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
fun PersonalizationSettingsSection(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // --- CUSTOMIZATION SECTION ---
        Text(
            text = "Customization",
            color = TextPrimaryDark,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        HorizontalDivider(color = InputBorderColor, thickness = 1.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Custom instructions", color = TextPrimaryDark, fontSize = 14.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("On", color = TextPrimaryDark, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Outlined.ChevronRight, contentDescription = null, tint = TextPrimaryDark, modifier = Modifier.size(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- MEMORY SECTION ---
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Memory", color = TextPrimaryDark, fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable { }) {
                Text("Learn more", color = TextPrimaryDark, fontSize = 13.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.Outlined.HelpOutline, contentDescription = "Help", tint = TextSecondaryDark, modifier = Modifier.size(16.dp))
            }
        }

        HorizontalDivider(color = InputBorderColor, thickness = 1.dp)

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f).padding(end = 16.dp)) {
                Text("Reference saved memories", color = TextPrimaryDark, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(2.dp))
                Text("Let LopsAI save and use memories when responding.", color = TextSecondaryDark, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Manage memories",
                    color = TextSecondaryDark,
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { }
                )
            }

            Switch(
                checked = true,
                onCheckedChange = { },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color.Black,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = InputBorderColor,
                    uncheckedBorderColor = Color.Transparent
                )
            )
        }

        HorizontalDivider(color = InputBorderColor, thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))

        Text("LopsAI may use Memory to personalize queries to search providers, such as Bing.", color = TextSecondaryDark, fontSize = 12.sp, modifier = Modifier.fillMaxWidth())
        Text(
            text = "Learn more",
            color = TextSecondaryDark,
            fontSize = 12.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { }
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}