# Tamnni Care MVP UI/UX System

## Product north star

Tamnni Care should feel like **a calm family reassurance companion for elderly care**, not a hospital tool, not a medication-only product, and not a caregiver marketplace.  
The core UX question is: **"Is everything okay right now?"**

---

## 1) Unified design system

### 1.1 Brand experience principles

#### Emotional qualities
- Calm
- Warm
- Trustworthy
- Human
- Respectful
- Premium but simple

#### Product behavior principles
- **Reassurance before detail**
- **One primary action per screen**
- **Short, warm copy**
- **Clear status over dense data**
- **Large touch targets**
- **Separate logic for seniors and caregivers**

### 1.2 Visual language

#### Surfaces
- Main background: **Warm White / `#F9FBFD`**
- Primary cards: **White / `#FFFFFF`**
- Soft reassurance surfaces: **Teal Mist / `#DDF4F2`**
- Minimal borders and soft shadows only

#### Shape language
- Soft corners throughout
- No sharp clinical edges
- Generous card radius
- Large rounded CTAs
- Chips use pill radius

#### Icon style
- Rounded outline icons
- Friendly, not technical
- Pair icon + label for important actions
- Never rely on color alone for meaning

### 1.3 Core components
- Top app bar
- Hero reassurance card
- Summary cards
- Medication cards
- Alert cards
- Status chips
- Primary / secondary / text buttons
- Bottom navigation
- Selection cards
- Input fields
- Permission / confirmation panels
- Empty-state cards
- Bottom sheet for quick actions

---

## 2) Color usage per screen type

### 2.1 Core palette
- **Navy** `#0F2144`
- **Soft Teal** `#6FD1C6`
- **Teal Mist** `#DDF4F2`
- **Warm White** `#F9FBFD`
- **Text Dark** `#1A2333`
- **Text Muted** `#667085`

### 2.2 Semantic palette
- **Success** `#39A96B`
- **Warning** `#F4B740`
- **Error** `#D95C5C`
- **Info** `#3B82F6`
- **Outline** `#D0D7E2`

### 2.3 Screen-type color rules

| Screen type | Background | Main surfaces | Accent usage | Notes |
|---|---|---|---|---|
| Splash / Onboarding | Warm White | Light illustration zones | Soft Teal + Navy | Emotional, welcoming |
| Language / Role / Auth | Warm White | White cards | Navy emphasis | Clean and low-friction |
| Senior Home | Warm White | White + Teal Mist hero | Navy CTA, Teal reassurance | Calm, action-first |
| Caregiver Home | Warm White | White summary cards | Semantic chips, restrained Navy | Informative but quiet |
| Medication | Warm White | White / Teal Mist cards | Secondary for next dose | Supportive, not medical-heavy |
| Alerts | Warm White | White cards | Warning / Error / Success | Urgency without panic |
| Help Request | Warm White | White + error-accent action | Error used carefully | Serious, still reassuring |
| Profile / Settings | Warm White | White grouped sections | Navy icons, muted dividers | Quiet and practical |

### 2.4 Meaning rules
- **Navy** = trust, structure, primary action
- **Soft Teal** = support, calm, guidance
- **Teal Mist** = soft emphasis, reassurance surfaces
- **Success** = resolved, taken, confirmed
- **Warning** = missed or delayed
- **Error** = urgent help only
- **Info** = neutral system guidance

### 2.5 Status mapping
- **تم الاطمئنان اليوم** → success
- **لم يتم تسجيل الاطمئنان بعد** → info / muted
- **متأخر** → warning
- **يحتاج متابعة** → warning
- **تم طلب مساعدة** → error

---

## 3) Typography usage rules

Typography should feel warm, readable, calm, modern, and accessible.

### 3.1 Type scale

| Role | Token | Use |
|---|---|---|
| Display LG | 36 / 44 | Splash, welcome emphasis |
| Display MD | 32 / 40 | Onboarding hero text |
| Heading XL | 28 / 36 | Major home hero title |
| Heading LG | 24 / 32 | Main screen titles |
| Heading MD | 20 / 28 | Section titles |
| Heading SM | 18 / 26 | Card titles |
| Body LG | 18 / 28 | Senior reading default |
| Body MD | 16 / 24 | Standard body text |
| Body SM | 14 / 22 | Secondary helper text |
| Label LG | 16 / 20 | Primary buttons |
| Label MD | 14 / 18 | Chips and secondary buttons |
| Label SM | 12 / 16 | Metadata only |

### 3.2 Usage rules by mode

#### Senior Mode
- Prefer **Body LG** and above
- Critical actions use **Label LG** or **Body LG**
- Avoid tiny helper text
- Keep lines short
- Avoid more than 2 levels of hierarchy inside the same card

#### Caregiver Mode
- Can use **Body MD**
- May support denser summaries
- Timestamps can use **Label SM**
- Important statuses must still be large and scannable

### 3.3 Tone rules
Use calm Arabic-first language:
- أنا بخير
- تم الاطمئنان اليوم
- آخر تحديث
- الدواء القادم
- طلب مساعدة

Avoid:
- medical jargon on main screens
- long explanatory paragraphs
- cold system wording

---

## 4) Spacing and card rules

### 4.1 Spacing scale
- 4
- 8
- 12
- 16
- 20
- 24
- 32
- 40
- 48

