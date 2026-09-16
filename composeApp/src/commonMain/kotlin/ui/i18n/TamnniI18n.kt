package ui.i18n

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import ui.state.AppLanguage

enum class ResolvedLanguage {
    AR,
    EN
}

val LocalResolvedLanguage = staticCompositionLocalOf { ResolvedLanguage.AR }

@Composable
fun ProvideResolvedLanguage(
    appLanguage: AppLanguage,
    content: @Composable () -> Unit
) {
    val resolved = when (appLanguage) {
        AppLanguage.ARABIC -> ResolvedLanguage.AR
        AppLanguage.ENGLISH -> ResolvedLanguage.EN
        AppLanguage.SYSTEM -> {
            if (Locale.current.language.lowercase().startsWith("ar")) {
                ResolvedLanguage.AR
            } else {
                ResolvedLanguage.EN
            }
        }
    }

    CompositionLocalProvider(LocalResolvedLanguage provides resolved) {
        content()
    }
}

@Composable
fun tamnniString(ar: StringResource, en: StringResource): String {
    return if (LocalResolvedLanguage.current == ResolvedLanguage.AR) {
        stringResource(ar)
    } else {
        stringResource(en)
    }
}

@Composable
fun isArabicLanguage(): Boolean {
    return LocalResolvedLanguage.current == ResolvedLanguage.AR
}

