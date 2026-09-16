# Tamnni Care — Current KMP Folder Structure

This file documents the **repository as it exists today**. It replaces the older proposed `shared/ + androidApp/` layout, because Tamnni Care currently uses a single `composeApp` Kotlin Multiplatform module with shared Compose UI.

## Project Root

```text
TamnniCare/
├── composeApp/
├── iosApp/
├── docs/
├── assets/
├── reference/
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

## Root Folder Purpose

### `composeApp/`

Main Kotlin Multiplatform application module.

```text
composeApp/src/
├── commonMain/      # Shared Compose UI, navigation, state, resources
├── commonTest/      # Shared tests
├── androidMain/     # Android entry point and Android-specific integration
└── iosMain/         # iOS bridge and iOS-specific integration
```

The module currently owns both the shared application UI and most prototype state/business rules.

### `iosApp/`

Native iOS host project used to launch the shared Compose application through Xcode.

### `docs/`

Product and engineering documentation, including:

- PRD
- architecture
- user flows
- design-system documentation
- supporting product notes

### `assets/`

Project-owned branding, icons, palettes, and export assets.

### `reference/`

Textual prompts/product reference material retained for development context. Third-party/private visual inspiration is intentionally excluded from the public repository.

### `gradle/`

Gradle wrapper/version-catalog support.

## Shared Kotlin Organization

The current shared source tree is lightweight and product-oriented rather than deeply layered:

```text
composeApp/src/commonMain/kotlin/
├── com/tamnnilabs/care/    # Application entry/shared app wiring
└── ui/
    ├── components/          # Reusable Compose components
    ├── i18n/                # Language/resource helpers
    ├── navigation/          # Navigation graph and routes
    ├── screens/             # Product screens
    ├── state/               # State holders, prototype stores/providers
    └── theme/               # Shared visual theme
```

As production repositories/use cases are added later, non-UI logic can be separated into clearer `core`, `data`, `domain`, and `features` packages. That refactor is intentionally deferred until the additional complexity is justified.

## Package / Application ID

```text
com.tamnnilabs.care
```

## Build Targets

### Android

```bash
./gradlew :composeApp:assembleDebug
```

### Shared/Android tests

```bash
./gradlew :composeApp:testDebugUnitTest
```

### iOS

Open `iosApp/iosApp.xcodeproj` on macOS with Xcode. The Kotlin module exports the shared Compose app to the native host.

## Recommended Growth Order

1. Keep the current repository baseline buildable and documented.
2. Complete real product behavior behind existing UI flows.
3. Introduce repository/domain abstractions when remote/local production data exists.
4. Add notifications, authentication and family linking.
5. Expand automated tests and validate iOS on macOS/Xcode.
6. Add release media, store assets and production release pipelines.

See [`../ROADMAP.md`](../ROADMAP.md) for the detailed staged plan.
