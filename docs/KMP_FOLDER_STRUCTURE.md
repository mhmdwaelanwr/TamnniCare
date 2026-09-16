# Tamnni Care — KMP Folder Structure

## Project Root

```text
TamnniCare/
├── shared/
├── androidApp/
├── iosApp/
├── docs/
├── assets/
├── reference/
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Root Folder Purpose

### shared/

Shared Kotlin Multiplatform code:

- business logic
- domain models
- repositories
- use cases

### androidApp/

Android-specific code:

- Jetpack Compose UI
- Android navigation
- Android resources
- Notifications

### iosApp/

iOS-specific code:

- SwiftUI screens
- iOS navigation
- Notifications

### docs/

PRD, architecture, sitemap, user flows

### assets/

Brand assets, icons, screenshots, store assets, audios

### reference/

## Shared Module Structure

```text
shared/
└── src/
    ├── commonMain/
    │   └── kotlin/
    │       └── com/
    │           └── tamnnilabs/
    │               └── care/
    │                   ├── core/
    │                   ├── data/
    │                   ├── domain/
    │                   ├── features/
    │                   └── platform/
    ├── androidMain/
    ├── iosMain/
    └── commonTest/
```

## Suggested Shared Packages

### core/

- error/
- util/
- model/
- constants/
- extensions/

### domain/

- model/
- repository/
- usecase/

### data/

- remote/
- local/
- mapper/
- repository/

### features/

- auth/
- senior/
- caregiver/
- checkin/
- medication/
- alerts/
- family/

## Android UI Screen Structure

```text
androidApp/ui/screens/
├── onboarding/
├── auth/
├── senior/
├── caregiver/
├── medication/
├── alerts/
└── profile/
```

## Package Name

```text
com.tamnnilabs.care
```

## Build Order

1. shared/domain
2. shared/core
3. shared/data
4. androidApp/ui/theme
5. androidApp/ui/navigation
6. androidApp/ui/screens
7. notifications
8. iosApp after shared logic stabilizes
