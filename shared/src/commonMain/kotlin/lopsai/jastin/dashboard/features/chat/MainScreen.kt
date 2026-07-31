package lopsai.jastin.dashboard.features.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import lopsai.jastin.dashboard.core.models.AppScreen
import lopsai.jastin.dashboard.core.models.ChatMessage
import lopsai.jastin.dashboard.core.theme.ChatBgColor
import lopsai.jastin.dashboard.features.chat.data.MockChatsData
import lopsai.jastin.dashboard.features.search.SearchChatsDialog
import lopsai.jastin.dashboard.features.settings.SettingsDialog
import lopsai.jastin.dashboard.features.share.ShareChatDialog
import lopsai.jastin.dashboard.shared_ui.layout.Sidebar

@Composable
fun MainScreen() {
    var showSettingsDialog by remember { mutableStateOf(false) }
    var showSearchDialog by remember { mutableStateOf(false) }
    var showShareDialog by remember { mutableStateOf(false) }

    var promptText by remember { mutableStateOf("") }
    var isDesktopSidebarOpen by remember { mutableStateOf(true) }

    var isChatActive by remember { mutableStateOf(false) }
    var messages by remember { mutableStateOf(listOf<ChatMessage>()) }
    var currentScreen by remember { mutableStateOf(AppScreen.Dashboard) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val handleSelectChat = { title: String ->
        isChatActive = true
        currentScreen = AppScreen.Dashboard
        messages = MockChatsData.getConversation(title)
    }

    val handleSend = {
        if (promptText.isNotBlank()) {
            isChatActive = true
            currentScreen = AppScreen.Dashboard
            val userMsg = promptText
            promptText = ""
            messages = listOf(
                ChatMessage(userMsg, isUser = true),
                ChatMessage(
                    "Alright! Here's something fresh and fascinating:\n\n**Scientists just discovered a plant that glows faintly in the dark — naturally.**\nThis find could open new doors in plant biology.",
                    isUser = false,
                    isTyping = true
                )
            )
        }
    }

    val navToGpts = { currentScreen = AppScreen.GptStore }
    val navToLibrary = { currentScreen = AppScreen.Library }
    val navToHome = {
        currentScreen = AppScreen.Dashboard
        isChatActive = false
        messages = emptyList()
    }

    MaterialTheme {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(ChatBgColor)
                .systemBarsPadding()
                .imePadding()
        ) {
            val isMobile = maxWidth < 768.dp
            val titleSize = if (isMobile) 24.sp else 32.sp

            if (isMobile) {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    scrimColor = Color.Black.copy(alpha = 0.4f),
                    drawerContent = {
                        ModalDrawerSheet(
                            drawerContainerColor = Color.Transparent,
                            drawerShape = RectangleShape,
                            modifier = Modifier.width(280.dp)
                        ) {
                            Sidebar(
                                currentScreen = currentScreen,
                                onClose = { coroutineScope.launch { drawerState.close() } },
                                onNavigateToGpts = navToGpts,
                                onNavigateToHome = navToHome,
                                onNavigateToLibrary = navToLibrary,
                                onSearchClick = { showSearchDialog = true },
                                onSelectChat = handleSelectChat,
                                isMobile = true,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                ) {
                    MainRouter(
                        isMobile = isMobile,
                        showDesktopSidebar = false,
                        titleSize = titleSize,
                        promptText = promptText,
                        onPromptChange = { promptText = it },
                        onSend = handleSend,
                        isChatActive = isChatActive,
                        messages = messages,
                        onMenuClick = { coroutineScope.launch { drawerState.open() } },
                        currentScreen = currentScreen
                    )
                }
            } else {
                Row(modifier = Modifier.fillMaxSize()) {
                    if (isDesktopSidebarOpen) {
                        Sidebar(
                            currentScreen = currentScreen,
                            onClose = { isDesktopSidebarOpen = false },
                            onNavigateToGpts = navToGpts,
                            onNavigateToHome = navToHome,
                            onNavigateToLibrary = navToLibrary,
                            onSearchClick = { showSearchDialog = true },
                            onSelectChat = handleSelectChat,
                            isMobile = false,
                            modifier = Modifier.width(260.dp)
                        )
                    }
                    MainRouter(
                        isMobile = false,
                        showDesktopSidebar = isDesktopSidebarOpen,
                        titleSize = titleSize,
                        promptText = promptText,
                        onPromptChange = { promptText = it },
                        onSend = handleSend,
                        isChatActive = isChatActive,
                        messages = messages,
                        onMenuClick = { isDesktopSidebarOpen = true },
                        currentScreen = currentScreen,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // ==========================================
            // DIÁLOGOS FLOTANTES (MODALES GLOBALES)
            // ==========================================
            if (showSearchDialog) {
                SearchChatsDialog(
                    onClose = { showSearchDialog = false },
                    onSelectChat = handleSelectChat
                )
            }

            if (showShareDialog) {
                ShareChatDialog(
                    onClose = { showShareDialog = false },
                    onUpdateLinkClick = {
                    },
                    onSettingsClick = {
                        showSettingsDialog = true
                    }
                )
            }

            if (showSettingsDialog) {
                SettingsDialog(
                    isMobile = isMobile,
                    onClose = { showSettingsDialog = false }
                )
            }
        }
    }
}