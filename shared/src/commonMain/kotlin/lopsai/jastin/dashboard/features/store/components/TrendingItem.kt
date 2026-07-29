package lopsai.jastin.dashboard.features.store.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun TrendingItem(rank: Int, modifier: Modifier, title: String, desc: String, author: String, colors: List<Color>, icon: ImageVector) {
    Row(modifier = modifier.clickable { }.padding(8.dp), verticalAlignment = Alignment.Top) {
        Text(
            text = "$rank",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = TextSecondaryDark,
            modifier = Modifier.padding(top = 12.dp, end = 12.dp)
        )
        PremiumGradientIcon(colors, icon, 42)
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = TextPrimaryDark)
            Spacer(modifier = Modifier.height(2.dp))
            Text(desc, fontSize = 13.sp, color = TextSecondaryDark, maxLines = 2, overflow = TextOverflow.Ellipsis, lineHeight = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(author, fontSize = 11.sp, color = Color(0xFF999999))
        }
    }
}