package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_last_update_prefix
import tamnnicare.composeapp.generated.resources.ar_summary_today
import tamnnicare.composeapp.generated.resources.ar_view_details
import tamnnicare.composeapp.generated.resources.en_last_update_prefix
import tamnnicare.composeapp.generated.resources.en_summary_today
import tamnnicare.composeapp.generated.resources.en_view_details
import ui.i18n.tamnniString

@Composable
fun CaregiverSummaryCard(
    statusLabel: String,
    mainState: String,
    interpretation: String,
    lastUpdate: String,
    onDetailsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = statusLabel,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
                StatusChip(
                    text = tamnniString(Res.string.ar_summary_today, Res.string.en_summary_today),
                    isSuccess = true
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = mainState,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = interpretation,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${tamnniString(Res.string.ar_last_update_prefix, Res.string.en_last_update_prefix)} $lastUpdate",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.6f)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = onDetailsClick,
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    tamnniString(Res.string.ar_view_details, Res.string.en_view_details),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}
