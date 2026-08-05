<div align="center">

# LopsAI-KMP | Enterprise-Grade AI Dashboard

### Multiplatform Architecture Showcase

**High-Performance UI/UX, Single Codebase, and Next-Gen Web & Mobile Deployment.**

[![View Live Web Demo](https://img.shields.io/badge/View%20Live%20Web%20Demo-blue?style=for-the-badge&logo=googlechrome&logoColor=white)](https://github.com/TuUsuario/LopsAI-KMP/releases)
[![GitHub Release](https://img.shields.io/badge/Releases-gray?style=for-the-badge&logo=github)](https://github.com/TuUsuario/LopsAI-KMP/releases)
[![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Compose Multiplatform](https://img.shields.io/badge/Compose_Multiplatform-purple?style=for-the-badge&logo=android)](https://www.jetbrains.com/lp/compose-multiplatform/)
[![WebAssembly](https://img.shields.io/badge/WebAssembly-Optimized-654FF0?style=for-the-badge&logo=webassembly&logoColor=white)]()
[![iOS & Android](https://img.shields.io/badge/Mobile-Native_Fluidity-black?style=for-the-badge&logo=apple)]()
[![Clean Architecture](https://img.shields.io/badge/Architecture-Clean-orange?style=for-the-badge)]()

</div>

---

## 1. Project Vision and Repository Nature

After a successful architectural design cycle with production-level foundations, this codebase has been surgically structured to act as an elite **Frontend & UI Architecture Showcase**.
**LopsAI-KMP** is not a generic template. It establishes a "competitive moat" in multiplatform development by demonstrating that highly complex, interactive interfaces — like an AI conversational dashboard — can exist in a single codebase without sacrificing visual fidelity or performance.
The architecture has been strategically streamlined to focus exclusively on the highest-impact platforms: **Mobile (Android/iOS) and Web (Wasm/JS)** — ensuring hyper-fast compilation times and maximum performance in market-dominant ecosystems. Any developer, auditor, or Tech Lead can instantly clone and evaluate the system's UI prowess.

---

## 2. Tech Stack and Technical Excellence
The project is governed by the *"Write once, run natively anywhere"* paradigm, optimized for scenarios with high visual load, dynamic theming, and fluid animations.

- **Core & UI Framework:** Kotlin Multiplatform (KMP) and Compose Multiplatform. Shares 100% of the visual and business logic between Android, iOS, and the Browser.
- **Web Optimization (Skiko/Canvas):** Advanced implementation of Web deployment utilizing Skiko and WebAssembly/JS. Includes precise `viewport` management in HTML to prevent browser-scaling degradation, ensuring crisp text and layout rendering.
- **State Management & Recomposition:** Rigorous implementation of `key()` blocks and state management within Lazy structures (like the Chat list) to completely eradicate "reuse" crashes during high-speed view transitions.
- **Build Infrastructure:** Gradle Kotlin DSL (`build.gradle.kts`) optimized for a pure Mobile/Web ecosystem. Exclusion of unnecessary legacy desktop targets to reduce artifact weight and boost CI/CD scalability.
- **Dynamic Visual Engine:** Custom implementation of *Living Wallpapers* and animated state transitions (like the custom Switch components), running identically across all target platforms.

---

<div align="center">
<img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExcHp0bDAxNXk1bG56OHp6MHU5NWp3aG95Zm9ndzNjNmh2amxpNTZmNiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9cw/F0VCptrJteVWDeLBHD/giphy.gif" width="70" align="absmiddle" />

### Live Demo: LopsAI in Action
</div>

Explore the showcased experience: observe the interface's fluidity, the seamless dark/light mode transitions, and the adaptive layout that reshapes perfectly from a wide desktop browser down to a mobile screen. This brief demonstration presents LopsAI, an enterprise-grade AI dashboard built entirely using Kotlin Multiplatform.
> *(Replace this placeholder with your actual GIF demo)*
> https://github.com/user-attachments/assets/your-video-link-here

## 3. Case Study: The AI Conversational Interface

This module embodies a next-generation AI assistant, balancing deep aesthetic customization with the non-negotiable rendering fluidity demanded by real-time conversational interfaces.

### OmniInput & Adaptive Layout
At its core lies a highly responsive architecture. The custom `OmniInput` component intelligently handles multi-line prompts and interactive states, while the global layout seamlessly morphs from a persistent desktop sidebar into a sleek, mobile-first top-header navigation without losing view state.

<p align="left">
  <img src="docs/01_dashboard_desktop.png" width="350" alt="Desktop Sidebar Dashboard"/>
  &nbsp;&nbsp;&nbsp;
  <img src="docs/02_dashboard_mobile.png" width="200" alt="Mobile TopHeader Navigation"/>
</p>

### High-Performance Chat Rendering
State management is pushed to the limit using highly optimized `LazyColumn` structures. By implementing complex composite keys, the architecture completely eradicates rendering collisions during rapid state mutations (reuse crashes). The UI seamlessly integrates dynamic image attachments, smooth corner masking, and real-time AI typing indicators (`AITypingBubble`).

<p align="left">
  <img src="docs/03_chat_attachments.png" width="250" alt="Chat with Image Attachments"/>
  &nbsp;&nbsp;&nbsp;
  <img src="docs/04_ai_typing_animation.gif" width="250" alt="AI Typing Indicator GIF"/>
  &nbsp;&nbsp;&nbsp;
  <img src="docs/05_chat_history.png" width="250" alt="Scrollable Chat History"/>
</p>

---

## 4. Case Study: Ecosystem Management (Library & Settings)

A cohesive ecosystem designed for comprehensive user management, demonstrating complex modal routing, state hoisting, and reactive theme mutations in Compose.

### Dynamic Theming & Living Backgrounds
The Settings module grants access to appearance configurations. The system includes an interactive, animated dropdown for theme selection and smoothly animated toggles that instantly mutate the global application state, including a breathtaking dynamic gradient background (`LivingWallpaperBg`).

<p align="left">
  <img src="docs/06_settings_modal.png" width="250" alt="Settings Dialog"/>
  &nbsp;&nbsp;&nbsp;
  <img src="docs/07_theme_selection.png" width="250" alt="Theme Dropdown"/>
  &nbsp;&nbsp;&nbsp;
  <img src="docs/08_light_mode.png" width="250" alt="Light Mode Applied"/>
</p>

### Library & App Navigation
Implementation of a custom `Crossfade` transition system for navigating between the Main Dashboard, the Prompts Library, and the GPT Store, ensuring the background veil and global aesthetics remain undisturbed during screen swaps.

<p align="left">
  <img src="docs/09_library_screen.png" width="250" alt="Library View"/>
  &nbsp;&nbsp;&nbsp;
  <img src="docs/10_store_screen.png" width="250" alt="GPT Store"/>
  &nbsp;&nbsp;&nbsp;
  <img src="docs/11_share_dialog.png" width="250" alt="Share Modal"/>
</p>

--- 

## 5. Software Architecture (Project Map) The following diagram illustrates the routing and UI logic implemented in the application: 

  ```bash
  graph TD
    %% Punto de Entrada
    Start([App Start]) --> App[App.kt]
    App --> Theme[ChatGPTTheme & Platform Init]
    Theme --> Router(MainRouter)

    %% Capa Base y Navegación
    Router --> Layout{Adaptive Layout}
    Layout -->|Fondo Dinámico| LivingBg[LivingWallpaperBg]
    Layout -->|Desktop / Web| Sidebar[Sidebar & SidebarItem]
    Layout -->|Móvil| TopHeader[TopHeader]

    %% Enrutamiento Principal
    Router --> ScreenState{Current AppScreen?}

    %% 1. Módulo: Dashboard (Chat)
    ScreenState -->|Dashboard| Chat[Main Dashboard Area]
    Chat --> Input[OmniInput Container]
    Input --> Tools[ToolsTray & ThemeToggleButton]
    Input --> Chips[SuggestionChips]
    
    Chat --> List[Lazy Message List]
    List --> MsgUI[Chat Message Render]
    MsgUI --> UserMsg[Image Scaling & User Text]
    MsgUI --> AIMsg[AITypingBubble]

    %% 2. Módulo: Library
    ScreenState -->|Library| Lib[LibraryScreen]
    Lib --> LibHeader[LibraryTopBar]
    Lib --> LibGrid[LibraryCardItem List]

    %% 3. Módulo: GPT Store
    ScreenState -->|GptStore| Store[GptStoreScreen]
    Store --> StoreHeader[SectionTitle & SeeMoreButton]
    Store --> Featured[FeaturedCard]
    Store --> Trending[TrendingItem & ChatGptModelItem]

    %% Modales Globales e Interacciones
    Router --> Modals{Global Actions}

    %% Buscador (Search)
    Modals -->|Search Click / Cmd+K| Search[SearchChatsDialog]
    Search --> SearchUI[SearchComponents]
    SearchUI --> Recent[DefaultRecentSection]
    SearchUI --> Results[SimulatedResultsSection]

    %% Ajustes (Settings)
    Modals -->|Avatar Click| Settings[SettingsDialog]
    Settings --> SettingsMenu[SettingsSidebar & Header]
    SettingsMenu --> SettingsSections{Settings Sections}
    SettingsSections --> Sec1[Personalization & General]
    SettingsSections --> Sec2[Data Controls & Security]
    SettingsSections --> Sec3[Builder Profile & Speech]

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
   git clone [https://github.com/TuUsuario/LopsAI-KMP.git](https://github.com/TuUsuario/LopsAI-KMP.git)
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