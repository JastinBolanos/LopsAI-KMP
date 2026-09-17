<div align="center">
  <img src="docs/lopsai.png" alt="LopsAI Logo" width="120" />

  <h1>LopsAI-KMP | AI Conversational Client</h1>
  <h3>Multiplatform Architecture Showcase</h3>

  <p><strong>A responsive AI conversational frontend built with Compose Multiplatform, delivering native Android and Web experiences from a shared Kotlin codebase.</strong></p>

[![View Live Web Demo](https://img.shields.io/badge/View%20Live%20Web%20Demo-blue?style=for-the-badge&logo=googlechrome&logoColor=white)](https://github.com/TuUsuario/LopsAI-KMP/releases)
[![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Compose Multiplatform](https://img.shields.io/badge/Compose_Multiplatform-purple?style=for-the-badge&logo=android)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![WebAssembly](https://img.shields.io/badge/WebAssembly-Optimized-654FF0?style=for-the-badge&logo=webassembly&logoColor=white)]()
[![iOS & Android](https://img.shields.io/badge/Mobile-Native_Fluidity-black?style=for-the-badge&logo=apple)]()
[![Clean Architecture](https://img.shields.io/badge/Architecture-Clean-orange?style=for-the-badge)]()

<p align="center">
  <a href="https://github.com/JastinBolanos/LopsAI-KMP/releases/download/v1.0.0/lopsai.apk">
    <img src="https://img.shields.io/badge/Download-APK%20Android-green?style=for-the-badge&logo=android&logoColor=white" alt="Descargar APK">
  </a>
</p>
</div>

---

## 1. Project Vision & Repository Nature

This codebase serves as a **Frontend & UI Architecture Showcase**, designed to explore responsive layouts, rich component hierarchies, and interactive client-side patterns for conversational AI applications.

**LopsAI-KMP** illustrates how conversational interfaces, dynamic navigation trees, and visual themes can be implemented across Android and Web environments using Compose Multiplatform. By sharing presentation state, styling systems, and layout logic within a unified Kotlin core, the project provides a coherent user experience on mobile devices and browser windows while remaining structurally prepared for iOS.

The repository emphasizes clean UI component separation, lightweight client state, and responsive adaptations between compact handheld screens and widescreen desktop displays.

---

## 2. Tech Stack & Technical Foundations

The project leverages modern multiplatform tooling to share UI components and presentation logic across supported form factors while preserving platform-native feel.

* **Core & UI Framework:** Kotlin Multiplatform (KMP) & Compose Multiplatform. Powers client experiences across Android and modern web browsers, sharing the UI design system, state handling, and navigation logic, structurally ready to extend to iOS.
* **Web Rendering (Skiko / WebAssembly):** Direct canvas rendering via Skiko and WebAssembly (Wasm). Uses tailored viewport configurations in HTML to ensure crisp typography and consistent alignment across browser engines.
* **State Management & Recomposition Stability:** Employs explicit `key()` parameters in `LazyColumn` and `LazyGrid` structures to maintain predictable scroll positions and prevent layout recalculation issues during frequent message list updates.
* **Ambient Visual Elements:** Custom `LivingWallpaperBg` implementation utilizing Compose Canvas shaders to render subtle ambient lighting effects with efficient graphics performance.
* **Adaptive Theme System:** Centralized light and dark theme management supported by Compose `CompositionLocal`, applying palette transitions smoothly across components without recreating views.

---

<div align="center">
  <h2>
    <img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExcHp0bDAxNXk1bG56OHp6MHU5NWp3aG95Zm9ndzNjNmh2amxpNTZmNiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9cw/F0VCptrJteVWDeLBHD/giphy.gif" width="50" align="center" /> 
    Live Interface Demonstrations
  </h2>
  <p><em>Overview of the responsive layout system, model selector interactions, and cross-platform UI components.</em></p>
</div>

### 📱 Mobile Native Experience
*A 59-second walkthrough of the mobile interface. Highlights the expandable `OmniInput` field, sheet-based modal navigation, instant light/dark theme switching, and real-time message stream rendering.*

https://github.com/user-attachments/assets/3cd6e81d-5aa1-4534-a139-d66eb65982b9

### 🖥️ WebAssembly Experience (Wasm/JS)
*Demonstration of the widescreen desktop adaptation. Features a collapsible sidebar, multi-column grids for catalog views, and Skiko canvas rendering maintaining typography sharpness across large display formats.*

https://github.com/user-attachments/assets/133028d0-2532-4523-832e-e3fe9904765b

---

## 3. Case Study: The AI Conversational Engine & Responsive UX

This module showcases a modern AI conversational interface, balancing interactive tool trays with fluid rendering suited for continuous message streaming.

### Adaptive Layout & Ambient Navigation
At the center of the application is a responsive navigation framework. On compact screens, users interact with a sliding drawer alongside a clean header bar. The custom `OmniInput` field supports multi-line text expansion, quick action prompts (*Brainstorm, Code, Summarize*), and voice input indicators.

<p align="center">
  <img src="docs/01_dashboard_mobile.png" width="220" alt="Mobile Dashboard Dark"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/15_dashboard_mobile_light.png" width="220" alt="Mobile Dashboard Light"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/07_sidebar_navigation.png" width="220" alt="Sidebar Navigation Drawer"/>
</p>

### Model Switching, OmniInput Tools & Rich Media Rendering
A modal selector enables users to choose between simulated model profiles (such as *GPT-4o mini, GPT-5, Claude Opus*). The `OmniInput` container expands into specialized prompt tools (*Deep Research, Web Search, Code Generation, Image Generation*), while the chat stream supports inline media attachments and structured Markdown formatting.

<p align="center">
  <img src="docs/02_model_selection_dropdown.png" width="220" alt="Model Selector Menu"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/14_input_tools_menu.png" width="220" alt="OmniInput Tools Menu"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/18_chat_image_response.png" width="220" alt="Rich Media Chat Attachment"/>
</p>

### Chat History Search & Public Link Sharing
Dialog overlays support full-text searching across conversation threads grouped chronologically (*Today, Yesterday, Previous 7 Days*). A dedicated modal workflow demonstrates public link generation and sharing flows directly from the conversation view.

<p align="center">
  <img src="docs/13_chat_history_search.png" width="220" alt="Chat History Search Modal"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/03_share_chat_dialog.png" width="220" alt="Public Link Sharing Modal"/>
</p>

### WebAssembly (Wasm) Architecture & Widescreen Adaptation
The interface layout adapts gracefully to widescreen browser environments via WebAssembly (Wasm) and Skiko canvas rendering. Expanding from mobile drawers into persistent sidebar navigation and balanced multi-column grids, the client delivers an application-style experience on the desktop web from the same Kotlin UI codebase.

<p align="center">
  <img src="docs/19_dashboard_web_dark.png" width="400" alt="Web Dashboard Dark"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/27_dashboard_web_light.png" width="400" alt="Web Dashboard Light"/>
</p>

<p align="center">
  <img src="docs/22_gpt_store_web_dark.png" width="400" alt="Web GPT Store Dark"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/25_gpt_store_web_light.png" width="400" alt="Web GPT Store Light"/>
</p>

<p align="center">
  <img src="docs/23_library_grid_web_dark.png" width="400" alt="Web Library Grid Dark"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/24_library_grid_web_light.png" width="400" alt="Web Library Grid Light"/>
</p>

<p align="center">
  <img src="docs/20_premium_upgrade_web_dark.png" width="400" alt="Web Premium Pricing Grid Dark"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/26_premium_upgrade_web_light.png" width="400" alt="Web Premium Pricing Grid Light"/>
</p>

<p align="center">
  <img src="docs/21_chat_image_web_dark.png" width="600" alt="Web Chat Image Interface"/>
</p>

---

## 4. Case Study: Ecosystem Management (Library, GPT Store & Settings)

A consolidated client interface designed to explore personal workspace libraries, discovery catalogs, and account settings.

### Unified Settings & Cloud Connectors
The settings section is structured into modular tabs using Compose state hoisting:
* **General:** Theme switching (Dark/Light), code visibility toggles, and language preferences.
* **Personalization & Memory:** Custom instructions and memory management toggles.
* **Builder Profile:** Creator information, verified custom domains, and social profile links.
* **Connected Apps:** Interface integrations for cloud services (*Google Drive, Microsoft OneDrive*) and platform capabilities (*Apple Intelligence*).

<p align="center">
  <img src="docs/09_settings_general.png" width="210" alt="General Settings Tab"/>
  &nbsp;&nbsp;
  <img src="docs/12_settings_personalization.png" width="210" alt="Personalization Settings Tab"/>
  &nbsp;&nbsp;
  <img src="docs/10_settings_builder_profile.png" width="210" alt="Builder Profile Settings Tab"/>
  &nbsp;&nbsp;
  <img src="docs/11_settings_connected_apps.png" width="210" alt="Connected Apps Tab"/>
</p>

### Asset Library & Custom GPT Discovery Store
The **My Library** section organizes saved workspaces and visual assets in an adaptive grid, pairing ambient gradient cards with dark and light theme styles. The **GPT Store** presents categorized discovery feeds (*Featured, Writing, Productivity, Research*) with creator profiles and direct entry actions.

<p align="center">
  <img src="docs/06_library_gradients.png" width="210" alt="My Library Grid Dark"/>
  &nbsp;&nbsp;
  <img src="docs/17_library_grid_light.png" width="210" alt="My Library Grid Light"/>
  &nbsp;&nbsp;
  <img src="docs/04_gpt_store_featured.png" width="210" alt="GPT Store Featured Tier"/>
  &nbsp;&nbsp;
  <img src="docs/05_gpt_store_trending.png" width="210" alt="GPT Store Trending Rankings"/>
</p>

### Responsive Monetization & Tier Upgrade Dialogs
The subscription tier dialog presents feature comparison cards (*LopsAI Plus, Pro, Max*) detailing available capabilities, pricing badges, and primary action buttons. The dialog utilizes responsive breakpoints to transition from a single-column mobile layout into an organized three-column desktop presentation.

<p align="center">
  <img src="docs/08_premium_upgrade_modal.png" width="240" alt="Premium Upgrade Dark Mode"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/16_premium_upgrade_light.png" width="240" alt="Premium Upgrade Light Mode"/>
</p>

---

## 5. Architectural Breakdown & Performance Guardrails

```mermaid
graph TD
  %% Punto de Entrada
  Start([App Start]) --> App[App.kt]
  App --> Theme["ChatGPTTheme & Platform Init"]
  Theme --> Router(MainRouter)

  %% Capa Base y Navegación
  Router --> Layout{Adaptive Layout}
  Layout -->|Fondo Dinámico| LivingBg[LivingWallpaperBg]
  Layout -->|Desktop / Web| Sidebar["Sidebar & SidebarItem"]
  Layout -->|Móvil| TopHeader[TopHeader]

  %% Enrutamiento Principal
  Router --> ScreenState{Current AppScreen?}

  %% 1. Módulo: Dashboard (Chat)
  ScreenState -->|Dashboard| Chat[Main Dashboard Area]
  Chat --> Input[OmniInput Container]
  Input --> Tools["ToolsTray & ThemeToggleButton"]
  Input --> Chips[SuggestionChips]
  
  Chat --> List[Lazy Message List]
  List --> MsgUI[Chat Message Render]
  MsgUI --> UserMsg["Image Scaling & User Text"]
  MsgUI --> AIMsg[AITypingBubble]

  %% 2. Módulo: Library
  ScreenState -->|Library| Lib[LibraryScreen]
  Lib --> LibHeader[LibraryTopBar]
  Lib --> LibGrid["LibraryCardItem List"]

  %% 3. Módulo: GPT Store
  ScreenState -->|GptStore| Store[GptStoreScreen]
  Store --> StoreHeader["SectionTitle & SeeMoreButton"]
  Store --> Featured[FeaturedCard]
  Store --> Trending["TrendingItem & ChatGptModelItem"]

  %% Modales Globales e Interacciones
  Router --> Modals{Global Actions}

  %% Buscador (Search)
  Modals -->|Search Click / Cmd+K| Search[SearchChatsDialog]
  Search --> SearchUI[SearchComponents]
  SearchUI --> Recent[DefaultRecentSection]
  SearchUI --> Results[SimulatedResultsSection]

  %% Ajustes (Settings)
  Modals -->|Avatar Click| Settings[SettingsDialog]
  Settings --> SettingsMenu["SettingsSidebar & Header"]
  SettingsMenu --> SettingsSections{Settings Sections}
  SettingsSections --> Sec1["Personalization & General"]
  SettingsSections --> Sec2["Data Controls & Security"]
  SettingsSections --> Sec3["Builder Profile & Speech"]

  %% Compartir (Share)
  Modals -->|Share Click| Share[ShareChatDialog]
  ```

---

## 6. Clean Architecture & Engineering Principles

The codebase organizes multiplatform code with clear layer boundaries to facilitate maintainability and code reuse:

- **`shared/commonMain`**: The primary UI and domain layer. Contains the Compose Multiplatform layouts, models, and shared presentation components (`MainRouter`, `LivingWallpaper`, `OmniInput`).
- **`androidMain` / `iosMain`**: Platform-specific integration layers, utilized for platform considerations such as system bar insets and platform-specific window handling.
- **`jsMain` / `wasmJsMain`**: Browser target configurations tuned for web deployment and canvas rendering.

### Architecture & UI Guidelines

- **Focused Platform Targets**: The architecture focuses specifically on mobile and web environments, simplifying the graphics pipeline and build targets.
- **Unidirectional Data Flow (UDF)**: UI components act as observers of hoisted state flows, ensuring deterministic recompositions and consistent visual feedback across platforms.
- **Decoupled Data Layer**: Presentation logic relies on repository abstractions. Fixture datasets (such as `MockChatsData`) provide local mock responses and simulate async latency, making the UI ready for direct API integration.
- **Reusable UI Components**: Elements like `SettingsRow`, `TopHeader`, and `SuggestionChips` are built as self-contained, reusable building blocks.
- **Declarative UI Patterns**: `@Composable` functions remain focused on rendering state and delegating user events via callbacks to associated ViewModels.

---

## 7. Build Instructions

### Prerequisites
- **Android:** Android Studio (latest stable or Ladybug) with the KMP plugin enabled.
- **iOS:** macOS machine with Xcode 16+ installed.
- **Web:** Node.js (automatically handled by Gradle via Yarn setup).

### Local Deployment

1. **Clone the repository:**
   ```bash
   git clone https://github.com/JastinBolanos/LopsAI-KMP.git
   cd LopsAI-KMP
   ```
**For Android:**
- Open the project in Android Studio.
- Select the `androidApp` configuration.
- Press *Run*.

**For iOS:**
- Open the `iosApp` folder in Xcode.
- Wait for *Swift* and *Assets* indexing to complete.
- Select a simulator (e.g., iPhone 15/16) and press `Cmd + R`.
- Xcode will automatically delegate the compilation of the Kotlin framework to Gradle.

**For Web (Browser):**
- Open the terminal in Android Studio.
- Run the following Gradle command to start the Webpack dev server:
  ```bash
  ./gradlew :webApp:jsBrowserDevelopmentRun
  ```

Open http://localhost:8080 in your preferred browser.
