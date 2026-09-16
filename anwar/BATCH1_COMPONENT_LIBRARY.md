# Batch 1 Component Library

## Figma setup rules
- Use **Auto Layout** for every major component.
- Build text and color values as reusable styles.
- Build components in **RTL-first logic** for Arabic.
- Use soft elevation only, rounded surfaces, and avoid dense widget patterns.
- Senior-facing components should default to larger sizes and lower information density.

## Core tokens to reference
- Background: `#F9FBFD`
- Surface: `#FFFFFF`
- Primary / Navy: `#0F2144`
- Secondary / Soft Teal: `#6FD1C6`
- Secondary Container / Teal Mist: `#DDF4F2`
- Text Dark: `#1A2333`
- Text Muted: `#667085`
- Success: `#39A96B`
- Warning: `#F4B740`
- Error: `#D95C5C`
- Outline: `#D0D7E2`

## Text style mapping
- Display: `36/44` and `32/40`
- Headings: `28/36`, `24/32`, `20/28`, `18/26`
- Body: `18/28`, `16/24`, `14/22`
- Labels: `16/20`, `14/18`, `12/16`

---

## 1) Top bar
**Component name:** `TopBar / Batch1 / Standard`

**Purpose:** Provides orientation, light navigation, greeting context, and access to profile/settings.

**Anatomy**
- Container
- Safe top inset
- Content row
  - leading area
  - center area
  - trailing area
- Optional subtitle row

**Variants**
- `Greeting + Profile`
- `Back + Title`
- `Back + Title + Text Action`
- `Title Only`
- `Transparent`
- `Surface`

**Where used**
- Role Selection
- Senior Home
- Caregiver Home

---

## 2) Bottom nav
**Component name:** `BottomNav / Batch1 / 3 Tabs`

**Purpose:** Provides stable primary navigation for home-level screens only.

**Senior nav**
- Home
- Medications
- Settings

**Caregiver nav**
- Home
- Alerts
- Profile

**Variants**
- `Senior / Home Active`
- `Senior / Medications Active`
- `Senior / Settings Active`
- `Caregiver / Home Active`
- `Caregiver / Alerts Active`
- `Caregiver / Profile Active`

**Where used**
- Senior Home
- Caregiver Home

---

## 3) Primary button
**Component name:** `Button / Primary / Large`

**Purpose:** Main action button for the most important task on a screen.

**Variants**
- `Default`
- `Pressed`
- `Disabled`
- `With Leading Icon`
- `Full Width`
- `Senior Large`

**Where used**
- Onboarding
- Role Selection
- Senior Home
- Caregiver Home contextual CTA

---

## 4) Secondary button
**Component name:** `Button / Secondary / Large`

**Purpose:** Supports the main action with lower visual weight.

**Variants**
- `Outline`
- `Soft Fill`
- `Pressed`
- `Disabled`
- `With Icon`

**Where used**
- Onboarding
- Senior Home medication preview
- Caregiver Home cards

---

## 5) Destructive / Help button
**Component name:** `Button / Help / Urgent`

**Purpose:** Used for serious escalation like sending a help request.

**Variants**
- `Soft Urgent`
- `Filled Urgent`
- `Pressed`
- `Disabled`
- `With Icon`

**Where used**
- Senior Home help block
- Later Help Request flow

---

## 6) Hero reassurance card
**Component name:** `Card / Hero / Reassurance`

**Purpose:** The core identity component of Tamnni. Makes daily reassurance visible and action-ready.

**Anatomy**
- Card container
- Status label / eyebrow
- Main reassurance headline
- Meta line for last update
- Primary CTA area
- Optional supportive icon or status chip

**Variants**
- `Not Checked In`
- `Checked In Today`
- `Delayed`
- `Needs Follow-up`
- `Compact`
- `With Chip`
- `Without Icon`

**Where used**
- Senior Home

---

## 7) Caregiver summary card
**Component name:** `Card / Hero / Caregiver Summary`

**Purpose:** Summarizes current reassurance status for the caregiver in a calm, scannable way.

**Variants**
- `Okay`
- `Pending`
- `Delayed`
- `Help Requested`
- `With CTA`
- `Without CTA`

**Where used**
- Caregiver Home

---

## 8) Medication preview card
**Component name:** `Card / Medication / Preview`

**Purpose:** Provides a light, supportive summary of the next medication event.

**Variants**
- `Upcoming`
- `Taken`
- `Snoozed`
- `Missed`
- `With Action`
- `Compact`

**Where used**
- Senior Home
- Caregiver Home

---

## 9) Alert preview card
**Component name:** `Card / Alert / Preview`

**Purpose:** Surfaces a small set of active or recent alerts in a calm, actionable format.

