# Security Policy

Tamnni Care is currently an MVP prototype and should not be used to store or transmit real medical, emergency, or sensitive family-care data in production.

## Reporting a Security Issue

Please avoid opening a public issue for vulnerabilities that could expose secrets, personal information, or user data. Report the problem privately to the repository owner with enough detail to reproduce it safely.

## Repository Rules

- Never commit API keys, tokens, passwords, signing keys, certificates, service-account files, or local environment files.
- Never commit real patient, senior, caregiver, medication, phone, address, or other personally identifying data.
- Keep Android/iOS signing material outside the repository.
- Treat sample/demo identities and data as fictional only.
- Review third-party SDKs before adding them, especially analytics, health, location, notification, or identity providers.

GitHub Actions performs lightweight repository-health checks for common committed-secret patterns and generated/private files, but automated scanning is not a substitute for review.

## Production Boundary

Before any real-user deployment, the project will require a dedicated review of authentication, authorization, data storage, transport security, privacy, notification delivery, failure handling, logging, retention, and applicable legal/regulatory requirements.
