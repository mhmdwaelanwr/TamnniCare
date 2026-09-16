package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_help_idle_text
import tamnnicare.composeapp.generated.resources.ar_help_request
import tamnnicare.composeapp.generated.resources.ar_help_requested
import tamnnicare.composeapp.generated.resources.ar_help_requested_text
import tamnnicare.composeapp.generated.resources.ar_help_reset
import tamnnicare.composeapp.generated.resources.ar_help_subtitle
import tamnnicare.composeapp.generated.resources.ar_help_title
import tamnnicare.composeapp.generated.resources.ar_medication_section_subtitle
import tamnnicare.composeapp.generated.resources.ar_medication_section_title
import tamnnicare.composeapp.generated.resources.ar_morning_greeting_prefix
import tamnnicare.composeapp.generated.resources.ar_quick_links_subtitle
import tamnnicare.composeapp.generated.resources.ar_quick_links_title
import tamnnicare.composeapp.generated.resources.ar_quick_links_short_history
import tamnnicare.composeapp.generated.resources.ar_quick_links_short_meds
import tamnnicare.composeapp.generated.resources.ar_quick_links_short_profile
import tamnnicare.composeapp.generated.resources.ar_sample_senior_name
import tamnnicare.composeapp.generated.resources.en_help_idle_text
import tamnnicare.composeapp.generated.resources.en_help_request
import tamnnicare.composeapp.generated.resources.en_help_requested
import tamnnicare.composeapp.generated.resources.en_help_requested_text
import tamnnicare.composeapp.generated.resources.en_help_reset
import tamnnicare.composeapp.generated.resources.en_help_subtitle
import tamnnicare.composeapp.generated.resources.en_help_title
import tamnnicare.composeapp.generated.resources.en_medication_section_subtitle
import tamnnicare.composeapp.generated.resources.en_medication_section_title
import tamnnicare.composeapp.generated.resources.en_morning_greeting_prefix
import tamnnicare.composeapp.generated.resources.en_quick_links_subtitle
import tamnnicare.composeapp.generated.resources.en_quick_links_title
import tamnnicare.composeapp.generated.resources.en_quick_links_short_history
import tamnnicare.composeapp.generated.resources.en_quick_links_short_meds
import tamnnicare.composeapp.generated.resources.en_quick_links_short_profile
import tamnnicare.composeapp.generated.resources.en_sample_senior_name
import ui.components.CalmSectionCard
import ui.components.HelpButton
import ui.components.MedicationPreviewCard
import ui.components.QuickLinkAction
import ui.components.QuickLinksCard
import ui.components.ReassuranceHeroCard
import ui.components.SectionHeader
import ui.components.TamnniTopBar
import ui.i18n.tamnniString
import ui.state.rememberSeniorHomeStateHolder

@Composable
fun SeniorHomeScreen(
    onHelpRequested: () -> Unit,
    onOpenSettings: () -> Unit,
    onOpenProfile: () -> Unit,
    onOpenHistory: () -> Unit,
    onOpenMedications: () -> Unit
) {
    val stateHolder = rememberSeniorHomeStateHolder()
    val uiState by stateHolder.uiState.collectAsState()
    val localizedSeniorName = tamnniString(Res.string.ar_sample_senior_name, Res.string.en_sample_senior_name)

    Scaffold(
        topBar = {
            TamnniTopBar(
                title = "${tamnniString(Res.string.ar_morning_greeting_prefix, Res.string.en_morning_greeting_prefix)} $localizedSeniorName",
                onSettingsClick = onOpenSettings
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            ReassuranceHeroCard(
                status = uiState.reassuranceStatus,
                lastUpdateLabel = uiState.lastUpdateLabel,
                onReassureClick = { stateHolder.onConfirmReassurance() },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader(
                title = tamnniString(Res.string.ar_medication_section_title, Res.string.en_medication_section_title),
                subtitle = tamnniString(Res.string.ar_medication_section_subtitle, Res.string.en_medication_section_subtitle)
            )
            Spacer(modifier = Modifier.height(12.dp))

            MedicationPreviewCard(
                medicationName = uiState.medication.name,
                time = uiState.medication.time,
                isTaken = uiState.medication.isTaken
            )

            Spacer(modifier = Modifier.height(20.dp))

            QuickLinksCard(
                title = tamnniString(Res.string.ar_quick_links_title, Res.string.en_quick_links_title),
                subtitle = tamnniString(Res.string.ar_quick_links_subtitle, Res.string.en_quick_links_subtitle),
                first = QuickLinkAction(
                    label = tamnniString(Res.string.ar_quick_links_short_history, Res.string.en_quick_links_short_history),
                    onClick = onOpenHistory
                ),
                second = QuickLinkAction(
                    label = tamnniString(Res.string.ar_quick_links_short_meds, Res.string.en_quick_links_short_meds),
                    onClick = onOpenMedications
                ),
                third = QuickLinkAction(
                    label = tamnniString(Res.string.ar_quick_links_short_profile, Res.string.en_quick_links_short_profile),
                    onClick = onOpenProfile
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            CalmSectionCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                SectionHeader(
                    title = tamnniString(Res.string.ar_help_title, Res.string.en_help_title),
                    subtitle = tamnniString(Res.string.ar_help_subtitle, Res.string.en_help_subtitle)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = if (uiState.help.isRequested) {
                        tamnniString(Res.string.ar_help_requested_text, Res.string.en_help_requested_text)
                    } else {
                        tamnniString(Res.string.ar_help_idle_text, Res.string.en_help_idle_text)
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                if (uiState.help.isRequested) {
                    Spacer(modifier = Modifier.height(4.dp))
                    TextButton(onClick = { stateHolder.onClearHelpRequest() }) {
                        Text(tamnniString(Res.string.ar_help_reset, Res.string.en_help_reset))
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                HelpButton(
                    onClick = {
                        if (stateHolder.onHelpClick()) {
                            onHelpRequested()
                        }
                    },
                    isActive = uiState.help.isRequested,
                    text = if (uiState.help.isRequested) {
                        tamnniString(Res.string.ar_help_requested, Res.string.en_help_requested)
                    } else {
                        tamnniString(Res.string.ar_help_request, Res.string.en_help_request)
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

