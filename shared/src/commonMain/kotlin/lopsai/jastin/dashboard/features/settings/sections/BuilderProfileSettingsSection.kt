package lopsai.jastin.dashboard.features.settings.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun BuilderProfileSettingsSection(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false,
    onPreviewClick: () -> Unit = {},
    onSelectDomainClick: () -> Unit = {},
    onReceiveFeedbackToggle: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val uriHandler = LocalUriHandler.current

    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val dividerColor = if (isDarkMode) Color(0xFF32323A) else InputBorderColor
    val warningBannerBg = if (isDarkMode) Color(0xFF262630) else Color(0xFFFAFAFA)
    val checkboxBg = if (isDarkMode) Color.White else Color.Black
    val checkboxIconColor = if (isDarkMode) Color.Black else Color.White

    Column(modifier = modifier.verticalScroll(scrollState)) {
        Text(
            text = "Welcome to your creator sanctuary. Personalize your profile so the community can discover your AI models, explore your code, and connect with your vision.",
            color = textColor,
            fontSize = 13.sp,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // --- BOTÓN PREVIEW ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Preview Profile",
                color = secondaryTextColor,
                fontSize = 13.sp,
                modifier = Modifier.clickable(onClick = onPreviewClick)
            )
        }

        // --- TARJETA PREVIEW GPT ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(if (isDarkMode) Color(0xFF3F3F4E) else Color(0xFF2D2D2D)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Hub,
                    contentDescription = "GPT Icon",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "LopsAIGPT",
                color = textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "By Jastin Bolaños • Lead Developer",
                    color = secondaryTextColor,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.Outlined.Verified,
                    contentDescription = "Verified",
                    tint = Color(0xFF007AFF), // Azul verificado
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 1.dp,
                    color = dividerColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(warningBannerBg)
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = Icons.Outlined.RocketLaunch,
                contentDescription = null,
                tint = textColor,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Build your network! Link your professional domains, GitHub, and LinkedIn below so users can easily reach out for collaborations or feedback on your projects.",
                color = textColor,
                fontSize = 13.sp,
                lineHeight = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(color = dividerColor, thickness = 1.dp)
        Spacer(modifier = Modifier.height(20.dp))

        // --- LINKS SECTION ---
        Text(
            text = "Professional Links",
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onSelectDomainClick)
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Language,
                contentDescription = "Domain",
                tint = textColor,
                modifier = Modifier.size(20.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "jastinbolanos.dev",
                    color = secondaryTextColor,
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = null,
                    tint = secondaryTextColor,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        // ⚡ REDES SOCIALES CON VECTORES NATIVOS
        SocialLinkRow(
            platformName = "LinkedIn",
            icon = LinkedInIcon,
            iconColor = Color(0xFF0A66C2),
            isDarkMode = isDarkMode,
            onClick = { uriHandler.openUri("https://www.linkedin.com/in/jastin-bolanos") }
        )
        SocialLinkRow(
            platformName = "GitHub",
            icon = GithubIcon,
            iconColor = textColor,
            isDarkMode = isDarkMode,
            onClick = { uriHandler.openUri("https://github.com/jastinbolanos") }
        )

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = dividerColor, thickness = 1.dp)
        Spacer(modifier = Modifier.height(20.dp))

        // --- EMAIL SECTION ---
        Text(
            text = "Contact Email",
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.MailOutline,
                contentDescription = null,
                tint = textColor,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "jastinbolanos.dev@gmail.com",
                color = textColor,
                fontSize = 14.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onReceiveFeedbackToggle)
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(checkboxBg),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    contentDescription = null,
                    tint = checkboxIconColor,
                    modifier = Modifier.size(14.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Receive collaboration and feedback emails",
                color = textColor,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

// =========================================================================
// COMPONENTES INTERNOS DE LA PANTALLA
// =========================================================================

@Composable
private fun SocialLinkRow(
    platformName: String,
    icon: ImageVector,
    iconColor: Color,
    isDarkMode: Boolean,
    onClick: () -> Unit
) {
    val textColor = if (isDarkMode) Color(0xFFF3F4F6) else TextPrimaryDark
    val btnBgColor = if (isDarkMode) Color(0xFF262630) else ChatBgColor
    val btnBorderColor = if (isDarkMode) Color(0xFF3F3F4E) else InputBorderColor

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // ⚡ AQUI INYECTAMOS LOS VECTORES MATEMÁTICOS
            Icon(
                imageVector = icon,
                contentDescription = platformName,
                tint = iconColor,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = platformName,
                color = textColor,
                fontSize = 14.sp
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
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
        ) {
            Text(text = "Connect", fontSize = 13.sp, fontWeight = FontWeight.Normal)
        }
    }
}

// =========================================================================
// 🎨 VECTORES MATEMÁTICOS PUROS (NO PESAN NADA Y ESCALAN INFINITO)
// =========================================================================

private val GithubIcon: ImageVector
    get() = ImageVector.Builder(
        name = "Github",
        defaultWidth = 24.dp, defaultHeight = 24.dp,
        viewportWidth = 24f, viewportHeight = 24f
    ).apply {
        path(fill = SolidColor(Color.Black)) {
            moveTo(12f, 0f)
            curveTo(5.37f, 0f, 0f, 5.37f, 0f, 12f)
            curveTo(0f, 17.31f, 3.44f, 21.81f, 8.21f, 23.4f)
            curveTo(8.81f, 23.51f, 9f, 23.14f, 9f, 22.82f)
            curveTo(9f, 22.54f, 9f, 21.36f, 9f, 20.04f)
            curveTo(5.66f, 20.76f, 4.96f, 18.6f, 4.96f, 18.6f)
            curveTo(4.41f, 17.21f, 3.63f, 16.84f, 3.63f, 16.84f)
            curveTo(2.54f, 16.1f, 3.71f, 16.11f, 3.71f, 16.11f)
            curveTo(4.92f, 16.2f, 5.55f, 17.35f, 5.55f, 17.35f)
            curveTo(6.62f, 19.19f, 8.36f, 18.66f, 9.05f, 18.35f)
            curveTo(9.16f, 17.58f, 9.47f, 17.05f, 9.81f, 16.74f)
            curveTo(7.14f, 16.44f, 4.34f, 15.41f, 4.34f, 10.81f)
            curveTo(4.34f, 9.5f, 4.81f, 8.43f, 5.58f, 7.59f)
            curveTo(5.45f, 7.29f, 5.04f, 6.07f, 5.69f, 4.41f)
            curveTo(5.69f, 4.41f, 6.7f, 4.09f, 9.01f, 5.65f)
            curveTo(9.97f, 5.39f, 10.99f, 5.25f, 12f, 5.25f)
            curveTo(13.01f, 5.25f, 14.03f, 5.39f, 14.99f, 5.65f)
            curveTo(17.3f, 4.09f, 18.31f, 4.41f, 18.31f, 4.41f)
            curveTo(18.96f, 6.07f, 18.55f, 7.29f, 18.43f, 7.59f)
            curveTo(19.2f, 8.43f, 19.66f, 9.5f, 19.66f, 10.81f)
            curveTo(19.66f, 15.42f, 16.85f, 16.44f, 14.18f, 16.74f)
            curveTo(14.61f, 17.11f, 15f, 17.84f, 15f, 18.96f)
            curveTo(15f, 20.57f, 14.99f, 21.87f, 14.99f, 22.82f)
            curveTo(14.99f, 23.14f, 15.19f, 23.51f, 15.79f, 23.4f)
            curveTo(20.56f, 21.81f, 24f, 17.31f, 24f, 12f)
            curveTo(24f, 5.37f, 18.63f, 0f, 12f, 0f)
            close()
        }
    }.build()

private val LinkedInIcon: ImageVector
    get() = ImageVector.Builder(
        name = "LinkedIn",
        defaultWidth = 24.dp, defaultHeight = 24.dp,
        viewportWidth = 24f, viewportHeight = 24f
    ).apply {
        path(fill = SolidColor(Color.Black)) {
            moveTo(20.45f, 20.45f)
            lineTo(16.89f, 20.45f)
            lineTo(16.89f, 14.88f)
            curveTo(16.89f, 13.55f, 16.87f, 11.84f, 15f, 11.84f)
            curveTo(13.1f, 11.84f, 12.81f, 13.33f, 12.81f, 14.79f)
            lineTo(12.81f, 20.45f)
            lineTo(9.25f, 20.45f)
            lineTo(9.25f, 8.99f)
            lineTo(12.67f, 8.99f)
            lineTo(12.67f, 10.55f)
            lineTo(12.72f, 10.55f)
            curveTo(13.19f, 9.65f, 14.36f, 8.7f, 16.14f, 8.7f)
            curveTo(19.8f, 8.7f, 20.45f, 11.11f, 20.45f, 14.34f)
            lineTo(20.45f, 20.45f)
            close()
            moveTo(5.34f, 7.43f)
            curveTo(4.2f, 7.43f, 3.28f, 6.51f, 3.28f, 5.37f)
            curveTo(3.28f, 4.23f, 4.2f, 3.31f, 5.34f, 3.31f)
            curveTo(6.48f, 3.31f, 7.4f, 4.23f, 7.4f, 5.37f)
            curveTo(7.4f, 6.51f, 6.48f, 7.43f, 5.34f, 7.43f)
            close()
            moveTo(7.12f, 20.45f)
            lineTo(3.56f, 20.45f)
            lineTo(3.56f, 8.99f)
            lineTo(7.12f, 8.99f)
            lineTo(7.12f, 20.45f)
            close()
        }
    }.build()