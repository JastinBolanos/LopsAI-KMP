package lopsai.jastin.dashboard.features.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark

@Composable
fun MobileTabsSection(
    selectedCategory: String,
    isDarkMode: Boolean = false,
    onCategorySelected: (String) -> Unit
) {
    val categories = listOf("General", "Personalization", "Speech", "Data controls", "Builder profile", "Connected apps", "Security")
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        categories.forEach { category ->
            val isSelected = category == selectedCategory

            // 🎨 PALETA DE TABS MÓVILES
            val tabBgColor = if (isSelected) {
                if (isDarkMode) Color.White else Color(0xFF111111)
            } else {
                if (isDarkMode) Color(0xFF262630) else Color(0xFFF0F0F0)
            }

            val tabTextColor = if (isSelected) {
                if (isDarkMode) Color.Black else Color.White
            } else {
                if (isDarkMode) Color(0xFFA1A1AA) else TextPrimaryDark
            }

            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .clickable { onCategorySelected(category) },
                color = tabBgColor,
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = category,
                    color = tabTextColor,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun SettingsSidebar(
    selectedCategory: String,
    isDarkMode: Boolean = false,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(vertical = 16.dp, horizontal = 12.dp)) {
        SidebarItem(Icons.Outlined.Settings, "General", selectedCategory == "General", isDarkMode) { onCategorySelected("General") }
        SidebarItem(Icons.Outlined.Person, "Personalization", selectedCategory == "Personalization", isDarkMode) { onCategorySelected("Personalization") }
        SidebarItem(Icons.Outlined.GraphicEq, "Speech", selectedCategory == "Speech", isDarkMode) { onCategorySelected("Speech") }
        SidebarItem(Icons.Outlined.Storage, "Data controls", selectedCategory == "Data controls", isDarkMode) { onCategorySelected("Data controls") }
        SidebarItem(Icons.Outlined.AccountCircle, "Builder profile", selectedCategory == "Builder profile", isDarkMode) { onCategorySelected("Builder profile") }
        SidebarItem(Icons.Outlined.GridOn, "Connected apps", selectedCategory == "Connected apps", isDarkMode) { onCategorySelected("Connected apps") }
        SidebarItem(Icons.Outlined.Lock, "Security", selectedCategory == "Security", isDarkMode) { onCategorySelected("Security") }
    }
}

@Composable
private fun SidebarItem(
    icon: ImageVector,
    text: String,
    isSelected: Boolean,
    isDarkMode: Boolean,
    onClick: () -> Unit
) {
    // 🎨 PALETA DEL SIDEBAR PC
    val selectedBg = if (isDarkMode) Color(0xFF262630) else Color(0xFFF0F0F0)
    val contentColor = if (isDarkMode) Color(0xFFE4E4E7) else TextPrimaryDark

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) selectedBg else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = contentColor, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, color = contentColor, fontSize = 13.sp)
    }
}