package lopsai.jastin.dashboard.shared_ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.models.AppScreen // Import corregido
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun Sidebar(
    currentScreen: AppScreen,
    onClose: () -> Unit,
    onNavigateToGpts: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val sidebarBg = Color(0xFFF9F9F9)
    val hoverBg = Color(0xFFECECEC)

    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(sidebarBg)
    ) {
        // ==========================================
        // 1. TOP FIJO (Logo y Cerrar)
        // ==========================================
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .padding(top = 16.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Outlined.AutoAwesome, contentDescription = "Logo", modifier = Modifier.size(24.dp).padding(4.dp))
            Icon(
                imageVector = Icons.Outlined.ViewSidebar,
                contentDescription = "Close Sidebar",
                tint = TextSecondaryDark,
                modifier = Modifier
                    .size(28.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .clickable { onClose() }
                    .padding(4.dp)
            )
        }

        // ==========================================
        // 2. ZONA CON SCROLL (Menú + Chats)
        // ==========================================
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))

                // Botón New Chat -> Navega al Home
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { onNavigateToHome(); onClose() }
                ) {
                    SidebarItem(icon = Icons.Outlined.Edit, text = "New chat")
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Search Box
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(hoverBg)
                        .clickable { }
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Outlined.Search, contentDescription = "Search", modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Search chats", fontSize = 13.sp)
                    }
                    Text("⌘K", fontSize = 12.sp, color = TextSecondaryDark)
                }

                Spacer(modifier = Modifier.height(16.dp))
                SidebarItem(icon = Icons.Outlined.LibraryBooks, text = "Library", trailingText = "11")
                SidebarItem(icon = Icons.Outlined.PlayCircleOutline, text = "Sora")

                // Botón GPTs -> Se pinta de gris SI estás en la tienda y navega
                val gptsBg = if (currentScreen == AppScreen.GptStore) hoverBg else Color.Transparent
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(gptsBg)
                        .clickable { onNavigateToGpts(); onClose() }
                ) {
                    SidebarItem(icon = Icons.Outlined.GridView, text = "GPTs")
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text("Content", fontSize = 12.sp, color = TextSecondaryDark, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
                SidebarItem(icon = Icons.Outlined.Brush, text = "Canva")

                Spacer(modifier = Modifier.height(16.dp))
                Text("Chats", fontSize = 12.sp, color = TextSecondaryDark, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
            }

            // Lista dinámica de chats
            val dummyChats = listOf(
                "Typo Assistance Request", "Quadratic Function Plot", "Toyota Names Poetry",
                "Urban Green Spaces", "Historical Landmarks Guide", "Gourmet Food Truck Trends",
                "Digital Art Techniques", "Virtual Reality Experiences", "Local Music Scene"
            )

            items(dummyChats) { chat ->
                val interactionSource = remember { MutableInteractionSource() }
                Text(
                    text = chat,
                    fontSize = 13.sp,
                    color = TextPrimaryDark,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .clickable(interactionSource = interactionSource, indication = null) { }
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
        }

        // ==========================================
        // 3. BOTTOM FIJO (Upgrade Plan)
        // ==========================================
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { }
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Outlined.AutoAwesome, contentDescription = "Upgrade", modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Upgrade plan", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text("More access to the best models", fontSize = 11.sp, color = TextSecondaryDark)
            }
        }
    }
}