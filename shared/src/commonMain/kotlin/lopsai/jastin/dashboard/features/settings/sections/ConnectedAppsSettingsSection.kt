package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.GridOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark
import lopsai.jastin.dashboard.features.settings.components.*

@Composable
fun ConnectedAppsSettingsSection(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false,
    onConnectGoogleDrive: () -> Unit = {},
    onConnectOneDrivePersonal: () -> Unit = {},
    onConnectOneDriveWork: () -> Unit = {},
    onDisconnectAppleIntelligence: () -> Unit = {},
    onLearnMoreConnectorsClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // --- SECCIÓN 1: FILE UPLOADS ---
        SectionHeader(
            icon = Icons.Outlined.Description,
            title = "File uploads",
            subtitle = "These apps will allow you to add files to LopsAI messages.",
            isDarkMode = isDarkMode
        )

        Spacer(modifier = Modifier.height(16.dp))
        SettingsDivider(isDarkMode = isDarkMode)

        ConnectedAppRow(
            iconContent = { GoogleDriveIcon() },
            title = "Google Drive",
            subtitle = "Upload Google Docs, Sheets, Slides and other files.",
            buttonText = "Connect",
            isConnected = false,
            isDarkMode = isDarkMode,
            onClick = onConnectGoogleDrive
        )
        SettingsDivider(isDarkMode = isDarkMode)

        ConnectedAppRow(
            iconContent = { OneDriveIcon() },
            title = "Microsoft OneDrive (personal)",
            subtitle = "Upload Microsoft Word, Excel, PowerPoint and other files.",
            buttonText = "Connect",
            isConnected = false,
            isDarkMode = isDarkMode,
            onClick = onConnectOneDrivePersonal
        )
        SettingsDivider(isDarkMode = isDarkMode)

        ConnectedAppRow(
            iconContent = { OneDriveIcon() },
            title = "Microsoft OneDrive (work/school)",
            subtitle = "Upload Microsoft Word, Excel, PowerPoint, and other files,\nincluding those from SharePoint sites.",
            buttonText = "Connect",
            isConnected = false,
            isDarkMode = isDarkMode,
            onClick = onConnectOneDriveWork
        )
        SettingsDivider(isDarkMode = isDarkMode)

        Spacer(modifier = Modifier.height(28.dp))

        // --- SECCIÓN 2: CONNECTORS ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.GridOn,
                contentDescription = null,
                tint = textColor,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Connectors",
                color = textColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        val connectorsSubtitle = buildAnnotatedString {
            append("Connect these data sources so LopsAI can access their information — based on what you're authorized to view. ")
            withStyle(
                style = SpanStyle(
                    color = secondaryTextColor,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Learn more")
            }
        }

        Text(
            text = connectorsSubtitle,
            color = secondaryTextColor,
            fontSize = 13.sp,
            lineHeight = 18.sp,
            modifier = Modifier.clickable(onClick = onLearnMoreConnectorsClick)
        )

        Spacer(modifier = Modifier.height(16.dp))
        SettingsDivider(isDarkMode = isDarkMode)

        ConnectedAppRow(
            iconContent = { AppleIntelligenceIcon() },
            title = "Apple Intelligence",
            subtitle = "Get personalized LopsAI responses and Plus benefits\nwhen using Siri and Writing Tools.",
            buttonText = "Disconnect",
            isConnected = true,
            isDarkMode = isDarkMode,
            onClick = onDisconnectAppleIntelligence
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun SectionHeader(
    icon: ImageVector,
    title: String,
    subtitle: String,
    isDarkMode: Boolean
) {
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = null, tint = textColor, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = title, color = textColor, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = subtitle, color = secondaryTextColor, fontSize = 13.sp, lineHeight = 18.sp)
    }
}

@Composable
private fun ConnectedAppRow(
    iconContent: @Composable () -> Unit,
    title: String,
    subtitle: String,
    buttonText: String,
    isConnected: Boolean,
    isDarkMode: Boolean,
    onClick: () -> Unit
) {
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val btnBgColor = if (isDarkMode) Color(0xFF262630) else ChatBgColor
    val btnBorderColor = if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor
    val btnTextColor = if (isConnected) Color(0xFFE53935) else textColor

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f).padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(28.dp), contentAlignment = Alignment.Center) {
                iconContent()
            }
            Spacer(modifier = Modifier.width(14.dp))
            Column {
                Text(text = title, color = textColor, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = subtitle, color = secondaryTextColor, fontSize = 13.sp, lineHeight = 17.sp)
            }
        }

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = btnBgColor,
                contentColor = btnTextColor
            ),
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, btnBorderColor),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 6.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
        ) {
            Text(text = buttonText, fontSize = 13.sp, fontWeight = FontWeight.Normal)
        }
    }
}

// =========================================================================
// 🚀 VECTORES MATEMÁTICOS CORREGIDOS Y PERFECTOS
// =========================================================================

@Composable
private fun GoogleDriveIcon() {
    Icon(
        imageVector = GoogleDriveVector,
        contentDescription = "Google Drive",
        tint = Color.Unspecified,
        // ⚡ CORRECCIÓN: Dimensiones matemáticas exactas para evitar el estiramiento.
        modifier = Modifier.size(width = 26.dp, height = 23.2.dp)
    )
}

@Composable
private fun OneDriveIcon() {
    Icon(
        imageVector = OneDriveVector,
        contentDescription = "Microsoft OneDrive",
        tint = Color.Unspecified,
        modifier = Modifier.size(26.dp)
    )
}

