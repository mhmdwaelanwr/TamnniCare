# Tamnni Care — User Flows

## Core User Roles
- Senior User
- Caregiver / Family Member

## First-Time User Flow
1. Open app
2. Splash screen
3. Onboarding
4. Select language
5. Select role
6. Sign In or Sign Up
7. Complete setup
8. Enable notifications
9. Enter role-specific home

## Senior Flows

### Senior Onboarding
1. Select **Senior**
2. Sign Up / Sign In
3. Enter name and basic info
4. Set check-in reminder time
5. Optionally add medication
6. Enable notifications
7. Go to Senior Home

### Daily Check-in Flow
1. Open Senior Home
2. See daily status
3. Tap **I'm Okay / أنا بخير**
4. App saves timestamp
5. UI changes to completed state

### Medication Reminder Flow
1. Notification appears
2. Senior opens app or taps notification
3. Medication screen opens
4. Senior selects:
   - Taken
   - Snooze
5. App saves status

### Emergency Help Flow
1. Senior taps Help
2. Confirms help request
3. App sends alert
4. Senior sees success state
5. Caregiver receives urgent alert

## Caregiver Flows

### Caregiver Onboarding
1. Select **Caregiver**
2. Sign Up / Sign In
3. Enter basic info
4. Link to senior profile
5. Enable notifications
6. Go to Caregiver Home

### Caregiver Daily Status Flow
1. Open app
2. View today's status
3. Review:
   - check-in state
   - last check-in time
   - medication snapshot

### Missed Check-in Alert Flow
1. Senior does not check in on time
2. Grace period expires
3. Caregiver receives push notification
4. Opens alert details
5. Takes action

## V1 Priority Flows
- First-time onboarding
- Senior daily check-in
- Caregiver daily status
- Medication reminder action
- Missed check-in alert
- Emergency help request