### 4.2 Screen layout rules
- Senior screen side padding: **24**
- Caregiver screen side padding: **20**
- Auth/setup padding: **24**
- Section gap: **16–24**
- Card internal padding: **16–20**

### 4.3 Card rules

#### Standard card
- Background: white
- Radius: 20
- Padding: 16–20
- Elevation: soft `elevation-1` or `elevation-2`

#### Hero card
- Radius: 24
- Padding: 20–24
- Background: Teal Mist or soft reassurance surface
- Holds the screen’s most important status/action

#### Alert card
- White card
- Semantic badge/chip
- Compact status icon
- Time visible
- One clear action

#### Medication card
- White or Teal Mist
- Name prominent
- Next time large
- Status chip visible
- Action row simple

### 4.4 Density rules
- Senior screens: fewer cards, larger gaps, larger touch areas
- Caregiver screens: more cards allowed, but still stacked cleanly

---

## 5) Button styles

### 5.1 Primary button
**Use for:**
- أنا بخير
- تسجيل الدخول
- متابعة
- تأكيد

**Style**
- Background: Navy
- Text: White
- Height: 52 standard / 56–64 senior CTA
- Radius: 16–20
- Full-width on key senior screens

### 5.2 Secondary button
**Use for:**
- عرض التفاصيل
- لاحقًا
- تعديل

**Style**
- Background: White or Teal Mist
- Text: Navy
- Optional outline
- Height: 48
- Radius: 16

### 5.3 Tertiary / text button
**Use for:**
- تخطي
- ليس الآن
- الرجوع

### 5.4 Destructive / urgent button
**Use for:**
- طلب مساعدة
- إرسال تنبيه عاجل

### 5.5 Selection cards as buttons
Role selection and language selection should use **large rounded selection cards**.

---

## 6) Senior mode design rules
- Fewer actions
- Bigger buttons
- Larger text
- Reassurance-first
- Low clutter
- Minimal decision load

### Senior Home priority
1. Current reassurance state
2. One-tap “أنا بخير”
3. Next medication
4. Help request
5. Optional supportive note / last update

---

## 7) Caregiver mode design rules
- More summary information
- Timestamps
- Status cards
- Alert handling
- Quick follow-up actions

### Caregiver Home priority
1. Today’s reassurance status
2. Active alerts
3. Next medication
4. Last update / last check-in
5. Quick contact

---

## 8) Full MVP screen list

### Entry / setup
1. Splash
2. Onboarding 1
3. Onboarding 2
4. Onboarding 3
5. Language Selection
6. Role Selection
7. Sign In
8. Sign Up
9. Basic Profile Setup
10. Notification Permission

### Senior Mode
11. Senior Home
12. Medication List
13. Medication Details
14. Help Request
15. Help Request Confirmation
16. Senior Profile / Settings

### Caregiver Mode
17. Caregiver Home
18. Alerts List
19. Alert Details
20. Caregiver Profile / Settings

### System / support states
21. Empty Alerts
22. No Medications
23. Check-in Success
24. Notifications Disabled
25. Link Family / Senior Placeholder

---

## 9) Wireframe-level structure for each screen

### Splash
- Centered logo
- App name
- Short supportive line
- Very soft background accent
- Auto transition

### Onboarding
Each screen:
- Large soft illustration area
- Short title
- One-line explanation
- Bottom progress dots
- Primary CTA
- Secondary skip

### Role Selection
- Title
- Short explanation
- Senior card
- Caregiver / Family card
- Continue button

### Senior Home
- Greeting
- Reassurance hero card
- Next medication card
- Help request card/button
- Small settings/profile entry

### Caregiver Home
- Greeting with linked senior name
- Reassurance summary hero
- Active alerts preview
- Next medication card
- Last update card
- Quick actions row

---

## 10) High-fidelity visual direction

### Splash
Quiet, premium, safe.

### Onboarding
Warm and guided.

### Role Selection
Confident but gentle.

### Sign In / Sign Up
Frictionless, trustworthy.

### Senior Home
Instantly reassuring.

### Caregiver Home
Organized calm.

### Medication List
Supportive clarity.

### Medication Details
Readable and gentle.

### Alerts
Actionable, not panic-inducing.

### Help Request Flow
Serious, humane.

### Notification Permission
Polite and useful.

### Profile / Settings
Quiet and familiar.

---

## Coherence rules for the whole MVP

### Navigation
#### Senior
- Home
- Medications
- Settings

#### Caregiver
- Home
- Alerts
- Profile

### Motion
- Soft fade/slide transitions
- Immediate button feedback
- Calm confirmation states
- No flashy motion

### Empty states
- لا يوجد تنبيهات حاليًا
- تم الاطمئنان اليوم
- لا توجد أدوية مجدولة الآن

### Accessibility
- Never use color as the only indicator
- Always pair color with icon + label
- Minimum tap target 48x48, senior priority 56+

---

## Final design statement

**Tamnni Care should feel softer than a health platform, clearer than a family chat tool, and simpler than a caregiver operations product.**

It should consistently protect:
- **one-tap daily reassurance**
- **dual-mode clarity**
- **warm Arabic-first tone**
- **low-clutter elderly-friendly interaction**
- **gentle caregiver summary**