private val GoogleDriveVector: ImageVector
    get() = ImageVector.Builder(
        name = "GoogleDrive",
        defaultWidth = 26.dp, defaultHeight = 23.2.dp,
        viewportWidth = 87.3f, viewportHeight = 78f
    ).apply {
        path(fill = SolidColor(Color(0xFF0066DA))) {
            moveTo(6.6f, 66.85f)
            lineToRelative(3.85f, 6.65f)
            curveToRelative(0.8f, 1.4f, 1.95f, 2.5f, 3.3f, 3.3f)
            lineTo(27.5f, 53f)
            horizontalLineTo(0f)
            curveToRelative(0f, 1.55f, 0.4f, 3.1f, 1.2f, 4.5f)
            close()
        }
        path(fill = SolidColor(Color(0xFF00AC47))) {
            moveTo(43.65f, 25f)
            lineTo(29.9f, 1.2f)
            curveToRelative(-1.35f, 0.8f, -2.5f, 1.9f, -3.3f, 3.3f)
            lineToRelative(-25.4f, 44f)
            arcTo(9.06f, 9.06f, 0f, false, false, 0f, 53f)
            horizontalLineToRelative(27.5f)
            close()
        }
        path(fill = SolidColor(Color(0xFFEA4335))) {
            moveTo(73.55f, 76.8f)
            curveToRelative(1.35f, -0.8f, 2.5f, -1.9f, 3.3f, -3.3f)
            lineToRelative(1.6f, -2.75f)
            lineTo(86.1f, 57.5f)
            curveToRelative(0.8f, -1.4f, 1.2f, -2.95f, 1.2f, -4.5f)
            horizontalLineTo(59.798f)
            lineToRelative(5.852f, 11.5f)
            close()
        }
        path(fill = SolidColor(Color(0xFF00832D))) {
            moveTo(43.65f, 25f)
            lineTo(57.4f, 1.2f)
            curveTo(56.05f, 0.4f, 54.5f, 0f, 52.9f, 0f)
            horizontalLineTo(34.4f)
            curveToRelative(-1.6f, 0f, -3.15f, 0.45f, -4.5f, 1.2f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2684FC))) {
            moveTo(59.8f, 53f)
            horizontalLineTo(27.5f)
            lineTo(13.75f, 76.8f)
            curveToRelative(1.35f, 0.8f, 2.9f, 1.2f, 4.5f, 1.2f)
            horizontalLineToRelative(50.8f)
            curveToRelative(1.6f, 0f, 3.15f, -0.45f, 4.5f, -1.2f)
            close()
        }
        path(fill = SolidColor(Color(0xFFFFBA00))) {
            moveTo(73.4f, 26.5f)
            lineToRelative(-12.7f, -22f)
            curveToRelative(-0.8f, -1.4f, -1.95f, -2.5f, -3.3f, -3.3f)
            lineTo(43.65f, 25f)
            lineTo(59.8f, 53f)
            horizontalLineToRelative(27.45f)
            curveToRelative(0f, -1.55f, -0.4f, -3.1f, -1.2f, -4.5f)
            close()
        }
    }.build()

private val OneDriveVector: ImageVector
    get() = ImageVector.Builder(
        name = "OneDrive",
        defaultWidth = 24.dp, defaultHeight = 24.dp,
        viewportWidth = 24f, viewportHeight = 24f
    ).apply {
        // ⚡ NUBE TRASERA (Azul Oscuro)
        path(fill = SolidColor(Color(0xFF0078D4))) {
            moveTo(5.5f, 15f)
            lineTo(11.5f, 15f)
            curveTo(13.43f, 15f, 15f, 13.43f, 15f, 11.5f)
            curveTo(15f, 9.57f, 13.43f, 8f, 11.5f, 8f)
            curveTo(11.18f, 8f, 10.88f, 8.05f, 10.59f, 8.13f)
            curveTo(10.13f, 6.06f, 8.3f, 4.5f, 6f, 4.5f)
            curveTo(3.24f, 4.5f, 1f, 6.74f, 1f, 9.5f)
            curveTo(1f, 9.92f, 1.05f, 10.33f, 1.15f, 10.72f)
            curveTo(0.46f, 11.23f, 0f, 12.06f, 0f, 13f)
            curveTo(0f, 14.1f, 0.9f, 15f, 2f, 15f)
            close()
        }
        // ⚡ NUBE DELANTERA (Azul Claro)
        path(fill = SolidColor(Color(0xFF1490DF))) {
            moveTo(12.3f, 21.2f)
            lineTo(19.5f, 21.2f)
            curveTo(21.82f, 21.2f, 23.7f, 19.32f, 23.7f, 17f)
            curveTo(23.7f, 14.68f, 21.82f, 12.8f, 19.5f, 12.8f)
            curveTo(19.12f, 12.8f, 18.76f, 12.86f, 18.41f, 12.96f)
            curveTo(17.86f, 10.47f, 15.66f, 8.6f, 12.9f, 8.6f)
            curveTo(9.59f, 8.6f, 6.9f, 11.29f, 6.9f, 14.6f)
            curveTo(6.9f, 15.1f, 6.96f, 15.6f, 7.08f, 16.06f)
            curveTo(6.25f, 16.68f, 5.7f, 17.67f, 5.7f, 18.8f)
            curveTo(5.7f, 20.12f, 6.78f, 21.2f, 8.1f, 21.2f)
            close()
        }
    }.build()