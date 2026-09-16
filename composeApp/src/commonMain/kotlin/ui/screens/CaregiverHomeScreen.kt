package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_alerts_subtitle
import tamnnicare.composeapp.generated.resources.ar_alerts_title
import tamnnicare.composeapp.generated.resources.ar_actions_quick
import tamnnicare.composeapp.generated.resources.ar_actions_subtitle
import tamnnicare.composeapp.generated.resources.ar_alert_delayed
import tamnnicare.composeapp.generated.resources.ar_alert_followup
import tamnnicare.composeapp.generated.resources.ar_alert_none
import tamnnicare.composeapp.generated.resources.ar_alert_pending
import tamnnicare.composeapp.generated.resources.ar_hello_prefix
import tamnnicare.composeapp.generated.resources.ar_medication_section_subtitle
import tamnnicare.composeapp.generated.resources.ar_not_reassured_today
import tamnnicare.composeapp.generated.resources.ar_nav_alerts
import tamnnicare.composeapp.generated.resources.ar_nav_home
import tamnnicare.composeapp.generated.resources.ar_nav_profile
import tamnnicare.composeapp.generated.resources.ar_quick_links_subtitle
import tamnnicare.composeapp.generated.resources.ar_quick_links_title
import tamnnicare.composeapp.generated.resources.ar_quick_links_short_alerts
import tamnnicare.composeapp.generated.resources.ar_quick_links_short_history
import tamnnicare.composeapp.generated.resources.ar_quick_links_short_meds
import tamnnicare.composeapp.generated.resources.ar_reassured_today
import tamnnicare.composeapp.generated.resources.ar_summary_today
import tamnnicare.composeapp.generated.resources.ar_sample_caregiver_name
import tamnnicare.composeapp.generated.resources.ar_sample_senior_name
import tamnnicare.composeapp.generated.resources.ar_status_delayed
import tamnnicare.composeapp.generated.resources.ar_status_delayed_interpretation
import tamnnicare.composeapp.generated.resources.ar_status_follow_up
import tamnnicare.composeapp.generated.resources.ar_status_followup_interpretation
import tamnnicare.composeapp.generated.resources.ar_status_ok_interpretation
import tamnnicare.composeapp.generated.resources.ar_status_pending_interpretation
import tamnnicare.composeapp.generated.resources.ar_settings_open_alerts
import tamnnicare.composeapp.generated.resources.ar_medication_section_title
import tamnnicare.composeapp.generated.resources.ar_today_status
import tamnnicare.composeapp.generated.resources.ar_tracking_prefix
import tamnnicare.composeapp.generated.resources.en_alerts_subtitle
import tamnnicare.composeapp.generated.resources.en_alerts_title
import tamnnicare.composeapp.generated.resources.en_actions_quick
import tamnnicare.composeapp.generated.resources.en_actions_subtitle
import tamnnicare.composeapp.generated.resources.en_alert_delayed
import tamnnicare.composeapp.generated.resources.en_alert_followup
import tamnnicare.composeapp.generated.resources.en_alert_none
import tamnnicare.composeapp.generated.resources.en_alert_pending
import tamnnicare.composeapp.generated.resources.en_hello_prefix
import tamnnicare.composeapp.generated.resources.en_medication_section_subtitle
import tamnnicare.composeapp.generated.resources.en_not_reassured_today
import tamnnicare.composeapp.generated.resources.en_nav_alerts
import tamnnicare.composeapp.generated.resources.en_nav_home
import tamnnicare.composeapp.generated.resources.en_nav_profile
import tamnnicare.composeapp.generated.resources.en_quick_links_subtitle
import tamnnicare.composeapp.generated.resources.en_quick_links_title
import tamnnicare.composeapp.generated.resources.en_quick_links_short_alerts
import tamnnicare.composeapp.generated.resources.en_quick_links_short_history
import tamnnicare.composeapp.generated.resources.en_quick_links_short_meds
import tamnnicare.composeapp.generated.resources.en_reassured_today
import tamnnicare.composeapp.generated.resources.en_summary_today
import tamnnicare.composeapp.generated.resources.en_sample_caregiver_name
import tamnnicare.composeapp.generated.resources.en_sample_senior_name
import tamnnicare.composeapp.generated.resources.en_status_delayed
import tamnnicare.composeapp.generated.resources.en_status_delayed_interpretation
import tamnnicare.composeapp.generated.resources.en_status_follow_up
import tamnnicare.composeapp.generated.resources.en_status_followup_interpretation
import tamnnicare.composeapp.generated.resources.en_status_ok_interpretation
import tamnnicare.composeapp.generated.resources.en_status_pending_interpretation
import tamnnicare.composeapp.generated.resources.en_settings_open_alerts
import tamnnicare.composeapp.generated.resources.en_medication_section_title
import tamnnicare.composeapp.generated.resources.en_today_status
import tamnnicare.composeapp.generated.resources.en_tracking_prefix
import ui.components.AlertPreviewCard
import ui.components.BottomNavDestination
import ui.components.CalmSectionCard
import ui.components.CaregiverSummaryCard
import ui.components.MedicationPreviewCard
import ui.components.QuickLinkAction
import ui.components.QuickLinksCard
import ui.components.QuickActionsRow
import ui.components.SectionHeader
import ui.components.StatusChip
import ui.components.TamnniBottomNav
import ui.components.TamnniTopBar
import ui.i18n.tamnniString
import ui.state.DailyReassuranceStatus
import ui.state.rememberCaregiverHomeStateHolder

