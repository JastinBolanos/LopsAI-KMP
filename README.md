<div align="center">
  <img src="docs/lopsai.png" alt="LopsAI Logo" width="120" />

  <h1>LopsAI-KMP | Enterprise-Grade AI Dashboard</h1>
  <h3>Multiplatform Architecture Showcase</h3>

  <p><strong>High-Performance UI/UX, Single Codebase, and Next-Gen Web & Mobile Deployment.</strong></p>

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

After a successful architectural design cycle with production-level foundations, this codebase has been surgically structured to act as an elite **Frontend & UI Architecture Showcase**.

**LopsAI-KMP** is not a generic template. It establishes a "competitive moat" in multiplatform development by demonstrating that highly complex, interactive interfaces — like an AI conversational dashboard — can exist in a single codebase without sacrificing visual fidelity, animation frame rates, or platform-native fluidity.

The architecture has been strategically streamlined to focus exclusively on market-dominant targets: **Mobile (Android/iOS) and Web (Wasm/JS)** — ensuring hyper-fast compilation times, minimal bundle sizes, and native-grade hardware acceleration.

---

## 2. Tech Stack & Technical Excellence

The project is governed by the *"Write once, run natively anywhere"* paradigm, optimized for scenarios with high visual load, dynamic gradient rendering, and real-time state mutations.

* **Core & UI Framework:** Kotlin Multiplatform (KMP) & Compose Multiplatform. Shares 100% of the UI design system, state handling, and navigation logic across platforms.
* **Web Optimization (Skiko / WebAssembly):** Direct canvas rendering via Skiko and WebAssembly (Wasm). Implements tailored viewport management in HTML to prevent browser font degradation, ensuring crisp vector text and sub-pixel alignment.
* **State Management & Zero-Crash Recomposition:** Rigorous utilization of explicit `key()` bindings inside `LazyColumn` and `LazyGrid` structures. This completely eradicates view-recycling collisions during high-frequency AI message updates.
* **Dynamic Visual Engine:** Custom `LivingWallpaperBg` implementation utilizing hardware-accelerated Compose Canvas shaders, rendering smooth ambient light glows with low GPU consumption.
* **Adaptive Light/Dark Theming:** Fully reactive theme provider driven by Compose `CompositionLocal`, providing instant UI color mutations without screen re-instantiation.

---

<div align="center">
  <h2>
    <img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExcHp0bDAxNXk1bG56OHp6MHU5NWp3aG95Zm9ndzNjNmh2amxpNTZmNiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9cw/F0VCptrJteVWDeLBHD/giphy.gif" width="50" align="center" /> 
    Live Interface Demonstrations
  </h2>
  <p><em>Experience the adaptive layout transition, live model toggling, and fluid glassmorphic UI across platforms.</em></p>
</div>

### 📱 Mobile Native Experience (Android & iOS)
*A comprehensive 59-second deep dive into the mobile application. Observe the fluid `OmniInput` expansion, seamless modal routing, instant Dark/Light mode mutations, and real-time conversational rendering with zero UI stuttering.*

https://github.com/user-attachments/assets/3cd6e81d-5aa1-4534-a139-d66eb65982b9

### 🖥️ WebAssembly Experience (Wasm/JS)
*Witness the adaptive desktop layout in action. Featuring a persistent sidebar, intelligent multi-column grids for premium tiers, and Skiko-powered canvas rendering that maintains absolute visual crispness across large widescreen viewports.*

https://github.com/user-attachments/assets/133028d0-2532-4523-832e-e3fe9904765b

---

## 3. Case Study: The AI Conversational Engine & Responsive UX

This module embodies a next-generation AI assistant interface, balancing deep visual customization with rendering fluidity for real-time streaming environments.

### Adaptive Layout & Ambient Navigation
At its core lies a responsive navigation architecture. On compact viewports, the interface utilizes a smooth sliding navigation drawer paired with an uncluttered header. The custom `OmniInput` input box supports multi-line expanding text, quick action pills (*Brainstorm, Code, Summarize*), and quick voice input toggles.

<p align="center">
  <img src="docs/01_dashboard_mobile.png" width="220" alt="Mobile Dashboard Dark"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/15_dashboard_mobile_light.png" width="220" alt="Mobile Dashboard Light"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/07_sidebar_navigation.png" width="220" alt="Sidebar Navigation Drawer"/>
</p>

### Model Switching, OmniInput Tools & Rich Media Rendering
The system features a lightweight modal selector allowing users to switch models dynamically (e.g., *GPT-4o mini, GPT-5, Claude Opus*). The `OmniInput` component expands to reveal specialized AI tool triggers (*Deep Research, Web Search, Code Generation, Image Generation*), while the chat window handles inline high-resolution image attachments and structured Markdown text without UI stuttering.

