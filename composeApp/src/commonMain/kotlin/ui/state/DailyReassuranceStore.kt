package ui.state

import com.russhwolf.settings.Settings

object DailyReassuranceStore {
    private const val KEY_LAST_UPDATE_EPOCH_MILLIS = "daily_reassurance_last_update_epoch_millis"
    private const val NO_VALUE = -1L
    private var inMemoryFallbackLastUpdateEpochMillis: Long? = null

    /**
     * Use lazy initialization with a try-catch fallback.
     * This prevents the DailyReassuranceStore from failing to initialize in environments where
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

    fun loadLastUpdateEpochMillis(): Long? {
        val s = settings
        if (s == null) {
            return inMemoryFallbackLastUpdateEpochMillis
        }

        val stored = s.getLong(KEY_LAST_UPDATE_EPOCH_MILLIS, NO_VALUE)
        return if (stored == NO_VALUE) null else stored
    }

    fun saveLastUpdateEpochMillis(value: Long) {
        inMemoryFallbackLastUpdateEpochMillis = value
        settings?.putLong(KEY_LAST_UPDATE_EPOCH_MILLIS, value)
    }

    fun clearForTesting() {
        inMemoryFallbackLastUpdateEpochMillis = null
        settings?.remove(KEY_LAST_UPDATE_EPOCH_MILLIS)
    }
}