@Composable
fun CaregiverHomeScreen(
    onOpenSettings: () -> Unit,
    onOpenAlerts: () -> Unit,
    onOpenProfile: () -> Unit,
    onOpenHome: () -> Unit,
    onOpenHistory: () -> Unit,
    onOpenMedications: () -> Unit
) {
    val stateHolder = rememberCaregiverHomeStateHolder()
    val uiState by stateHolder.uiState.collectAsState()
    val localizedCaregiverName = tamnniString(Res.string.ar_sample_caregiver_name, Res.string.en_sample_caregiver_name)
    val localizedSeniorName = tamnniString(Res.string.ar_sample_senior_name, Res.string.en_sample_senior_name)
    val summaryText = when (uiState.reassuranceStatus) {
        DailyReassuranceStatus.REASSURED_TODAY -> tamnniString(Res.string.ar_reassured_today, Res.string.en_reassured_today)
        DailyReassuranceStatus.NOT_REASSURED -> tamnniString(Res.string.ar_not_reassured_today, Res.string.en_not_reassured_today)
        DailyReassuranceStatus.DELAYED -> tamnniString(Res.string.ar_status_delayed, Res.string.en_status_delayed)
        DailyReassuranceStatus.NEEDS_FOLLOW_UP -> tamnniString(Res.string.ar_status_follow_up, Res.string.en_status_follow_up)
    }
    val summaryInterpretation = when (uiState.reassuranceStatus) {
        DailyReassuranceStatus.REASSURED_TODAY -> tamnniString(Res.string.ar_status_ok_interpretation, Res.string.en_status_ok_interpretation)
        DailyReassuranceStatus.NOT_REASSURED -> tamnniString(Res.string.ar_status_pending_interpretation, Res.string.en_status_pending_interpretation)
        DailyReassuranceStatus.DELAYED -> tamnniString(Res.string.ar_status_delayed_interpretation, Res.string.en_status_delayed_interpretation)
        DailyReassuranceStatus.NEEDS_FOLLOW_UP -> tamnniString(Res.string.ar_status_followup_interpretation, Res.string.en_status_followup_interpretation)
    }
    val alertMessage = when (uiState.reassuranceStatus) {
        DailyReassuranceStatus.REASSURED_TODAY -> tamnniString(Res.string.ar_alert_none, Res.string.en_alert_none)
        DailyReassuranceStatus.NOT_REASSURED -> tamnniString(Res.string.ar_alert_pending, Res.string.en_alert_pending)
        DailyReassuranceStatus.DELAYED -> tamnniString(Res.string.ar_alert_delayed, Res.string.en_alert_delayed)
        DailyReassuranceStatus.NEEDS_FOLLOW_UP -> tamnniString(Res.string.ar_alert_followup, Res.string.en_alert_followup)
    }

    Scaffold(
        topBar = {
            TamnniTopBar(
                title = "${tamnniString(Res.string.ar_hello_prefix, Res.string.en_hello_prefix)} $localizedCaregiverName",
                onSettingsClick = onOpenSettings
            )
        },
        bottomBar = {
            TamnniBottomNav(
                selected = BottomNavDestination.HOME,
                homeLabel = tamnniString(Res.string.ar_nav_home, Res.string.en_nav_home),
                alertsLabel = tamnniString(Res.string.ar_nav_alerts, Res.string.en_nav_alerts),
                profileLabel = tamnniString(Res.string.ar_nav_profile, Res.string.en_nav_profile),
                onHomeClick = onOpenHome,
                onAlertsClick = onOpenAlerts,
                onProfileClick = onOpenProfile
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = tamnniString(Res.string.ar_tracking_prefix, Res.string.en_tracking_prefix),
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = localizedSeniorName,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    StatusChip(
                        text = tamnniString(Res.string.ar_summary_today, Res.string.en_summary_today),
                        isSuccess = uiState.reassuranceStatus == DailyReassuranceStatus.REASSURED_TODAY
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            CaregiverSummaryCard(
                statusLabel = tamnniString(Res.string.ar_today_status, Res.string.en_today_status),
                mainState = summaryText,
                interpretation = summaryInterpretation,
                lastUpdate = uiState.summary.lastUpdate,
                onDetailsClick = { stateHolder.onDetailsClick() }
            )

            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader(
                title = tamnniString(Res.string.ar_alerts_title, Res.string.en_alerts_title),
                subtitle = tamnniString(Res.string.ar_alerts_subtitle, Res.string.en_alerts_subtitle)
            )
            Spacer(modifier = Modifier.height(12.dp))

            AlertPreviewCard(
                message = alertMessage,
                isAttention = uiState.alertIsAttention
            )

            Spacer(modifier = Modifier.height(20.dp))

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
                    label = tamnniString(Res.string.ar_quick_links_short_alerts, Res.string.en_quick_links_short_alerts),
                    onClick = onOpenAlerts
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            CalmSectionCard {
                SectionHeader(
                    title = tamnniString(Res.string.ar_actions_quick, Res.string.en_actions_quick),
                    subtitle = tamnniString(Res.string.ar_actions_subtitle, Res.string.en_actions_subtitle)
                )
                Spacer(modifier = Modifier.height(12.dp))
                QuickActionsRow(
                    onCallClick = { stateHolder.onCallClick() },
                    onMessageClick = { stateHolder.onMessageClick() }
                )
            }
        }
    }
}
