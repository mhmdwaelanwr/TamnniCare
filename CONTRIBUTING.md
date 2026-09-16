# Contributing to Tamnni Care

Tamnni Care is being developed in stages. Keep `main` as the clean, buildable baseline and make deeper changes through focused branches and pull requests.

## Before Starting

Read:

- `README.md`
- `ROADMAP.md`
- `docs/PRD.md`
- `docs/ARCHITECTURE.md`

Avoid implementing planned infrastructure just because it appears in the roadmap. Prefer the smallest change that completes a real product need.

## Local Checks

Android build:

```bash
./gradlew :composeApp:assembleDebug
```

Shared/Android tests:

```bash
./gradlew :composeApp:testDebugUnitTest
```

For iOS, validate the native host on macOS/Xcode.

## Repository Hygiene

Do not commit:

- `.gradle/`, `.kotlin/`, IDE caches or build output
- `local.properties`
- `.env` files
- API keys/tokens
- signing files/certificates
- service configuration containing secrets
- real senior/caregiver/medical/personal data
- third-party visual references without clear redistribution rights

## Change Scope

Prefer one focused concern per PR. Update tests and documentation when behavior or architecture changes.

For unfinished product behavior, describe it as planned/prototype behavior instead of presenting it as production-ready.
