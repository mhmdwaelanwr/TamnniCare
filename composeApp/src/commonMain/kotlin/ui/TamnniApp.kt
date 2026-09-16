package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ui.i18n.ProvideResolvedLanguage
import ui.i18n.isArabicLanguage
import ui.navigation.AppNavigation
import ui.state.AppAppearance
import ui.state.AppPreferencesStore
import ui.state.DailyReassuranceRefreshIntent
import ui.theme.AppTheme

@Composable
fun TamnniApp() {
    var preferences by remember { mutableStateOf(AppPreferencesStore.load()) }

    ProvideResolvedLanguage(appLanguage = preferences.language) {
        val darkTheme = when (preferences.appearance) {
            AppAppearance.SYSTEM -> isSystemInDarkTheme()
            AppAppearance.LIGHT -> false
            AppAppearance.DARK -> true
        }

        AppTheme(
            darkTheme = darkTheme,
            isArabic = isArabicLanguage()
        ) {
            AppNavigation(
                appLanguage = preferences.language,
                appAppearance = preferences.appearance,
                onLanguageSelected = { language ->
                    AppPreferencesStore.saveLanguage(language)
                    preferences = preferences.copy(language = language)
                    DailyReassuranceRefreshIntent.onAppBecameActive()
                },
                onAppearanceSelected = { appearance ->
                    AppPreferencesStore.saveAppearance(appearance)
                    preferences = preferences.copy(appearance = appearance)
                }
            )
        }
    }
}

