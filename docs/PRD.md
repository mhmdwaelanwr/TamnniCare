# Tamnni Care — Product Requirements

## Product Summary

**Name:** طمّني / Tamnni Care  
**Type:** Mobile app for elderly reassurance and family care coordination

## One-line Description

A simple app that helps families stay reassured through daily check-ins, medication follow-up, and calm alerts when follow-up may be needed.

## Problem

Families often worry about elderly parents or relatives who live alone or need regular follow-up. Existing solutions can feel too medical, too complicated, or poorly adapted to senior users.

Tamnni Care aims to make the most common reassurance flow very simple: a senior confirms they are okay, while a family member/caregiver gets a clear status and can follow up when necessary.

## Product Principles

- simple before feature-rich
- elderly-friendly interaction and touch targets
- calm language instead of alarming language
- Arabic and English support
- clear separation between reassurance and emergency/medical services
- small MVP first, deeper infrastructure later

## Target Users

### Senior User

Needs:

- one-tap “I’m okay” confirmation
- clear medication follow-up
- simple help-request entry point
- large, understandable UI
- minimal navigation complexity

### Caregiver / Family Member

Needs:

- clear daily reassurance status
- missed/delayed check-in visibility
- simple medication overview
- a fast way to review alerts/history and follow up

## Current Repository Baseline

The current prototype already contains:

- Splash
- Onboarding
- Role Selection
- Senior Home
- Caregiver Home
- Settings
- Profile
- Reassurance History
- Alerts List
- Medication Overview
- About
- language/appearance settings
- local reassurance state and refresh policy
- shared Android/iOS Compose UI
- common tests

Some screens currently use sample/in-memory data. The help request and caregiver quick actions are prototype UI/state hooks and are **not live family/emergency integrations** yet.

## MVP Features

### 1. Daily Check-in

**Current:** local prototype flow implemented.

Target behavior:

- senior can confirm “I’m okay”
- today’s state updates clearly
- caregiver sees the latest reassurance state
- missed/delayed state can be evaluated consistently

### 2. Medication Follow-up

**Current:** medication preview/overview UI with sample state.

Target behavior:

- medication list
- next dose
- taken / upcoming / missed state
- editable medication schedule
- local reminder scheduling

### 3. Missed Check-in Alerts

**Current:** alert/status UI exists.

Target behavior:

- configurable check-in expectation/grace period
- create an alert when a reassurance is delayed/missed
- deliver the alert to linked caregivers
- keep alert/history state persistent

### 4. Help Request

**Current:** local senior help-request state exists.

Target behavior:

- senior can request help intentionally
- linked caregiver/family receives the request
- delivery failure/retry is visible
- wording remains clear that the app is not an emergency-response service

### 5. Family Connection

**Current:** role experiences exist, but real account/family linking is not implemented.

Target behavior:

- account/session model
- link senior and caregiver/family members
- permissions/ownership for shared care data
- unlink/revoke flow

## Planned Authentication

Sign in/sign up was part of the original product direction, but it is not implemented in the current repository baseline. It should be added together with the real family-linking/backend model instead of as an isolated screen-only feature.

## Non-goals for V1

- live location tracking
- video calls
- wearable integration
- medical-device sync
- doctor consultations
- advanced AI
- payments

## Success Metrics

Once a real backend and users exist, useful product metrics include:

- daily check-in completion rate
- medication confirmation rate
- missed-check-in alert rate
- successful caregiver follow-up rate
- 7-day retention
- 30-day retention

These are product goals, not metrics currently collected by the prototype.

## Safety Boundary

Tamnni Care is a family reassurance product concept, not a medical device, diagnostic product, emergency service, or substitute for professional care. Production release requires real delivery guarantees/failure handling, privacy review, permission design, and appropriate user-facing safety wording.

## Final Product Statement

**Tamnni Care** helps families stay reassured through simple daily check-ins, medication follow-up, and missed-response alerts in a calm, senior-friendly experience.

Implementation order and production milestones are tracked in [`../ROADMAP.md`](../ROADMAP.md).
