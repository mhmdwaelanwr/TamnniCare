# Tamnni Care — Color Roles

## Core Palette
- Navy: `#0F2144`
- Soft Teal: `#6FD1C6`
- Teal Mist: `#DDF4F2`
- Warm White: `#F9FBFD`
- Text Dark: `#1A2333`
- Text Muted: `#667085`

---

## Material / UI Role Mapping

### Primary
- `primary`: `#0F2144`
- `onPrimary`: `#FFFFFF`
- `primaryContainer`: `#E8EEFA`
- `onPrimaryContainer`: `#0F2144`

### Secondary
- `secondary`: `#6FD1C6`
- `onSecondary`: `#0F2144`
- `secondaryContainer`: `#DDF4F2`
- `onSecondaryContainer`: `#0F2144`

### Background / Surface
- `background`: `#F9FBFD`
- `onBackground`: `#1A2333`
- `surface`: `#FFFFFF`
- `onSurface`: `#1A2333`
- `surfaceVariant`: `#F3F6FA`
- `onSurfaceVariant`: `#667085`

### Semantic
- `success`: `#39A96B`
- `warning`: `#F4B740`
- `error`: `#D95C5C`
- `info`: `#3B82F6`

### Borders / Dividers
- `outline`: `#D0D7E2`
- `divider`: `#E7ECF3`

---

## Usage Rules

### Senior Home
- CTA button uses `primary`
- medication card accent can use `secondary`
- danger/help action uses `error` very carefully
- keep background light

### Caregiver Home
- summary cards on `surface`
- status chips can use:
  - success
  - warning
  - error
  - info
- keep typography dark and highly readable

### Alerts
- missed check-in: warning
- help request: error
- resolved state: success

### Medication
- next dose accents: secondary
- taken state: success
- snoozed state: warning
- missed state: error

---

## Accessibility Note
Do not use color as the only signal.
Always combine color with:
- icon
- label
- status text
