package lopsai.jastin.dashboard.features.search.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.core.theme.TextSecondaryDark
import lopsai.jastin.dashboard.features.search.components.SearchColors

@Composable
fun SimulatedResultsSection(
    @Suppress("UNUSED_PARAMETER") query: String,
    onSelectChat: (String) -> Unit,
    isDarkMode: Boolean = false
) {
    // 🎨 PALETA DINÁMICA
    val textColor = if (isDarkMode) Color.White else TextPrimaryDark
    val secondaryTextColor = if (isDarkMode) Color(0xFFA1A1AA) else TextSecondaryDark
    val iconColor = if (isDarkMode) SearchColors.TextMutedDark else TextPrimaryDark
    val bgSelected = if (isDarkMode) SearchColors.SelectedItemBgDark else SearchColors.SelectedItemBgLight
    val mutedDateColor = if (isDarkMode) SearchColors.TextMutedDark else SearchColors.TextMutedLight

    val mockResults = listOf(
        Pair("Design System & UI Kit - ", "SnowUI is a Design System and UI Kit created with Figma. Features Use new feature..."),
        Pair("", "SnowUI. Inspirational designs, illustrations, and graphic elements from the..."),
        Pair(" Chart - Figma Resources", "SnowUI Chart. 100+ charts in different styles designed using chart components."),
        Pair("Design System & UI Kit - ", "SnowUI is a Design System and UI Kit created with Figma. Features Use new feature..."),
        Pair(" Chart - Figma Resources", "SnowUI Chart. 100+ charts in different styles designed using chart components.")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        items(mockResults.withIndex().toList()) { (index, item) ->
            val isSelected = index == 1

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isSelected) bgSelected else Color.Transparent) // ⚡ CONECTADO
                    .clickable { onSelectChat("SnowUI") }
                    .padding(horizontal = 14.dp, vertical = 14.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Outlined.ChatBubbleOutline,
                    contentDescription = null,
                    tint = iconColor, // ⚡ CONECTADO
                    modifier = Modifier
                        .size(18.dp)
                        .padding(top = 2.dp)
                )
                Spacer(modifier = Modifier.width(14.dp))

                Column(modifier = Modifier.weight(1f)) {
                    val titleText = buildAnnotatedString {
                        if (index == 1) {
                            withStyle(SpanStyle(color = SearchColors.HighlightBlue)) { append("SnowUI") }
                        } else {
                            append(item.first.substringBefore(" - ", item.first))
                            withStyle(SpanStyle(color = SearchColors.HighlightBlue)) { append("SnowUI") }
                            if (item.first.contains(" - ")) append(" - " + item.first.substringAfter(" - "))
                        }
                    }
                    Text(text = titleText, fontSize = 15.sp, color = textColor) // ⚡ CONECTADO

                    Spacer(modifier = Modifier.height(4.dp))

                    val subtitleText = buildAnnotatedString {
                        withStyle(SpanStyle(color = SearchColors.HighlightBlue)) { append("SnowUI") }
                        append(item.second.removePrefix("SnowUI"))
                    }
                    Text(
                        text = subtitleText,
                        fontSize = 13.sp,
                        color = secondaryTextColor, // ⚡ CONECTADO
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (isSelected) {
                    Text("Today", color = mutedDateColor, fontSize = 13.sp) // ⚡ CONECTADO
                }
            }
        }
    }
}