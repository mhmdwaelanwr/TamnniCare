package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_medication_waiting_compact
import tamnnicare.composeapp.generated.resources.ar_medication_taken_compact
import tamnnicare.composeapp.generated.resources.ar_next_dose
import tamnnicare.composeapp.generated.resources.ar_status_taken
import tamnnicare.composeapp.generated.resources.ar_status_upcoming
import tamnnicare.composeapp.generated.resources.en_medication_waiting_compact
import tamnnicare.composeapp.generated.resources.en_medication_taken_compact
import tamnnicare.composeapp.generated.resources.en_next_dose
import tamnnicare.composeapp.generated.resources.en_status_taken
import tamnnicare.composeapp.generated.resources.en_status_upcoming
import ui.i18n.tamnniString

@Composable
fun MedicationPreviewCard(
    medicationName: String,
    time: String,
    isTaken: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left zone: label + medicine name + time row
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tamnniString(Res.string.ar_next_dose, Res.string.en_next_dose),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = medicationName,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                    )
                    Text(
                        text = time,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.86f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Right zone: status chip + supporting status text
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.widthIn(min = 102.dp, max = 130.dp)
            ) {
                StatusChip(
                    text = if (isTaken) {
                        tamnniString(Res.string.ar_status_taken, Res.string.en_status_taken)
                    } else {
                        tamnniString(Res.string.ar_status_upcoming, Res.string.en_status_upcoming)
                    },
                    isSuccess = isTaken
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = if (isTaken) {
                        tamnniString(Res.string.ar_medication_taken_compact, Res.string.en_medication_taken_compact)
                    } else {
                        tamnniString(Res.string.ar_medication_waiting_compact, Res.string.en_medication_waiting_compact)
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.82f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

