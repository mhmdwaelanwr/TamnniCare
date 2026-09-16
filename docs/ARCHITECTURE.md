# Tamnni Care — Updated Architecture

## 1) Architecture Goal
Build a clean, scalable KMP architecture for **Tamnni Care**, with:
- Android first
- iOS ready later
- shared business logic
- platform-specific UI
- clear design token ownership
- low-complexity MVP delivery

---

## 2) Product Direction
Tamnni Care is a **family reassurance app** for elderly care.

It is **not** a full medical platform and **not** a caregiver marketplace.

### Core V1 features
- daily check-in
- medication reminders
- missed check-in alert
- help request
- caregiver summary

---

## 3) Platform Strategy

### Shared
- business logic
- data models
- repositories
- use cases
- validation rules
- reminder/check-in evaluation logic

### Android
- Jetpack Compose UI
- Android navigation
- notification scheduling
- permissions
- Android resources

### iOS
- SwiftUI UI
- iOS navigation
- local/push notification handling
- iOS-specific lifecycle integration

---

## 4) Tech Stack

### Core
- Kotlin Multiplatform (KMP)
- Android UI: Jetpack Compose
- iOS UI: SwiftUI

### Data / Integration
- Ktor
- Kotlinx Serialization
- Koin
- SQLDelight or simple shared persistence for MVP

### Design
- source-of-truth design tokens in docs + palette files
- Compose theme derived from design tokens
- SwiftUI theme derived from same design tokens

---

## 5) Root Structure

```text
TamnniCare/
├── shared/
├── androidApp/
├── iosApp/
├── docs/
├── assets/
├── reference/
└── README.md
```

---

## 6) Shared Module Structure

```text
shared/src/commonMain/kotlin/com/tamnnilabs/care/
├── core/
├── domain/
├── data/
├── features/
└── platform/
```

### core
Shared fundamentals:
- result wrappers
- errors
- constants
- date/time utilities
- common extensions

### domain
Pure business logic:
- models
- repository contracts
- use cases

### data
Implementations:
- remote source
- local source
- mappers
- repository implementations

### features
Feature-level organization:
- auth
- senior
- caregiver
- checkin
- medication
- alerts
- family

### platform
Wrappers for:
- notifications
- settings
- device APIs
- permission bridges

---

## 7) Recommended Feature Breakdown

### auth
- sign in
- sign up
- session restore
- sign out

### senior
- senior home state
- next medication summary
- help request state

### caregiver
- caregiver home summary
- linked senior status
- daily reassurance card
- quick follow-up actions

### checkin
- submit check-in
- get today's status
- calculate missed state after grace period

### medication
- medication list
- next dose
- taken / snooze / missed states

### alerts
- missed check-in alert
- help alert
- alert list
- alert status

### family
- link caregiver
- linked family members
- alert receivers

---

## 8) UI Ownership

### Android App Owns
- Compose screens
- navigation graph
- top bars / bottom bars
- Android notification permission flow
- Android resources (fonts, launcher icons, etc.)

### iOS App Owns
- SwiftUI screens
- iOS navigation
- iOS permission prompts
- iOS notification handling
- app icon and platform-specific assets

### Shared Does Not Own
- concrete UI widgets
- platform navigation frameworks
- platform resource files

---

## 9) Design System Integration

Design tokens should live outside raw code first, then be implemented in code.

### Source of truth files
- `docs/design_system/DESIGN_TOKENS.md`
- `docs/design_system/COLOR_ROLES.md`
- `docs/design_system/TYPOGRAPHY.md`
- `assets/branding/palette/brand_colors.md`
- `assets/branding/palette/colors.json`

### Android implementation files later
- `androidApp/ui/theme/Color.kt`
- `androidApp/ui/theme/Type.kt`
- `androidApp/ui/theme/Theme.kt`

### iOS implementation files later
- `iosApp/Theme/Colors.swift`
- `iosApp/Theme/Typography.swift`

---

## 10) Recommended Data Models

### User
- id
- name
- role
- phoneOrEmail
- language

### SeniorProfile
- id
- userId
- dailyCheckInTime
- caregiverIds

### Medication
- id
- seniorId
- name
- dosage
- timesPerDay
- reminderTimes

### CheckIn
- id
- seniorId
- timestamp
- status

### Alert
- id
- seniorId
- type
- createdAt
- recipientIds
- status

---

## 11) Suggested Repositories
- `AuthRepository`
- `UserRepository`
- `SeniorRepository`
- `MedicationRepository`
- `CheckInRepository`
- `AlertRepository`
- `FamilyRepository`

---

## 12) Suggested Use Cases

### Auth
- `SignInUseCase`
- `SignUpUseCase`
- `SignOutUseCase`
- `RestoreSessionUseCase`

### Check-in
- `SubmitDailyCheckInUseCase`
- `GetTodayCheckInStatusUseCase`
- `EvaluateMissedCheckInUseCase`

### Medication
- `GetMedicationListUseCase`
- `GetNextMedicationUseCase`
- `MarkMedicationTakenUseCase`
- `SnoozeMedicationUseCase`

### Alerts
- `SendHelpAlertUseCase`
- `SendMissedCheckInAlertUseCase`
- `GetActiveAlertsUseCase`

### Family
- `LinkCaregiverUseCase`
- `GetLinkedFamilyUseCase`

---

## 13) Notification Architecture

### Shared logic decides
- what event happened
- whether a state is missed / active / resolved
- which alert type is needed

### Platform layer handles
- scheduling
- push/local delivery
- permission prompts
- platform notification categories

### Notification types
- medication reminder
- missed check-in
- help request

---

## 14) MVP Build Order

### Phase 1
- project skeleton
- theme shell
- navigation shell
- auth base

### Phase 2
- role selection
- senior setup
- caregiver setup

### Phase 3
- senior home
- daily check-in
- caregiver summary

### Phase 4
- medication list
- next medication card
- taken / snooze flow

### Phase 5
- help request
- missed check-in alerts
- caregiver alert list

### Phase 6
- polish
- QA
- beta prep

---

## 15) Architecture Rules
- keep V1 small
- platform UI stays platform-specific
- shared business logic stays in shared
- prefer readable code over overengineering
- do not expand into full health records in V1
- do not mix marketplace logic with Tamnni logic

---

## 16) Final Architecture Statement
Tamnni Care should use a **feature-oriented KMP architecture** with:
- shared domain and data logic
- platform-owned UI
- explicit design tokens
- a reassurance-first MVP scope