<p align="center">
  <img src="docs/02_model_selection_dropdown.png" width="220" alt="Model Selector Menu"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/14_input_tools_menu.png" width="220" alt="OmniInput Tools Menu"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/18_chat_image_response.png" width="220" alt="Rich Media Chat Attachment"/>
</p>

### Chat History Search & Public Link Sharing
Stateful overlay dialogs allow instant full-text filtering across current and past conversation threads grouped by time periods (*Today, Yesterday, Previous 7 Days*). Users can seamlessly generate shareable public URL links directly from any active chat session via a dedicated modal dialog.

<p align="center">
  <img src="docs/13_chat_history_search.png" width="220" alt="Chat History Search Modal"/>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <img src="docs/03_share_chat_dialog.png" width="220" alt="Public Link Sharing Modal"/>
</p>

### WebAssembly (Wasm) Architecture & Widescreen Adaptation
The architecture scales with absolute precision to any widescreen browser environment, powered entirely by WebAssembly (Wasm) and Skiko canvas rendering. By expanding into a persistent side navigation bar and fluid multi-column grids, the interface shatters traditional DOM limitations, delivering a hyper-fluid, native-app experience directly within the web—all from a single, unified Kotlin codebase.

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

A unified management layer built for user customization, platform integration, and tier-based monetization.

### Unified Settings & Cloud Connectors
The settings architecture is split into modular tabs managed via Compose state hoisting:
* **General:** Global theme switches (Dark/Light), code visibility toggles, and multi-language selections.
* **Personalization & Memory:** Custom instructions and persistent memory toggles.
* **Builder Profile:** Creator details, professional domain verifications, and public social links.
* **Connected Apps:** Integrations with cloud providers (*Google Drive, Microsoft OneDrive*) and native hardware frameworks (*Apple Intelligence*).

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
The **My Library** feature offers a grid of saved workspace environments and creative visual assets, rendering ambient background cards cleanly in both dark and light visual modes. The **GPT Store** features categorized discovery hubs (*Featured, Writing, Productivity, Research*) complete with trending creator rankings and direct launch buttons.

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
The premium subscription engine presents tier option cards (*LopsAI Plus, Pro, Max*) highlighting featured capabilities, custom pricing badges, and highlighted call-to-actions. Designed with responsive break-points, the dialog layout dynamically scales from vertical mobile stacks into balanced 3-column desktop wide views.

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

The codebase follows a rigorous multiplatform architecture approach, ensuring a strict separation of concerns and maximum code reusability:

- **`shared/commonMain`**: The pure, immutable core and UI layer. Contains 100% of the Compose Multiplatform logic, models, and shared components (`MainRouter`, `LivingWallpaper`, `OmniInput`).
- **`androidMain` / `iosMain`**: Native infrastructure layers strictly reserved for specific hardware implementations if needed (e.g., status bar padding).
- **`jsMain` / `wasmJsMain`**: Highly tuned web deployment layers. Configured to leverage browser capabilities via Webpack without bloating the project with unused targets.

### Architecture & UI Golden Rules

- **Target Isolation**: The architecture deliberately excludes JVM/Desktop modules to hyper-focus on Mobile and Web performance, eliminating legacy image rendering bugs and reducing build times.
- **Unidirectional Data Flow (UDF)**: State is hoisted to the highest logical level. UI components act as passive observers of state, guaranteeing predictable recompositions and side-effect-free rendering across all platforms.
- **Data Layer Abstraction**: Even as a UI showcase, the data supply is strictly decoupled. Datasets (like `MockChatsData`) simulate network and database repositories, proving the UI is fully prepared for a plug-and-play integration with real backend APIs.
- **DRY Principle in UI**: Components such as `SettingsRow`, `TopHeader`, and `SuggestionChips` are generic entities reused systematically throughout the application.
- **Passive UI**: `@Composable` functions are strictly limited to rendering states and bubbling up events (*Intents*) via lambdas, maintaining an unpolluted declarative tree.

---

## 7. Build Instructions

### Prerequisites
- **Android:** Android Studio (latest stable or Ladybug) with the KMP plugin enabled.
- **iOS:** macOS machine with Xcode 16+ installed.
- **Web:** Node.js (automatically handled by Gradle via Yarn setup).

### Local Deployment

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/JastinBolanos/LopsAI-KMP.git](https://github.com/JastinBolanos/LopsAI-KMP.git)
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