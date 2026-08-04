package lopsai.jastin.dashboard.features.chat

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import lopsai.jastin.dashboard.core.models.AppScreen
import lopsai.jastin.dashboard.core.models.ChatMessage
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.features.chat.components.AITypingBubble
import lopsai.jastin.dashboard.features.chat.components.LivingWallpaperBg
import lopsai.jastin.dashboard.features.chat.components.SuggestionChips
import lopsai.jastin.dashboard.features.library.LibraryScreen
import lopsai.jastin.dashboard.features.settings.SettingsDialog
import lopsai.jastin.dashboard.features.share.ShareChatDialog
import lopsai.jastin.dashboard.features.store.GptStoreScreen
import lopsai.jastin.dashboard.shared_ui.inputs.OmniInput
import lopsai.jastin.dashboard.shared_ui.layout.TopHeader
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainRouter(
    isMobile: Boolean,
    showDesktopSidebar: Boolean,
    titleSize: TextUnit,
    promptText: String,
    onPromptChange: (String) -> Unit,
    onSend: () -> Unit,
    isChatActive: Boolean,
    messages: List<ChatMessage>,
    onMenuClick: () -> Unit,
    currentScreen: AppScreen,
    isDarkMode: Boolean = true,
    onThemeToggle: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var showSettingsDialog by remember { mutableStateOf(false) }
    var showShareDialog by remember { mutableStateOf(false) }

    // =========================================================================
    // 🌐 FONDO UNIVERSAL DE TODA LA PANTALLA (TECHO A PISO SIN LÍMITES)
    // =========================================================================
    Box(modifier = modifier.fillMaxSize()) {

        // CAPA 0: FONDO
        LivingWallpaperBg(
            isDarkMode = isDarkMode,
            isChatActive = isChatActive,
            modifier = Modifier.fillMaxSize()
        )

        val showUnifiedVeil = currentScreen == AppScreen.Library || currentScreen == AppScreen.GptStore
        val unifiedVeilColor = if (showUnifiedVeil) {
            if (isDarkMode) Color.Black.copy(alpha = 0.45f) else Color.White.copy(alpha = 0.65f)
        } else {
            Color.Transparent
        }

        //CAPA 1: INTERFAZ
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(unifiedVeilColor)
                .statusBarsPadding()
        ) {
            TopHeader(
                isSidebarVisible = showDesktopSidebar,
                isChatActive = isChatActive,
                onMenuClick = onMenuClick,
                onAvatarClick = { showSettingsDialog = true },
                onShareClick = { showShareDialog = true },
                isDarkMode = isDarkMode,
                modifier = Modifier.background(Color.Transparent)
            )

            Crossfade(
                targetState = currentScreen,
                label = "ScreenRouter",
                modifier = Modifier.weight(1f)
            ) { screen ->
                when (screen) {
                    AppScreen.GptStore -> GptStoreScreen(isMobile = isMobile, isDarkMode = isDarkMode)

                    AppScreen.Library -> LibraryScreen(
                        isMobile = isMobile,
                        isDarkMode = isDarkMode,
                        onProfileClick = { showSettingsDialog = true }
                    )

                    AppScreen.Dashboard -> {
                        Box(modifier = Modifier.fillMaxSize()) {
                            AnimatedContent(
                                targetState = isChatActive,
                                modifier = Modifier.fillMaxSize(),
                                transitionSpec = { fadeIn() togetherWith fadeOut() },
                                label = "ChatTransition"
                            ) { active ->
                                if (active) {
                                    LazyColumn(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(horizontal = if (isMobile) 16.dp else 48.dp)
                                            .padding(bottom = 120.dp),
                                        contentPadding = PaddingValues(vertical = 24.dp)
                                    ) {
                                        items(
                                            count = messages.size,
                                            key = { index -> "${messages.hashCode()}_$index" }
                                        ) { index ->
                                            val msg = messages[index]
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(vertical = 12.dp),
                                                horizontalAlignment = if (msg.isUser) Alignment.End else Alignment.Start
                                            ) {
                                                msg.imageRes?.let { resource ->
                                                    val isUserImg = msg.isUser
                                                    val imgWidth = if (isUserImg) 180.dp else 360.dp
                                                    val imgHeight = if (isUserImg) 135.dp else 270.dp
                                                    val cornerRadius = if (isUserImg) 20.dp else 24.dp

                                                    Box(
                                                        modifier = Modifier
                                                            .padding(bottom = 8.dp)
                                                            .size(width = imgWidth, height = imgHeight)
                                                            .clip(RoundedCornerShape(cornerRadius))
                                                            .background(Color(0xFF222222)),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Image(
                                                            painter = painterResource(resource),
                                                            contentDescription = "Chat attachment image",
                                                            modifier = Modifier.fillMaxSize(),
                                                            contentScale = ContentScale.Crop
                                                        )
                                                    }
                                                }

                                                if (msg.isUser) {
                                                    Box(
                                                        modifier = Modifier
                                                            .background(
                                                                if (isDarkMode) Color(0xFF262630) else Color(0xFFDEDEDE),
                                                                RoundedCornerShape(20.dp)
                                                            )
                                                            .padding(16.dp)
                                                    ) {
                                                        Text(
                                                            text = msg.text,
                                                            color = if (isDarkMode) Color.White else TextPrimaryDark
                                                        )
                                                    }
                                                } else {
                                                    AITypingBubble(
                                                        fullText = msg.text,
                                                        isTyping = msg.isTyping,
                                                        isDarkMode = isDarkMode
                                                    )
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(horizontal = if (isMobile) 16.dp else 24.dp)
                                            .padding(bottom = 120.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = "What can I help with ?",
                                            color = if (isDarkMode) Color(0xFFFFFFFF) else TextPrimaryDark,
                                            fontSize = titleSize,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.BottomCenter)
                                    .padding(horizontal = if (isMobile) 16.dp else 48.dp, vertical = 16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    OmniInput(
                                        value = promptText,
                                        onValueChange = onPromptChange,
                                        onSend = onSend,
                                        isChatActive = isChatActive,
                                        isDarkMode = isDarkMode,
                                        modifier = Modifier.widthIn(max = 768.dp)
                                    )
                                    if (!isChatActive) {
                                        Spacer(modifier = Modifier.height(16.dp))
                                        SuggestionChips(
                                            isDarkMode = isDarkMode,
                                            modifier = Modifier.widthIn(max = 768.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // MODALES GLOBALES (AJUSTES Y COMPARTIR)
        if (showSettingsDialog) {
            SettingsDialog(
                isMobile = isMobile,
                onClose = { showSettingsDialog = false },
                isDarkMode = isDarkMode,
                onThemeToggle = onThemeToggle
            )
        }

        if (showShareDialog) {
            ShareChatDialog(
                onClose = { showShareDialog = false },
                onUpdateLinkClick = { },
                onSettingsClick = { showSettingsDialog = true },
                isDarkMode = isDarkMode
            )
        }
    }
}