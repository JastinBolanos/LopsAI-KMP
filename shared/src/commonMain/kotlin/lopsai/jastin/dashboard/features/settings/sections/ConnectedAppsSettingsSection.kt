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
import androidx.compose.ui.graphics.vector.ImageVector
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
    onConnectGoogleDrive: () -> Unit = {},
    onConnectOneDrivePersonal: () -> Unit = {},
    onConnectOneDriveWork: () -> Unit = {},
    onDisconnectAppleIntelligence: () -> Unit = {},
    onLearnMoreConnectorsClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // --- SECCIÓN 1: FILE UPLOADS ---
        SectionHeader(
            icon = Icons.Outlined.Description,
            title = "File uploads",
            subtitle = "These apps will allow you to add files to LopsAI messages."
        )

        Spacer(modifier = Modifier.height(16.dp))
        SettingsDivider()

        ConnectedAppRow(
            iconContent = { GoogleDriveIcon() },
            title = "Google Drive",
            subtitle = "Upload Google Docs, Sheets, Slides and other files.",
            buttonText = "Connect",
            isConnected = false,
            onClick = onConnectGoogleDrive
        )
        SettingsDivider()

        ConnectedAppRow(
            iconContent = { OneDriveIcon() },
            title = "Microsoft OneDrive (personal)",
            subtitle = "Upload Microsoft Word, Excel, PowerPoint and other files.",
            buttonText = "Connect",
            isConnected = false,
            onClick = onConnectOneDrivePersonal
        )
        SettingsDivider()

        ConnectedAppRow(
            iconContent = { OneDriveIcon() },
            title = "Microsoft OneDrive (work/school)",
            subtitle = "Upload Microsoft Word, Excel, PowerPoint, and other files,\nincluding those from SharePoint sites.",
            buttonText = "Connect",
            isConnected = false,
            onClick = onConnectOneDriveWork
        )
        SettingsDivider()

        Spacer(modifier = Modifier.height(28.dp))

        // --- SECCIÓN 2: CONNECTORS ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.GridOn,
                contentDescription = null,
                tint = TextPrimaryDark,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Connectors",
                color = TextPrimaryDark,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        val connectorsSubtitle = buildAnnotatedString {
            append("Connect these data sources so LopsAI can access their information — based on what you're authorized to view. ")
            withStyle(
                style = SpanStyle(
                    color = TextSecondaryDark,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Learn more")
            }
        }

        Text(
            text = connectorsSubtitle,
            color = TextSecondaryDark,
            fontSize = 13.sp,
            lineHeight = 18.sp,
            modifier = Modifier.clickable(onClick = onLearnMoreConnectorsClick)
        )

        Spacer(modifier = Modifier.height(16.dp))
        SettingsDivider()

        ConnectedAppRow(
            iconContent = { AppleIntelligenceIcon() },
            title = "Apple Intelligence",
            subtitle = "Get personalized LopsAI responses and Plus benefits\nwhen using Siri and Writing Tools.",
            buttonText = "Disconnect",
            isConnected = true,
            onClick = onDisconnectAppleIntelligence
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun SectionHeader(icon: ImageVector, title: String, subtitle: String) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = null, tint = TextPrimaryDark, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = title, color = TextPrimaryDark, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = subtitle, color = TextSecondaryDark, fontSize = 13.sp, lineHeight = 18.sp)
    }
}

@Composable
private fun ConnectedAppRow(
    iconContent: @Composable () -> Unit,
    title: String,
    subtitle: String,
    buttonText: String,
    isConnected: Boolean,
    onClick: () -> Unit
) {
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
                Text(text = title, color = TextPrimaryDark, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = subtitle, color = TextSecondaryDark, fontSize = 13.sp, lineHeight = 17.sp)
            }
        }

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = ChatBgColor,
                contentColor = if (isConnected) Color(0xFFE53935) else TextPrimaryDark
            ),
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, InputBorderColor),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 6.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
        ) {
            Text(text = buttonText, fontSize = 13.sp, fontWeight = FontWeight.Normal)
        }
    }
}