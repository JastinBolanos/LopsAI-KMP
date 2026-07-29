package lopsai.jastin.dashboard.features.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun SettingsDialog(
    isMobile: Boolean = false,
    onClose: () -> Unit = {}
) {
    // Estado para saber qué categoría de configuración está activa en el celular o PC
    var selectedCategory by remember { mutableStateOf("General") }

    Dialog(
        onDismissRequest = onClose,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(if (isMobile) 0.95f else 0.7f),
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
            shadowElevation = 8.dp
        ) {
            Column {
                // 1. Cabecera principal con título y botón de cerrar
                HeaderSection(onClose)
                HorizontalDivider(color = InputBorderColor.copy(alpha = 0.5f), thickness = 1.dp)

                // ===================================================================
                // 2. ADAPTACIÓN MÓVIL: Pestañas superiores horizontales si es celular
                // ===================================================================
                if (isMobile) {
                    MobileTabsSection(
                        selectedCategory = selectedCategory,
                        onCategorySelected = { selectedCategory = it }
                    )
                    HorizontalDivider(color = InputBorderColor.copy(alpha = 0.3f), thickness = 1.dp)
                }

                // 3. Cuerpo (Sidebar vertical en PC o Contenido directo en Celular)
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)) {

                    // En PC mostramos la barra lateral tradicional a la izquierda
                    if (!isMobile) {
                        SidebarSection(
                            selectedCategory = selectedCategory,
                            onCategorySelected = { selectedCategory = it },
                            modifier = Modifier.weight(0.3f)
                        )
                        VerticalDivider(
                            color = InputBorderColor.copy(alpha = 0.5f),
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxHeight()
                        )
                    }

                    // Contenido dinámico según la categoría seleccionada
                    GeneralSettingsSection(
                        modifier = Modifier
                            .weight(if (isMobile) 1f else 0.7f)
                            .padding(horizontal = if (isMobile) 16.dp else 32.dp, vertical = 24.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun HeaderSection(onClose: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, top = 20.dp, end = 24.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Settings", color = TextPrimaryDark, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        IconButton(onClick = onClose, modifier = Modifier.size(24.dp)) {
            Icon(Icons.Outlined.Close, contentDescription = "Cerrar", tint = TextPrimaryDark, modifier = Modifier.size(20.dp))
        }
    }
}

// ===================================================================
// NUEVO: Pestañas horizontales para celulares (con scroll nativo)
// ===================================================================
@Composable
private fun MobileTabsSection(
    selectedCategory: String,
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
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .clickable { onCategorySelected(category) },
                color = if (isSelected) Color(0xFF111111) else Color(0xFFF0F0F0),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = category,
                    color = if (isSelected) Color.White else TextPrimaryDark,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun SidebarSection(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(vertical = 16.dp, horizontal = 12.dp)) {
        SidebarItem(Icons.Outlined.Settings, "General", selectedCategory == "General") { onCategorySelected("General") }
        SidebarItem(Icons.Outlined.Person, "Personalization", selectedCategory == "Personalization") { onCategorySelected("Personalization") }
        SidebarItem(Icons.Outlined.GraphicEq, "Speech", selectedCategory == "Speech") { onCategorySelected("Speech") }
        SidebarItem(Icons.Outlined.Storage, "Data controls", selectedCategory == "Data controls") { onCategorySelected("Data controls") }
        SidebarItem(Icons.Outlined.AccountCircle, "Builder profile", selectedCategory == "Builder profile") { onCategorySelected("Builder profile") }
        SidebarItem(Icons.Outlined.GridOn, "Connected apps", selectedCategory == "Connected apps") { onCategorySelected("Connected apps") }
        SidebarItem(Icons.Outlined.Lock, "Security", selectedCategory == "Security") { onCategorySelected("Security") }
    }
}

@Composable
private fun SidebarItem(icon: ImageVector, text: String, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) Color(0xFFF0F0F0) else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = TextPrimaryDark, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, color = TextPrimaryDark, fontSize = 13.sp)
    }
}

@Composable
private fun GeneralSettingsSection(modifier: Modifier = Modifier) {
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
@Composable
private fun SettingsDivider() {
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
private fun SettingsRowWithDropdown(label: String, selectedValue: String) {
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
private fun SettingsRowWithSwitch(label: String, checked: Boolean) {
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
private fun SettingsRowWithButton(label: String, buttonLabel: String, buttonColor: Color = ChatBgColor) {
    SettingsRowBase(label) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor, contentColor = if (buttonColor == ChatBgColor) TextPrimaryDark else Color.White),
            shape = RoundedCornerShape(20.dp),
            border = if (buttonColor == ChatBgColor) BorderStroke(1.dp, InputBorderColor.copy(alpha = 0.5f)) else null,
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp)
        ) {
            Text(buttonLabel, fontSize = 13.sp)
        }
    }
}