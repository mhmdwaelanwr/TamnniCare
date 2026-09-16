package ui.state

import com.russhwolf.settings.Settings

enum class UserRole(val storageValue: String) {
    SENIOR("senior"),
    CAREGIVER("caregiver");

    companion object {
        fun fromStorage(value: String?): UserRole? {
            return entries.firstOrNull { it.storageValue == value }
        }
    }
}

data class PersistedAppState(
    val onboardingCompleted: Boolean,
    val selectedRole: UserRole?
)

object AppStateStore {
    private const val KEY_ONBOARDING_COMPLETED = "onboarding_completed"
    private const val KEY_SELECTED_ROLE = "selected_role"

    /**
     * Use lazy initialization with a try-catch fallback.
     * This prevents the AppStateStore from failing to initialize in environments where
     * the platform's default Settings implementation is unavailable, such as 
     * during Android Studio Compose Previews.
     */
    private val settings: Settings? by lazy {
        try {
            Settings()
        } catch (t: Throwable) {
            null
        }
    }

    fun loadState(): PersistedAppState {
        val s = settings ?: return PersistedAppState(
            onboardingCompleted = false,
            selectedRole = null
        )
        
        val onboardingCompleted = s.getBoolean(KEY_ONBOARDING_COMPLETED, false)
        val selectedRole = UserRole.fromStorage(s.getStringOrNull(KEY_SELECTED_ROLE))
        return PersistedAppState(
            onboardingCompleted = onboardingCompleted,
            selectedRole = selectedRole
        )
    }

    fun saveOnboardingCompleted(completed: Boolean) {
        settings?.putBoolean(KEY_ONBOARDING_COMPLETED, completed)
    }

    fun saveSelectedRole(role: UserRole) {
        settings?.putString(KEY_SELECTED_ROLE, role.storageValue)
    }

    // Useful for local testing without adding visible debug controls to production screens.
    fun resetForTesting() {
        settings?.remove(KEY_ONBOARDING_COMPLETED)
        settings?.remove(KEY_SELECTED_ROLE)
    }
}
