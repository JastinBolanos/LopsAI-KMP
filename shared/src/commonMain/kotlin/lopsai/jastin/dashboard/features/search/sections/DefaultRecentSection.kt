package lopsai.jastin.dashboard.features.search.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.features.search.components.RecentChatRow
import lopsai.jastin.dashboard.features.search.components.SectionHeader

@Composable
fun DefaultRecentSection(onSelectChat: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        item {
            // New chat item
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onSelectChat("New chat") }
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Outlined.Edit, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text("New chat", fontSize = 14.sp, color = TextPrimaryDark)
            }

            SectionHeader("Today")
        }

        item {
            RecentChatRow("Brooklyn Sunrise Time", isSelected = false, onSelectChat)
            RecentChatRow("Manhattan Bus Comparisons", isSelected = true, onSelectChat)
            RecentChatRow("Typo Assistance Request", isSelected = false, onSelectChat)
        }

        item { SectionHeader("Yesterday") }
        item {
            RecentChatRow("Quadratic Function Plot", isSelected = false, onSelectChat)
            RecentChatRow("Toyota Names Poetry", isSelected = false, onSelectChat)
            RecentChatRow("Urban Green Spaces", isSelected = false, onSelectChat)
        }

        item { SectionHeader("Previous 7 Days") }
        item {
            RecentChatRow("Historical Landmarks Guide", isSelected = false, onSelectChat)
            RecentChatRow("Gourmet Food Truck Trends", isSelected = false, onSelectChat)
            RecentChatRow("Digital Art Techniques", isSelected = false, onSelectChat)
        }
    }
}