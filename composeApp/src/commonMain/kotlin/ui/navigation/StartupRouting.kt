package ui.navigation

import ui.state.PersistedAppState
import ui.state.UserRole

fun resolveStartupRoute(state: PersistedAppState): String {
    return when {
        !state.onboardingCompleted -> Routes.ONBOARDING
        state.selectedRole == UserRole.SENIOR -> Routes.SENIOR_HOME
        state.selectedRole == UserRole.CAREGIVER -> Routes.CAREGIVER_HOME
        else -> Routes.ROLE_SELECTION
    }
}

