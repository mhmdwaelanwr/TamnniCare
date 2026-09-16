# Batch 1 Figma-ready Component Table

## Naming pattern
Use this pattern for Figma variant properties and later code mapping:

`Component / VariantName`

Recommended property keys:
- `Type`
- `Mode`
- `State`
- `Density`
- `Width`
- `Icon`
- `Surface`
- `Active`

Example:
`TopBar / Type=GreetingProfile, Surface=Transparent, Density=Senior`

---

## TopBar / Batch1 / Standard

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Type=GreetingProfile, Surface=Transparent` | Default | H72 | Senior | Senior Home, Caregiver Home |
| `Type=BackTitle, Surface=Transparent` | Default | H64 | Standard | Role Selection |
| `Type=BackTitleAction, Surface=Transparent` | Default | H64 | Standard | Future setup screens |
| `Type=TitleOnly, Surface=Surface` | Default | H56 | Compact | Sheets or simple internal screens |

---

## BottomNav / Batch1 / 3 Tabs

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Mode=Senior, Active=Home` | ActiveHome | H80 | Senior | Senior Home |
| `Mode=Senior, Active=Medications` | ActiveMedications | H80 | Senior | Future Senior meds root |
| `Mode=Senior, Active=Settings` | ActiveSettings | H80 | Senior | Future Senior settings root |
| `Mode=Caregiver, Active=Home` | ActiveHome | H80 | Standard | Caregiver Home |
| `Mode=Caregiver, Active=Alerts` | ActiveAlerts | H80 | Standard | Future Alerts root |
| `Mode=Caregiver, Active=Profile` | ActiveProfile | H80 | Standard | Future Profile root |

---

## Button / Primary / Large

| Variant | State | Size | Density | Width | When to use |
|---|---|---:|---|---|---|
| `Type=Standard, Width=Content` | Default | H52 | Standard | Hug | Main CTA on standard screens |
| `Type=Standard, Width=Fill` | Default | H52 | Standard | Fill | Onboarding CTA, Role Selection CTA |
| `Type=SeniorCTA, Width=Fill` | Default | H60 | Senior | Fill | `أنا بخير` on Senior Home |
| `Type=WithIcon, Width=Fill` | Default | H52 | Standard | Fill | When icon adds clarity |
| `Type=Standard, Width=Fill` | Pressed | H52 | Standard | Fill | Press interaction |
| `Type=Standard, Width=Fill` | Disabled | H52 | Standard | Fill | Disabled before selection/form complete |

---

## Button / Secondary / Large

| Variant | State | Size | Density | Width | When to use |
|---|---|---:|---|---|---|
| `Style=Outline, Width=Content` | Default | H48 | Standard | Hug | Secondary action on cards |
| `Style=Outline, Width=Fill` | Default | H48 | Standard | Fill | Full-width secondary flows |
| `Style=Soft, Width=Content` | Default | H48 | Standard | Hug | Supportive actions like `عرض التفاصيل` |
| `Style=WithIcon, Width=Content` | Default | H48 | Standard | Hug | Detail, view, info actions |
| `Style=Outline, Width=Fill` | Pressed | H48 | Standard | Fill | Press interaction |
| `Style=Outline, Width=Fill` | Disabled | H48 | Standard | Fill | Temporarily unavailable actions |

---

## Button / Help / Urgent

| Variant | State | Size | Density | Width | When to use |
|---|---|---:|---|---|---|
| `Style=SoftUrgent, Width=Fill` | Default | H56 | Senior | Fill | Senior Home help section |
| `Style=FilledUrgent, Width=Fill` | Default | H56 | Standard | Fill | Dedicated help-request screen |
| `Style=SoftUrgent, Width=Fill` | Pressed | H56 | Senior | Fill | Press interaction |
| `Style=WithIcon, Width=Fill` | Default | H56 | Standard | Fill | Help flows where icon clarifies |

---

## Card / Hero / Reassurance

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `State=NotCheckedIn, CTA=Visible` | Default | H220 | Senior | Senior Home default |
| `State=CheckedInToday, CTA=Soft` | Default | H220 | Senior | Senior Home after reassurance |
| `State=Delayed, CTA=Visible` | Default | H220 | Senior | Senior Home delayed state |
| `State=NeedsFollowUp, CTA=Visible` | Default | H220 | Senior | Follow-up prompt without panic |

---

