package lopsai.jastin.dashboard.features.store

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark
import lopsai.jastin.dashboard.features.store.components.*

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GptStoreScreen(
    isMobile: Boolean,
    isDarkMode: Boolean = false,
    modifier: Modifier = Modifier
) {
    val cardFraction = if (isMobile) 1f else 0.49f

    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color.White else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val searchBgColor = if (isDarkMode) Color(0xFF262630) else Color(0xFFF4F4F4)

    // EL VELO MÁGICO
    val overlayColor = if (isDarkMode) {
        Color(0xFF16161C).copy(alpha = 0.85f)
    } else {
        Color(0xFFF9F9F9).copy(alpha = 0.85f)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(overlayColor)
            .padding(horizontal = if (isMobile) 16.dp else 48.dp),
        contentPadding = PaddingValues(top = 24.dp, bottom = 64.dp)
    ) {
        // ==========================================
        // CABECERA Y BUSCADOR
        // ==========================================
        item {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("GPTs", fontSize = if (isMobile) 28.sp else 36.sp, fontWeight = FontWeight.Bold, color = textColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Discover and create custom versions of ChatGPT that combine\ninstructions, extra knowledge, and any combination of skills.",
                    fontSize = 14.sp, color = secondaryTextColor, textAlign = androidx.compose.ui.text.style.TextAlign.Center, lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Buscador
                Row(
                    modifier = Modifier
                        .fillMaxWidthInDesktop()
                        .clip(RoundedCornerShape(50))
                        .background(searchBgColor)
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Outlined.Search, contentDescription = "Search", tint = secondaryTextColor, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Search GPTs", color = secondaryTextColor, fontSize = 15.sp)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Categorías con Scroll Horizontal
                Row(
                    modifier = Modifier.fillMaxWidthInDesktop().horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.width(IntrinsicSize.Max)) {
                        Text("Featured", fontWeight = FontWeight.Bold, color = textColor)
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(textColor))
                    }
                    Text("Writing", color = secondaryTextColor)
                    Text("Productivity", color = secondaryTextColor)
                    Text("Research & Analysis", color = secondaryTextColor)
                    Text("Education", color = secondaryTextColor)
                    Text("Lifestyle", color = secondaryTextColor)
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }

        // ==========================================
        // SECCIÓN: FEATURED
        // ==========================================
        item { SectionTitle("Featured", "Curated top picks from this week", isDarkMode) }
        item {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                FeaturedCard(
                    modifier = Modifier.fillMaxWidth(cardFraction),
                    title = "DALL·E", desc = "OpenAI's legacy image generation model. Ask ChatGPT to create an image.",
                    author = "By ChatGPT", colors = listOf(Color(0xFF4F46E5), Color(0xFFEC4899)), icon = Icons.Outlined.Image,
                    isDarkMode = isDarkMode
                )
                FeaturedCard(
                    modifier = Modifier.fillMaxWidth(cardFraction),
                    title = "Dribbble", desc = "Find Top Designers & Creative Professionals on Dribbble.",
                    author = "By dribbble.com", colors = listOf(Color(0xFFF43F5E), Color(0xFFFB923C)), icon = Icons.Outlined.SportsBasketball,
                    isDarkMode = isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }

        // ==========================================
        // SECCIÓN: TRENDING
        // ==========================================
        item { SectionTitle("Trending", "Most popular GPTs by our community", isDarkMode) }
        item {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TrendingItem(1, Modifier.fillMaxWidth(cardFraction), "Behance", "The World's Best Creators Are On Behance - A comprehensive platform.", "By behance.com", listOf(Color(0xFF3B82F6), Color(0xFF60A5FA)), Icons.Outlined.Brush, isDarkMode)
                TrendingItem(2, Modifier.fillMaxWidth(cardFraction), "Dribbble", "Find Top Designers & Creative Professionals on Dribbble.", "By dribbble.com", listOf(Color(0xFF14B8A6), Color(0xFF06B6D4)), Icons.Outlined.SportsBasketball, isDarkMode)
                TrendingItem(3, Modifier.fillMaxWidth(cardFraction), "Logo Creator", "Use me to generate professional logo designs and app icons!", "By figma.com", listOf(Color(0xFF8B5CF6), Color(0xFFD946EF)), Icons.Outlined.FormatPaint, isDarkMode)
                TrendingItem(4, Modifier.fillMaxWidth(cardFraction), "Write For Me", "Write tailored, engaging content with a focus on quality.", "By figma.com", listOf(Color(0xFFF59E0B), Color(0xFFEF4444)), Icons.Outlined.Edit, isDarkMode)
            }
            Spacer(modifier = Modifier.height(16.dp))
            SeeMoreButton(isDarkMode)
            Spacer(modifier = Modifier.height(32.dp))
        }

        // ==========================================
        // SECCIÓN: BY CHATGPT
        // ==========================================
        item { SectionTitle("By ChatGPT", "GPTs created by the ChatGPT team", isDarkMode) }
        item {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TrendingItem(1, Modifier.fillMaxWidth(cardFraction), "Data Analyst", "Drop in any files and I can help analyze and visualize your data.", "By ChatGPT", listOf(Color(0xFF10B981), Color(0xFF34D399)), Icons.Outlined.BarChart, isDarkMode)
                TrendingItem(2, Modifier.fillMaxWidth(cardFraction), "Creative Writing", "I'm eager to read your work and give you feedback.", "By ChatGPT", listOf(Color(0xFFEC4899), Color(0xFFF43F5E)), Icons.Outlined.AutoStories, isDarkMode)
            }
            Spacer(modifier = Modifier.height(16.dp))
            SeeMoreButton(isDarkMode)
        }
    }
}