package ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_page_profile
import tamnnicare.composeapp.generated.resources.ar_settings_appearance
import tamnnicare.composeapp.generated.resources.ar_settings_arabic
import tamnnicare.composeapp.generated.resources.ar_settings_dark
import tamnnicare.composeapp.generated.resources.ar_settings_english
import tamnnicare.composeapp.generated.resources.ar_settings_language
import tamnnicare.composeapp.generated.resources.ar_settings_light
import tamnnicare.composeapp.generated.resources.ar_settings_open_about
import tamnnicare.composeapp.generated.resources.ar_settings_open_alerts
import tamnnicare.composeapp.generated.resources.ar_settings_open_history
import tamnnicare.composeapp.generated.resources.ar_settings_open_medications
import tamnnicare.composeapp.generated.resources.ar_settings_open_profile
import tamnnicare.composeapp.generated.resources.ar_settings_lang_subtitle
import tamnnicare.composeapp.generated.resources.ar_settings_links_subtitle
import tamnnicare.composeapp.generated.resources.ar_settings_section_links
import tamnnicare.composeapp.generated.resources.ar_settings_system
import tamnnicare.composeapp.generated.resources.ar_settings_theme_subtitle
import tamnnicare.composeapp.generated.resources.ar_settings_title
import tamnnicare.composeapp.generated.resources.en_page_profile
import tamnnicare.composeapp.generated.resources.en_settings_appearance
import tamnnicare.composeapp.generated.resources.en_settings_arabic
import tamnnicare.composeapp.generated.resources.en_settings_dark
import tamnnicare.composeapp.generated.resources.en_settings_english
import tamnnicare.composeapp.generated.resources.en_settings_language
import tamnnicare.composeapp.generated.resources.en_settings_light
import tamnnicare.composeapp.generated.resources.en_settings_open_about
import tamnnicare.composeapp.generated.resources.en_settings_open_alerts
import tamnnicare.composeapp.generated.resources.en_settings_open_history
import tamnnicare.composeapp.generated.resources.en_settings_open_medications
import tamnnicare.composeapp.generated.resources.en_settings_open_profile
import tamnnicare.composeapp.generated.resources.en_settings_lang_subtitle
import tamnnicare.composeapp.generated.resources.en_settings_links_subtitle
import tamnnicare.composeapp.generated.resources.en_settings_section_links
import tamnnicare.composeapp.generated.resources.en_settings_system
import tamnnicare.composeapp.generated.resources.en_settings_theme_subtitle
import tamnnicare.composeapp.generated.resources.en_settings_title
import ui.components.CalmSectionCard
import ui.components.SectionHeader
import ui.components.SettingsOptionRow
import ui.components.TamnniTopBar
import ui.i18n.tamnniString
import ui.state.AppAppearance
import ui.state.AppLanguage

@Composable
fun SettingsScreen(
    appLanguage: AppLanguage,
    appAppearance: AppAppearance,
    onLanguageSelected: (AppLanguage) -> Unit,
    onAppearanceSelected: (AppAppearance) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenHistory: () -> Unit,
    onOpenAlerts: () -> Unit,
    onOpenMedications: () -> Unit,
    onOpenAbout: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TamnniTopBar(
                title = tamnniString(Res.string.ar_settings_title, Res.string.en_settings_title),
                onBackClick = onBack
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    title = tamnniString(Res.string.ar_settings_language, Res.string.en_settings_language),
                    subtitle = tamnniString(Res.string.ar_settings_lang_subtitle, Res.string.en_settings_lang_subtitle)
                )
                Spacer(modifier = Modifier.height(8.dp))
                SettingsOptionRow(
                    title = tamnniString(Res.string.ar_settings_system, Res.string.en_settings_system),
                    selected = appLanguage == AppLanguage.SYSTEM,
                    onClick = { onLanguageSelected(AppLanguage.SYSTEM) }
                )
                SettingsOptionRow(
                    title = tamnniString(Res.string.ar_settings_arabic, Res.string.en_settings_arabic),
                    selected = appLanguage == AppLanguage.ARABIC,
                    onClick = { onLanguageSelected(AppLanguage.ARABIC) }
                )
                SettingsOptionRow(
                    title = tamnniString(Res.string.ar_settings_english, Res.string.en_settings_english),
                    selected = appLanguage == AppLanguage.ENGLISH,
                    onClick = { onLanguageSelected(AppLanguage.ENGLISH) }
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    title = tamnniString(Res.string.ar_settings_appearance, Res.string.en_settings_appearance),
                    subtitle = tamnniString(Res.string.ar_settings_theme_subtitle, Res.string.en_settings_theme_subtitle)
                )
                Spacer(modifier = Modifier.height(8.dp))
                SettingsOptionRow(
                    title = tamnniString(Res.string.ar_settings_system, Res.string.en_settings_system),
                    selected = appAppearance == AppAppearance.SYSTEM,
                    onClick = { onAppearanceSelected(AppAppearance.SYSTEM) }
                )
                SettingsOptionRow(
                    title = tamnniString(Res.string.ar_settings_light, Res.string.en_settings_light),
                    selected = appAppearance == AppAppearance.LIGHT,
                    onClick = { onAppearanceSelected(AppAppearance.LIGHT) }
                )
                SettingsOptionRow(
                    title = tamnniString(Res.string.ar_settings_dark, Res.string.en_settings_dark),
                    selected = appAppearance == AppAppearance.DARK,
                    onClick = { onAppearanceSelected(AppAppearance.DARK) }
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    title = tamnniString(Res.string.ar_settings_section_links, Res.string.en_settings_section_links),
                    subtitle = tamnniString(Res.string.ar_settings_links_subtitle, Res.string.en_settings_links_subtitle)
                )
                Spacer(modifier = Modifier.height(8.dp))
                LinkRow(
                    title = tamnniString(Res.string.ar_settings_open_profile, Res.string.en_settings_open_profile),
                    onClick = onOpenProfile
                )
                LinkRow(
                    title = tamnniString(Res.string.ar_settings_open_history, Res.string.en_settings_open_history),
                    onClick = onOpenHistory
                )
                LinkRow(
                    title = tamnniString(Res.string.ar_settings_open_alerts, Res.string.en_settings_open_alerts),
                    onClick = onOpenAlerts
                )
                LinkRow(
                    title = tamnniString(Res.string.ar_settings_open_medications, Res.string.en_settings_open_medications),
                    onClick = onOpenMedications
                )
                LinkRow(
                    title = tamnniString(Res.string.ar_settings_open_about, Res.string.en_settings_open_about),
                    onClick = onOpenAbout
                )
            }
        }
    }
}

@Composable
private fun LinkRow(
    title: String,
    onClick: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.12f))
    }
}