**Variants**
- `No Alerts`
- `One Alert`
- `Two Alerts`
- `Mixed States`
- `View All`
- `Resolved Only`

**Where used**
- Caregiver Home

---

## 10) Status chips
**Component name:** `Chip / Status / Semantic`

**Purpose:** Communicates reassurance and medication states in a compact, consistent way.

**Variants**
- `Success`
- `Warning`
- `Error`
- `Info`
- `Icon + Label`
- `Label Only`

**Where used**
- Hero reassurance card
- Caregiver summary card
- Medication preview card
- Alert preview rows

---

## 11) Role selection card
**Component name:** `Selection Card / Role`

**Purpose:** Allows the user to choose Senior or Caregiver mode through a large, clear card.

**Variants**
- `Default`
- `Selected`
- `Pressed`
- `Disabled`

**Where used**
- Role Selection screen

---

## 12) Onboarding dots
**Component name:** `Progress / Onboarding Dots`

**Purpose:** Shows progress across onboarding slides.

**Variants**
- `Step 1 Active`
- `Step 2 Active`
- `Step 3 Active`

**Where used**
- Onboarding

---

## 13) Profile shortcut / quick action button
**Component name:** `Action / Quick / Icon+Label`

**Purpose:** Provides compact access to profile, call, message, or lightweight utilities.

**Subtypes**
- `Icon Circle + Label Below`
- `Compact Pill Button`

**Variants**
- `Profile`
- `Call`
- `Message`
- `Settings`
- `Pressed`
- `Disabled`

**Where used**
- Senior Home profile shortcut
- Caregiver Home quick actions

---

## 14) Brand lockup
**Component name:** `Brand / Lockup / Tamnni`

**Purpose:** Displays the brand consistently on Splash and onboarding entry moments.

**Variants**
- `Arabic Only`
- `Arabic + English`
- `Large`
- `Compact`

**Where used**
- Splash
- Optional Onboarding top area

---

## 15) Onboarding illustration frame
**Component name:** `Illustration Frame / Onboarding`

**Purpose:** Creates a consistent illustration container for all onboarding slides.

**Variants**
- `Slide 1`
- `Slide 2`
- `Slide 3`
- `With Soft Blob A/B`

**Where used**
- Onboarding

---

## 16) Greeting block
**Component name:** `Header / Greeting Block`

**Purpose:** Displays a warm greeting and optional linked-person context.

**Variants**
- `Single Line`
- `Two Line`
- `With Linked Person`

**Where used**
- Senior Home top bar
- Caregiver Home top bar

---

## Component-to-screen usage map

### Splash
- `Brand / Lockup / Tamnni`
- optional `Progress / Minimal Loading`
- optional `Background / Ambient Soft Shape`

### Onboarding
- `TopBar / Batch1 / Standard`
- `Illustration Frame / Onboarding`
- `Progress / Onboarding Dots`
- `Button / Primary / Large`
- `Button / Secondary / Large`
- `Brand / Lockup / Tamnni` optional compact

### Role Selection
- `TopBar / Batch1 / Standard`
- `Selection Card / Role`
- `Button / Primary / Large`

### Senior Home
- `TopBar / Batch1 / Standard`
- `Header / Greeting Block`
- `Card / Hero / Reassurance`
- `Button / Primary / Large`
- `Card / Medication / Preview`
- `Button / Secondary / Large`
- `Button / Help / Urgent`
- `Action / Quick / Icon+Label`
- `BottomNav / Batch1 / 3 Tabs`
- `Chip / Status / Semantic`

### Caregiver Home
- `TopBar / Batch1 / Standard`
- `Header / Greeting Block`
- `Card / Hero / Caregiver Summary`
- `Card / Alert / Preview`
- `Card / Medication / Preview`
- `Action / Quick / Icon+Label`
- `BottomNav / Batch1 / 3 Tabs`
- `Chip / Status / Semantic`
- `Button / Secondary / Large`

---

## Recommended Figma variants to build first
1. `Button / Primary / Large`
2. `Button / Secondary / Large`
3. `Button / Help / Urgent`
4. `Chip / Status / Semantic`
5. `Selection Card / Role`
6. `Card / Hero / Reassurance`
7. `Card / Hero / Caregiver Summary`
8. `Card / Medication / Preview`
9. `Card / Alert / Preview`
10. `BottomNav / Batch1 / 3 Tabs`

---

## Quality rules for the library
- The **Hero Reassurance Card** feels like the emotional center of Senior Home.
- The **Caregiver Summary Card** answers status quickly without turning into a dashboard.
- Medication components stay clearly **secondary** to reassurance.
- Error styling stays **serious but calm**, never panic-heavy.
- Arabic labels remain short, warm, and readable.
- Interactive elements meet tap target guidance, especially in senior contexts.