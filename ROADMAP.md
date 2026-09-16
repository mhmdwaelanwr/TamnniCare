# Tamnni Care Roadmap

This roadmap follows a staged approach: first keep the project clean, buildable, documented, and safely published; then return for deeper product work in focused passes.

## Phase 0 — Repository Baseline ✅

The project is already in a usable public-repository state:

- Kotlin Multiplatform project uploaded and cleaned
- Android and iOS targets present
- generated/local/signing files excluded
- public visual-reference material filtered
- repository-health secret-pattern checks enabled
- Android compilation and unit-test CI enabled
- project branding and design-system assets preserved
- README, license, PRD and architecture docs present
- architecture/folder docs aligned with the actual `composeApp` structure

This phase is intentionally about making the project easy to return to later, not pretending the MVP is production-ready.

## Phase 1 — Finish Existing MVP Flows

Focus on making the screens that already exist behave like a complete local prototype before adding large new systems.

- finish the senior help-request flow
- connect caregiver details/quick actions to real UI behavior
- turn medication preview into editable medication state
- complete alert/history state flows
- remove remaining placeholder/sample-only behavior where practical
- keep Arabic and English copy aligned
- add tests for each completed state transition

## Phase 2 — Product Data and Family Connection

Introduce real application data boundaries only when the product behavior is ready for them.

- account/session model
- senior ↔ caregiver/family linking
- medication repository
- reassurance history repository
- alert repository
- production local persistence
- backend/API contract
- sync/error/offline behavior

At this point, evaluate whether Ktor, Kotlinx Serialization, SQLDelight/Room, Koin or another stack is justified. Do not add architecture dependencies only for appearance.

## Phase 3 — Notifications and Safety-Critical Flows

- medication reminder scheduling
- missed-check-in evaluation and delivery
- caregiver notifications
- help-request delivery path
- retry/failure handling
- notification permissions on Android/iOS
- clear non-emergency wording and escalation boundaries

A help button must not be represented as a live emergency service before these delivery and failure paths are implemented and tested.

## Phase 4 — Quality and Platform Validation

- accessibility review for elderly users
- larger touch-target verification
- RTL/LTR review
- dark/light theme review
- Android UI/instrumentation tests
- iOS build validation on macOS/Xcode
- lifecycle/background-state testing
- performance/startup review
- dependency/security review

## Phase 5 — Product Polish

- final screenshots
- short demo/GIF/video
- onboarding illustrations
- refined empty/error/loading states
- app-store icon/export review
- README gallery
- GitHub About/Topics cleanup

## Phase 6 — Release Readiness

- privacy policy and data-flow review
- production backend/environment configuration
- release signing kept outside the repository
- crash reporting/telemetry decision
- Android release pipeline
- iOS release pipeline
- versioning/changelog strategy
- closed beta/internal testing before public release

## Current Rule

Keep `main` as the clean baseline. Future development should happen in focused branches/PRs so the repository remains easy to understand even when deeper development pauses for a while.
