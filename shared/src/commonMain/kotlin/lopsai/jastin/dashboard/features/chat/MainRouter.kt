package lopsai.jastin.dashboard.features.chat

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import lopsai.jastin.dashboard.core.models.AppScreen
import lopsai.jastin.dashboard.core.models.ChatMessage
import lopsai.jastin.dashboard.core.theme.TextPrimaryDark
import lopsai.jastin.dashboard.features.chat.components.AITypingBubble
import lopsai.jastin.dashboard.features.chat.components.SuggestionChips
import lopsai.jastin.dashboard.features.settings.SettingsDialog
import lopsai.jastin.dashboard.features.store.GptStoreScreen
import lopsai.jastin.dashboard.shared_ui.inputs.OmniInput
import lopsai.jastin.dashboard.shared_ui.layout.TopHeader

@Composable
fun MainRouter(
    isMobile: Boolean, showDesktopSidebar: Boolean, titleSize: TextUnit,
    promptText: String, onPromptChange: (String) -> Unit, onSend: () -> Unit,
    isChatActive: Boolean, messages: List<ChatMessage>, onMenuClick: () -> Unit,
    currentScreen: AppScreen, modifier: Modifier = Modifier
) {
    var showSettingsDialog by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxHeight()) {
        TopHeader(
            isSidebarVisible = showDesktopSidebar,
            isChatActive = isChatActive,
            onMenuClick = onMenuClick,
            onAvatarClick = { showSettingsDialog = true }
        )

        Crossfade(targetState = currentScreen, label = "ScreenRouter", modifier = Modifier.weight(1f)) { screen ->
            when (screen) {
                AppScreen.GptStore -> {
                    GptStoreScreen(isMobile = isMobile)
                }
                AppScreen.Dashboard -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        AnimatedContent(
                            targetState = isChatActive, modifier = Modifier.fillMaxSize(),
                            transitionSpec = { fadeIn() togetherWith fadeOut() }, label = "ChatTransition"
                        ) { active ->
                            if (active) {
                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = if (isMobile) 16.dp else 48.dp)
                                        .padding(bottom = 120.dp),
                                    contentPadding = PaddingValues(vertical = 24.dp)
                                ) {
                                    items(messages.size) { index ->
                                        val msg = messages[index]
                                        Column(
                                            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                                            horizontalAlignment = if (msg.isUser) Alignment.End else Alignment.Start
                                        ) {
                                            if (msg.isUser) {
                                                Box(modifier = Modifier.background(Color(0xFFF4F4F4), RoundedCornerShape(20.dp)).padding(16.dp)) {
                                                    Text(msg.text, color = TextPrimaryDark)
                                                }
                                            } else {
                                                AITypingBubble(msg.text, msg.isTyping)
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
                                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                                ) {
                                    Text("What can I help with ?", color = TextPrimaryDark, fontSize = titleSize, fontWeight = FontWeight.SemiBold)
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
                                OmniInput(value = promptText, onValueChange = onPromptChange, onSend = onSend, isChatActive = isChatActive, modifier = Modifier.widthIn(max = 768.dp))
                                if (!isChatActive) {
                                    Spacer(modifier = Modifier.height(16.dp))
                                    SuggestionChips(modifier = Modifier.widthIn(max = 768.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    if (showSettingsDialog) {
        SettingsDialog(
            isMobile = isMobile,
            onClose = { showSettingsDialog = false }
        )
    }
}