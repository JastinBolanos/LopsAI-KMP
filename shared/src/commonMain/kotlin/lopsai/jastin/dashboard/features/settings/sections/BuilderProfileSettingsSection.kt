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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.core.theme.InputBorderColor
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark
import lopsai.jastin.dashboard.features.settings.components.SocialBrandIcon

@Composable
fun BuilderProfileSettingsSection(
    modifier: Modifier = Modifier,
    onPreviewClick: () -> Unit = {},
    onSelectDomainClick: () -> Unit = {},
    onAddLinkedInClick: () -> Unit = {},
    onAddGitHubClick: () -> Unit = {},
    onAddXClick: () -> Unit = {},
    onReceiveFeedbackToggle: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(modifier = modifier.verticalScroll(scrollState)) {
        // --- DESCRIPCIÓN ---
        Text(
            text = "Personalize your builder profile to connect with users of your GPTs. These settings apply to publicly shared GPTs.",
            color = TextPrimaryDark,
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
                text = "Preview",
                color = TextSecondaryDark,
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
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF2D2D2D)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Hub,
                    contentDescription = "GPT Icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "LopsAIGPT",
                color = TextPrimaryDark,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(2.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "By community builder",
                    color = TextSecondaryDark,
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Outlined.PersonOutline,
                    contentDescription = null,
                    tint = TextSecondaryDark,
                    modifier = Modifier.size(14.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // --- WARNING BANNER VERIFICACIÓN ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 1.dp,
                    color = InputBorderColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color(0xFFFAFAFA))
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = Icons.Outlined.ErrorOutline,
                contentDescription = null,
                tint = TextPrimaryDark,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Complete verification to publish GPTs to everyone.\nVerify your identity by adding billing details or verifying ownership of a public domain name.",
                color = TextPrimaryDark,
                fontSize = 13.sp,
                lineHeight = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(color = InputBorderColor, thickness = 1.dp)
        Spacer(modifier = Modifier.height(20.dp))

        // --- LINKS SECTION ---
        Text(
            text = "Links",
            color = TextPrimaryDark,
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
                tint = TextPrimaryDark,
                modifier = Modifier.size(20.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Select a domain",
                    color = TextSecondaryDark,
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = null,
                    tint = TextSecondaryDark,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        SocialLinkRow(platformName = "LinkedIn", iconType = "linkedin", onClick = onAddLinkedInClick)
        SocialLinkRow(platformName = "GitHub", iconType = "github", onClick = onAddGitHubClick)
        SocialLinkRow(platformName = "X", iconType = "x", onClick = onAddXClick)

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = InputBorderColor, thickness = 1.dp)
        Spacer(modifier = Modifier.height(20.dp))

        // --- EMAIL SECTION ---
        Text(
            text = "Email",
            color = TextPrimaryDark,
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
                tint = TextPrimaryDark,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "byewind@live.com",
                color = TextPrimaryDark,
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
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Receive feedback emails",
                color = TextPrimaryDark,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun SocialLinkRow(
    platformName: String,
    iconType: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            SocialBrandIcon(type = iconType)
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = platformName,
                color = TextPrimaryDark,
                fontSize = 14.sp
            )
        }

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = ChatBgColor,
                contentColor = TextPrimaryDark
            ),
            shape = RoundedCornerShape(50),
            border = BorderStroke(1.dp, InputBorderColor),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
        ) {
            Text(text = "Add", fontSize = 13.sp, fontWeight = FontWeight.Normal)
        }
    }
}