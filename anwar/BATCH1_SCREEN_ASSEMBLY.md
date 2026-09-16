# Batch 1 Screen Assembly Table

Direct Figma construction for:
1. Splash
2. Onboarding
3. Role Selection
4. Senior Home
5. Caregiver Home

---

## 1) Splash

### Screen summary
- **Outer padding:** 24 horizontal, safe-area aware
- **Visually dominant:** Brand lockup
- **Key differentiators visible:** Warm Arabic-first tone, calm family reassurance identity

### Assembly table

| Order | Layout block | Exact component instance | Exact variant selection | Default state | Spacing below |
|---|---|---|---|---|---:|
| 1 | Background base | Local frame layer | Fill=`background` | Default | 0 |
| 2 | Soft ambient shape | Local decoration layer | Soft teal blob, low opacity | Default | 32 |
| 3 | Brand block | `BrandLockup_01` | `Brand / Lockup / Tamnni` → `Language=ArabicEnglish, Size=Large` | Default | 16 |
| 4 | Optional loading cue | Local dots layer or omit | 3 muted dots | Default | 0 |

**What must stay visually dominant:** The Arabic Tamnni brand lockup.

---

## 2) Onboarding

### Screen summary
- **Outer padding:** 24 horizontal, 24 bottom
- **Visually dominant:** Illustration area + short reassurance-first headline
- **Key differentiators visible:** Reassurance-first story, medication as supportive not primary, family alerts as calm backup

### Assembly table

| Order | Layout block | Exact component instance | Exact variant selection | Default state | Spacing below |
|---|---|---|---|---|---:|
| 1 | Top action area | Local text layer `Skip_01` | Text only, `label-md` | Default | 20 |
| 2 | Illustration block | Local illustration frame `OnboardingArt_01` | Slide illustration placeholder | Default | 24 |
| 3 | Title block | Local text layer `OnboardingTitle_01` | `heading-lg` | Slide 1 default | 8 |
| 4 | Body block | Local text layer `OnboardingBody_01` | `body-md` | Slide 1 default | 24 |
| 5 | Progress | `OnboardingDots_01` | `Progress / Onboarding Dots` → `Step=1of3` | `Active1` | 24 |
| 6 | Primary CTA | `PrimaryCTA_01` | `Button / Primary / Large` → `Type=Standard, Width=Fill` | Default | 12 |
| 7 | Secondary action | Local text layer `SkipBottom_01` or omit | `label-md` | Default | 0 |

**Default content state:** Slide 1  
Title: `اطمئن أهلك بضغطة واحدة`  
Body: `سجّل أنك بخير بسهولة ليصلهم الاطمئنان في لحظته.`

**What must stay visually dominant:** The short headline and emotional promise.

---

## 3) Role Selection

### Screen summary
- **Outer padding:** 24 horizontal, 24 bottom
- **Visually dominant:** Two large role cards
- **Key differentiators visible:** Senior Mode vs Caregiver Mode split, elderly-friendly large tap targets

### Assembly table

| Order | Layout block | Exact component instance | Exact variant selection | Default state | Spacing below |
|---|---|---|---|---|---:|
| 1 | Top bar | `TopBar_01` | `TopBar / Batch1 / Standard` → `Type=BackTitle, Surface=Transparent` | Default | 24 |
| 2 | Screen title | Local text layer `RoleTitle_01` | `heading-lg` | Default | 8 |
| 3 | Screen subtitle | Local text layer `RoleSubtitle_01` | `body-md` | Default | 24 |
| 4 | Senior role card | `RoleCardSenior_01` | `Selection Card / Role` → `Role=Senior` | Default | 16 |
| 5 | Caregiver role card | `RoleCardCaregiver_01` | `Selection Card / Role` → `Role=Caregiver` | Default | 24 |
| 6 | Continue CTA | `PrimaryCTA_01` | `Button / Primary / Large` → `Type=Standard, Width=Fill` | Disabled | 0 |

**Default text**
- Title: `اختر طريقة الاستخدام`
- Subtitle: `سنضبط التجربة بما يناسبك من البداية.`

**What must stay visually dominant:** The two role cards.

---

## 4) Senior Home

### Screen summary
- **Outer padding:** 24 horizontal, safe top, safe bottom
- **Visually dominant:** Hero reassurance card + “أنا بخير” CTA
- **Key differentiators visible:** One-tap daily reassurance, reassurance ladder, Senior Mode simplicity

### Assembly table

