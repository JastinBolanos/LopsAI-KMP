package lopsai.jastin.dashboard.features.store.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun FeaturedCard(
    modifier: Modifier,
    title: String,
    desc: String,
    author: String,
    colors: List<Color>,
    icon: ImageVector,
    isDarkMode: Boolean = false
) {
    val cardBg = if (isDarkMode) Color(0xFF262630) else Color(0xFFF9F9F9)
    val textColor = if (isDarkMode) Color.White else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(cardBg)
            .clickable { }
            .padding(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        PremiumGradientIcon(colors, icon, 48)
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = textColor)
            Spacer(modifier = Modifier.height(4.dp))
            Text(desc, fontSize = 13.sp, color = secondaryTextColor, maxLines = 2, overflow = TextOverflow.Ellipsis, lineHeight = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(author, fontSize = 11.sp, color = Color(0xFF999999))
        }
    }
}