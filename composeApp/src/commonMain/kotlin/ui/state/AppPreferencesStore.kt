package ui.state

import com.russhwolf.settings.Settings

enum class AppLanguage(val storageValue: String) {
    SYSTEM("system"),
    ARABIC("ar"),
    ENGLISH("en");

    companion object {
        fun fromStorage(value: String?): AppLanguage {
            return entries.firstOrNull { it.storageValue == value } ?: SYSTEM
        }
    }
}

enum class AppAppearance(val storageValue: String) {
    SYSTEM("system"),
    LIGHT("light"),
    DARK("dark");

    companion object {
        fun fromStorage(value: String?): AppAppearance {
            return entries.firstOrNull { it.storageValue == value } ?: SYSTEM
        }
    }
}

data class AppPreferences(
    val language: AppLanguage,
    val appearance: AppAppearance
)

object AppPreferencesStore {
    private const val KEY_LANGUAGE = "app_language"
    private const val KEY_APPEARANCE = "app_appearance"

    private val settings: Settings? by lazy {
        try {
            Settings()
        } catch (_: Throwable) {
            null
        }
    }

    fun load(): AppPreferences {
        val s = settings
        if (s == null) {
            return AppPreferences(
                language = AppLanguage.SYSTEM,
                appearance = AppAppearance.SYSTEM
            )
        }

        return AppPreferences(
            language = AppLanguage.fromStorage(s.getStringOrNull(KEY_LANGUAGE)),
            appearance = AppAppearance.fromStorage(s.getStringOrNull(KEY_APPEARANCE))
        )
    }

    fun saveLanguage(language: AppLanguage) {
        settings?.putString(KEY_LANGUAGE, language.storageValue)
    }

    fun saveAppearance(appearance: AppAppearance) {
        settings?.putString(KEY_APPEARANCE, appearance.storageValue)
    }
}

