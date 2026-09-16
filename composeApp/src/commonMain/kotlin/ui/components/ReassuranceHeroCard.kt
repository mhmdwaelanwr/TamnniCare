package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_im_okay
import tamnnicare.composeapp.generated.resources.ar_last_update_prefix
import tamnnicare.composeapp.generated.resources.ar_not_reassured_today
import tamnnicare.composeapp.generated.resources.ar_reassure_hint
import tamnnicare.composeapp.generated.resources.ar_reassure_success
import tamnnicare.composeapp.generated.resources.ar_reassured_today
import tamnnicare.composeapp.generated.resources.ar_senior_delayed_helper
import tamnnicare.composeapp.generated.resources.ar_senior_followup_helper
import tamnnicare.composeapp.generated.resources.ar_senior_pending_helper
import tamnnicare.composeapp.generated.resources.ar_status_delayed
import tamnnicare.composeapp.generated.resources.ar_status_follow_up
import tamnnicare.composeapp.generated.resources.ar_today_status
import tamnnicare.composeapp.generated.resources.en_im_okay
import tamnnicare.composeapp.generated.resources.en_last_update_prefix
import tamnnicare.composeapp.generated.resources.en_not_reassured_today
import tamnnicare.composeapp.generated.resources.en_reassure_hint
import tamnnicare.composeapp.generated.resources.en_reassure_success
import tamnnicare.composeapp.generated.resources.en_reassured_today
import tamnnicare.composeapp.generated.resources.en_senior_delayed_helper
import tamnnicare.composeapp.generated.resources.en_senior_followup_helper
import tamnnicare.composeapp.generated.resources.en_senior_pending_helper
import tamnnicare.composeapp.generated.resources.en_status_delayed
import tamnnicare.composeapp.generated.resources.en_status_follow_up
import tamnnicare.composeapp.generated.resources.en_today_status
import ui.i18n.tamnniString
import ui.state.DailyReassuranceStatus

@Composable
fun ReassuranceHeroCard(
    onReassureClick: () -> Unit,
    status: DailyReassuranceStatus,
    lastUpdateLabel: String,
    modifier: Modifier = Modifier
) {
    val isReassuredToday = status == DailyReassuranceStatus.REASSURED_TODAY
    val stateTitle = when (status) {
        DailyReassuranceStatus.REASSURED_TODAY -> tamnniString(Res.string.ar_reassured_today, Res.string.en_reassured_today)
        DailyReassuranceStatus.NOT_REASSURED -> tamnniString(Res.string.ar_not_reassured_today, Res.string.en_not_reassured_today)
        DailyReassuranceStatus.DELAYED -> tamnniString(Res.string.ar_status_delayed, Res.string.en_status_delayed)
        DailyReassuranceStatus.NEEDS_FOLLOW_UP -> tamnniString(Res.string.ar_status_follow_up, Res.string.en_status_follow_up)
    }
    val pendingHelper = when (status) {
        DailyReassuranceStatus.NOT_REASSURED -> tamnniString(Res.string.ar_senior_pending_helper, Res.string.en_senior_pending_helper)
        DailyReassuranceStatus.DELAYED -> tamnniString(Res.string.ar_senior_delayed_helper, Res.string.en_senior_delayed_helper)
        DailyReassuranceStatus.NEEDS_FOLLOW_UP -> tamnniString(Res.string.ar_senior_followup_helper, Res.string.en_senior_followup_helper)
        DailyReassuranceStatus.REASSURED_TODAY -> tamnniString(Res.string.ar_reassure_success, Res.string.en_reassure_success)
    }

    val onContainerColor = if (isReassuredToday) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSecondaryContainer
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = if (isReassuredToday) MaterialTheme.colorScheme.primaryContainer 
                             else MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Status Label
            Text(
                text = tamnniString(Res.string.ar_today_status, Res.string.en_today_status),
                style = MaterialTheme.typography.labelMedium,
                color = onContainerColor.copy(alpha = 0.88f)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.65f)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier.padding(12.dp).size(48.dp),
                    tint = if (isReassuredToday) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stateTitle,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                color = onContainerColor
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = pendingHelper,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = onContainerColor.copy(alpha = 0.85f)
            )

            // Last Update
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${tamnniString(Res.string.ar_last_update_prefix, Res.string.en_last_update_prefix)} $lastUpdateLabel",
                style = MaterialTheme.typography.bodyMedium,
                color = onContainerColor.copy(alpha = 0.8f)
            )

            // Clear CTA
            if (!isReassuredToday) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = tamnniString(Res.string.ar_reassure_hint, Res.string.en_reassure_hint),
                    style = MaterialTheme.typography.bodyMedium,
                    color = onContainerColor.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = onReassureClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        tamnniString(Res.string.ar_im_okay, Res.string.en_im_okay),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}
