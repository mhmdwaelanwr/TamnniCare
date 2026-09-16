# Tamnni Care — Architecture

This document describes the **current repository architecture**. Future production components are listed separately so the repository does not present planned work as already implemented.

## 1. Architecture Goal

Tamnni Care is a Kotlin Multiplatform mobile app focused on a calm, elderly-friendly reassurance flow for seniors and their families.

The current baseline prioritizes:

- shared product UI and state across Android and iOS
- a small, understandable MVP surface
- platform-specific entry/lifecycle integration where needed
- local prototype persistence for reassurance state
- a clear path toward production data, notifications, auth, and family linking later

## 2. Current Stack

### Shared application

- Kotlin Multiplatform
- Compose Multiplatform
- Material 3
- Navigation Compose
- Compose Resources
- Multiplatform Settings
- kotlinx-datetime

### Android

- Android application target inside `composeApp`
- Android entry point and platform code under `composeApp/src/androidMain`

### iOS

- iOS Kotlin target inside `composeApp`
- `ComposeUIViewController` bridge under `composeApp/src/iosMain`
- native Xcode host project under `iosApp`

## 3. Current Repository Structure

```text
TamnniCare/
├── composeApp/
│   └── src/
│       ├── commonMain/      # Shared Compose UI, navigation, state and resources
│       ├── commonTest/      # Shared tests
│       ├── androidMain/     # Android entry point/platform integration
│       └── iosMain/         # iOS Compose bridge/platform integration
├── iosApp/                  # Native iOS application shell
├── docs/                    # Product, architecture, flows and design-system docs
├── assets/branding/         # Original project branding/export assets
├── reference/               # Textual product/reference notes
├── gradle/                  # Gradle wrapper and version catalog support
└── .github/workflows/       # Android CI and repository-health checks
```

## 4. Current Application Layers

The prototype currently keeps the architecture deliberately lightweight.

### UI

Shared Compose screens and reusable components live in `composeApp/src/commonMain/kotlin/ui`.

The current navigation graph includes:

- Splash
- Onboarding
- Role selection
- Senior home
- Caregiver home
- Settings
- Profile
- Reassurance history
- Alerts
- Medication overview
- About

### State

Feature state holders live in the shared source set. The current baseline includes shared state for reassurance, senior/caregiver home presentation, profile/display samples, appearance, language, and startup routing.

Some providers are intentionally in-memory/sample implementations because this repository is still an MVP foundation rather than a production backend-connected application.

### Persistence

Daily reassurance state uses lightweight local persistence suitable for the prototype. Production-grade account, family, medication, and alert persistence is not implemented yet.

### Platform integration

Android and iOS own their platform entry/lifecycle integration while reusing the shared Compose application.

## 5. What Is Implemented vs Planned

### Implemented baseline

- Shared Compose Multiplatform UI
- Android and iOS targets
- onboarding and role flows
- senior and caregiver home experiences
- local reassurance state and refresh policy
- settings for language/appearance
- medication/alert/history/profile supporting screens
- shared unit tests
- Android CI
- repository hygiene and secret-pattern checks

### Planned production layers

These are **not current dependencies or completed integrations**:

- remote API/backend
- authentication/session management
- family linking
- production medication repository and scheduling
- real caregiver/help alert delivery
- push/local notification scheduling
- production database layer
- analytics/telemetry
- crash reporting
- production security/privacy hardening

Ktor, Kotlinx Serialization, Koin, SQLDelight, or another persistence/DI stack may be evaluated later when the product requirements justify them; they are not claimed as part of the current implementation.

## 6. Direction for Future Refactoring

As the project grows, feature logic can move toward clearer boundaries such as:

```text
commonMain/kotlin/
├── core/
├── data/
├── domain/
├── features/
└── ui/
```

That refactor should happen when real repositories, backend integration, and production use cases exist. The current codebase should not be split into abstraction layers only for appearance.

## 7. Design System

Design references remain documented in:

- `docs/design_system/DESIGN_TOKENS.md`
- `docs/design_system/COLOR_ROLES.md`
- `docs/design_system/TYPOGRAPHY.md`
- `assets/branding/palette/brand_colors.md`
- `assets/branding/palette/colors.json`

Shared Compose theme/components should continue to derive from those project-owned design decisions.

## 8. Safety Boundary

Tamnni Care is currently a family-reassurance prototype. It is not a medical device or emergency service. Help/alert UI must not be described as a live emergency integration until a real delivery path, failure handling, privacy model, and production validation are implemented.

## 9. Build Validation

The repository currently validates Android compilation and unit tests in GitHub Actions. iOS source is present, but final iOS build/runtime validation still requires macOS/Xcode.

See [`ROADMAP.md`](../ROADMAP.md) for the staged development plan.
