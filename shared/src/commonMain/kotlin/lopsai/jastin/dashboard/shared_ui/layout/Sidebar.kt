package lopsai.jastin.dashboard.shared_ui.layout

import androidx.compose.animation.*
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import lopsai.jastin.dashboard.core.models.AppScreen
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark

@Composable
fun Sidebar(
    currentScreen: AppScreen,
    onClose: () -> Unit,
    onNavigateToGpts: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    onNavigateToLibrary: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    isMobile: Boolean = false,
    modifier: Modifier = Modifier
) {
    val sidebarBg = Color(0xFFF9F9F9)
    val hoverBg = Color(0xFFECECEC)
    var comingSoonText by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(comingSoonText) {
        if (comingSoonText != null) {
            delay(2000L)
            comingSoonText = null
        }
    }

    Box(modifier = modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(sidebarBg)
        ) {
            // ==========================================
            // 1. TOP FIJO (Logo y Cerrar manualmente)
            // ==========================================
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 16.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.AutoAwesome,
                    contentDescription = "Logo",
                    modifier = Modifier.size(24.dp).padding(4.dp),
                    tint = TextPrimaryDark
                )
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

                    // 1. Botón New Chat
                    val newChatBg = if (currentScreen == AppScreen.Dashboard) hoverBg else Color.Transparent
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(newChatBg)
                            .clickable {
                                onNavigateToHome()
                                if (isMobile) onClose()
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.Edit, text = "New chat")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // 2. Search Box
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.Transparent)
                            .clickable {
                                onSearchClick()
                                if (isMobile) onClose()
                            }
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = "Search",
                                modifier = Modifier.size(16.dp),
                                tint = TextPrimaryDark
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Search chats", fontSize = 13.sp, color = TextPrimaryDark)
                        }
                        Text("⌘K", fontSize = 12.sp, color = TextSecondaryDark)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // 3. Botón Library
                    val libraryBg = if (currentScreen == AppScreen.Library) hoverBg else Color.Transparent
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(libraryBg)
                            .clickable {
                                onNavigateToLibrary()
                                if (isMobile) onClose()
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.LibraryBooks, text = "Library", trailingText = "11")
                    }

                    // ========================================================
                    // 4. SORA (TOCABLE CON AVISO TEMPORAL "PRÓXIMAMENTE")
                    // ========================================================
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                comingSoonText = "Sora: Próximamente..."
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.PlayCircleOutline, text = "Sora")
                    }

                    // 5. Botón GPTs
                    val gptsBg = if (currentScreen == AppScreen.GptStore) hoverBg else Color.Transparent
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(gptsBg)
                            .clickable {
                                onNavigateToGpts()
                                if (isMobile) onClose()
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.GridView, text = "GPTs")
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Content", fontSize = 12.sp, color = TextSecondaryDark, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

                    // ========================================================
                    // 6. CANVA (TOCABLE CON AVISO TEMPORAL "PRÓXIMAMENTE")
                    // ========================================================
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                comingSoonText = "Canva: Próximamente..."
                            }
                    ) {
                        SidebarItem(icon = Icons.Outlined.Brush, text = "Canva")
                    }

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
                            .clickable(interactionSource = interactionSource, indication = null) {
                                if (isMobile) onClose()
                            }
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
                Icon(Icons.Outlined.AutoAwesome, contentDescription = "Upgrade", modifier = Modifier.size(24.dp), tint = TextPrimaryDark)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Upgrade plan", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = TextPrimaryDark)
                    Text("More access to the best models", fontSize = 11.sp, color = TextSecondaryDark)
                }
            }
        }

        // ================================================================
        // 4. BANNER EPÍMERO ANIMADO (TOAST MULTIPLATAFORMA)
        // ================================================================
        AnimatedVisibility(
            visible = comingSoonText != null,
            enter = fadeIn() + slideInVertically(initialOffsetY = { 40 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { 40 }),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
                .padding(horizontal = 16.dp)
        ) {
            comingSoonText?.let { text ->
                Row(
                    modifier = Modifier
                        .shadow(8.dp, RoundedCornerShape(50))
                        .background(Color(0xFF222222), RoundedCornerShape(50))
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = text,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}