## Card / Hero / Caregiver Summary

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `State=Okay, CTA=Details` | Default | H196 | Standard | Caregiver Home calm summary |
| `State=Pending, CTA=Contact` | Default | H196 | Standard | No check-in yet |
| `State=Delayed, CTA=Contact` | Default | H196 | Standard | Needs gentle follow-up |
| `State=HelpRequested, CTA=ActNow` | Default | H196 | Standard | Important escalation on Caregiver Home |

---

## Card / Medication / Preview

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `State=Upcoming, Action=Details` | Default | H132 | Standard | Senior Home and Caregiver Home next dose preview |
| `State=Taken, Action=None` | Default | H124 | Compact | Later history or resolved preview |
| `State=Missed, Action=Details` | Default | H132 | Standard | Caregiver awareness of missed dose |
| `State=Snoozed, Action=Details` | Default | H132 | Standard | Mild attention needed |

---

## Card / Alert / Preview

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Count=0, Action=Hidden` | Empty | H120 | Standard | Caregiver Home no-alert state |
| `Count=1, Action=ViewAll` | Default | H148 | Standard | One active alert preview |
| `Count=2, Action=ViewAll` | Default | H196 | Standard | Max preview on Caregiver Home |
| `Count=Mixed, Action=ViewAll` | Default | H196 | Standard | Recent mixed state snapshot |

---

## Chip / Status / Semantic

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Tone=Success, Icon=On` | Default | H32 | Standard | `تم الاطمئنان اليوم`, resolved states |
| `Tone=Warning, Icon=On` | Default | H32 | Standard | `متأخر`, `مؤجل` |
| `Tone=Error, Icon=On` | Default | H32 | Standard | `تم طلب مساعدة`, urgent states |
| `Tone=Info, Icon=On` | Default | H32 | Standard | `لم يتم تسجيل الاطمئنان بعد` |
| `Tone=Any, Icon=Off` | Default | H28 | Compact | Tight card layouts |

---

## Selection Card / Role

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Role=Senior` | Default | H160 | Senior | Role Selection |
| `Role=Senior` | Selected | H160 | Senior | Role Selection selected state |
| `Role=Caregiver` | Default | H160 | Standard | Role Selection |
| `Role=Caregiver` | Selected | H160 | Standard | Role Selection selected state |

---

## Progress / Onboarding Dots

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Step=1of3` | Active1 | H8 | Compact | Onboarding slide 1 |
| `Step=2of3` | Active2 | H8 | Compact | Onboarding slide 2 |
| `Step=3of3` | Active3 | H8 | Compact | Onboarding slide 3 |

---

## Action / Quick / Icon+Label

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Layout=Pill, Type=Profile` | Default | H48 | Standard | Profile shortcut |
| `Layout=Pill, Type=Call` | Default | H48 | Standard | Caregiver quick call |
| `Layout=Pill, Type=Message` | Default | H48 | Standard | Caregiver quick message |
| `Layout=Tile, Type=Any` | Default | H72 | Standard | Small quick-action group |
| `Layout=Pill, Type=Any` | Pressed | H48 | Standard | Tap feedback |

---

## Brand / Lockup / Tamnni

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Language=ArabicOnly, Size=Large` | Default | H96 approx | Comfortable | Splash-centered identity |
| `Language=ArabicEnglish, Size=Large` | Default | H116 approx | Comfortable | Splash with bilingual lockup |
| `Language=ArabicOnly, Size=Compact` | Default | H40 approx | Compact | Future auth or onboarding top |
| `Language=ArabicEnglish, Size=Compact` | Default | H56 approx | Compact | Optional onboarding intro |

---

## Header / Greeting Block

| Variant | State | Size | Density | When to use |
|---|---|---:|---|---|
| `Type=SingleLine` | Default | H32 | Compact | Minimal greeting |
| `Type=TwoLine` | Default | H52 | Comfortable | Senior Home greeting |
| `Type=LinkedPerson` | Default | H56 | Comfortable | Caregiver Home with tracked person |
| `Type=TimeAware` | Default | H56 | Comfortable | Morning/evening contextual greeting |

---

## Implementation notes

### Figma properties to expose
- `State`
- `Mode`
- `Width`
- `Style`
- `Role`
- `Active`
- `Icon`
- `CTA`

### Suggested Compose mapping
- `TopBarType`
- `NavMode`
- `ButtonStyle`
- `CardState`
- `StatusTone`
- `RoleType`

### Batch 1 identity check
- `Card / Hero / Reassurance` is visually stronger than `Card / Medication / Preview`
- `Button / Primary / Large` with `Type=SeniorCTA` is reserved for **أنا بخير**
- `Card / Hero / Caregiver Summary` feels like a calm summary, not a KPI dashboard
- `Button / Help / Urgent` remains isolated