| Order | Layout block | Exact component instance | Exact variant selection | Default state | Spacing below |
|---|---|---|---|---|---:|
| 1 | Top bar | `TopBar_01` | `TopBar / Batch1 / Standard` → `Type=GreetingProfile, Surface=Transparent` | Default | 16 |
| 2 | Hero reassurance card | `ReassuranceHero_01` | `Card / Hero / Reassurance` → `State=NotCheckedIn, CTA=Visible` | Default | 16 |
| 3 | Medication preview | `MedicationCard_01` | `Card / Medication / Preview` → `State=Upcoming, Action=Details` | Default | 16 |
| 4 | Help section title/prompt | Local text layer `HelpPrompt_01` | `body-md` | Default | 12 |
| 5 | Help button | `HelpCTA_01` | `Button / Help / Urgent` → `Style=SoftUrgent, Width=Fill` | Default | 24 |
| 6 | Bottom navigation | `BottomNav_01` | `BottomNav / Batch1 / 3 Tabs` → `Mode=Senior, Active=Home` | `ActiveHome` | 0 |

**Default content**
- Greeting: `صباح الخير يا أستاذ أحمد`
- Hero label: `حالة اليوم`
- Status: `لم يتم تسجيل الاطمئنان بعد`
- Meta: `آخر تحديث: أمس ٨:٤٠ م`
- CTA: `أنا بخير`
- Medication label: `الدواء القادم`
- Medication title: `دواء الضغط`
- Medication meta: `اليوم ١٢:٣٠ م`
- Medication action: `عرض التفاصيل`
- Help prompt: `إذا كنت تحتاج مساعدة، يمكنك إرسال تنبيه الآن.`

**Alternate hero states**
- `State=CheckedInToday, CTA=Soft`
- `State=Delayed, CTA=Visible`
- `State=NeedsFollowUp, CTA=Visible`

**What must stay visually dominant:** The hero reassurance card and the “أنا بخير” button.

---

## 5) Caregiver Home

### Screen summary
- **Outer padding:** 20–24 horizontal, safe top, safe bottom
- **Visually dominant:** Caregiver summary card
- **Key differentiators visible:** Gentle caregiver summary, reassurance-first status, calm alert awareness

### Assembly table

| Order | Layout block | Exact component instance | Exact variant selection | Default state | Spacing below |
|---|---|---|---|---|---:|
| 1 | Top bar | `TopBar_01` | `TopBar / Batch1 / Standard` → `Type=GreetingProfile, Surface=Transparent` | Default | 16 |
| 2 | Caregiver summary hero | `CaregiverSummary_01` | `Card / Hero / Caregiver Summary` → `State=Okay, CTA=Details` | Default | 16 |
| 3 | Alert preview | `AlertCard_01` | `Card / Alert / Preview` → `Count=1, Action=ViewAll` | Default | 16 |
| 4 | Medication preview | `MedicationCard_01` | `Card / Medication / Preview` → `State=Upcoming, Action=Details` | Default | 16 |
| 5 | Quick actions row | `QuickCall_01` + `QuickMessage_01` | `Action / Quick / Icon+Label` → `Layout=Pill, Type=Call` and `Layout=Pill, Type=Message` | Default | 24 |
| 6 | Bottom navigation | `BottomNav_01` | `BottomNav / Batch1 / 3 Tabs` → `Mode=Caregiver, Active=Home` | `ActiveHome` | 0 |

**Default content**
- Greeting: `مرحبًا يا سارة`
- Linked context: `متابعة: أستاذ أحمد`
- Summary label: `حالة اليوم`
- Main line: `تم الاطمئنان اليوم`
- Meta: `آخر تحديث: اليوم ٩:١٥ ص`
- Interpretation: `كل شيء يبدو مطمئنًا حتى الآن.`
- CTA: `عرض التفاصيل`
- Alert title: `التنبيهات`
- Alert row: `تأخر الاطمئنان`
- Medication title: `الدواء القادم`
- Quick actions: `اتصال` / `رسالة`

**Alternate summary states**
- `State=Pending, CTA=Contact`
- `State=Delayed, CTA=Contact`
- `State=HelpRequested, CTA=ActNow`

**What must stay visually dominant:** The Caregiver Summary card.

---

## Quick build order in Figma
1. Build outer frame with background and safe areas
2. Place top bar
3. Place dominant hero card
4. Add secondary card(s)
5. Add isolated help or quick actions
6. Add bottom navigation
7. Fill local text content
8. Swap state variants as needed

## Final screen hierarchy check
- Splash: brand is the only focal point
- Onboarding: reassurance story comes before medication
- Role Selection: role cards dominate, CTA waits until selection
- Senior Home: `أنا بخير` is stronger than everything else
- Caregiver Home: summary is stronger than alerts, alerts stronger than meds
- Help CTA: isolated, serious, never competing with routine reassurance