package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_alert_item_delayed
import tamnnicare.composeapp.generated.resources.ar_alert_item_pending
import tamnnicare.composeapp.generated.resources.ar_alert_entry_label
import tamnnicare.composeapp.generated.resources.ar_alert_item_delayed_support
import tamnnicare.composeapp.generated.resources.ar_alert_item_pending_support
import tamnnicare.composeapp.generated.resources.ar_alert_item_time_earlier
import tamnnicare.composeapp.generated.resources.ar_alert_item_time_recent
import tamnnicare.composeapp.generated.resources.ar_alerts_section_subtitle
import tamnnicare.composeapp.generated.resources.ar_alerts_title
import tamnnicare.composeapp.generated.resources.en_alert_item_delayed
import tamnnicare.composeapp.generated.resources.en_alert_item_pending
import tamnnicare.composeapp.generated.resources.en_alert_entry_label
import tamnnicare.composeapp.generated.resources.en_alert_item_delayed_support
import tamnnicare.composeapp.generated.resources.en_alert_item_pending_support
import tamnnicare.composeapp.generated.resources.en_alert_item_time_earlier
import tamnnicare.composeapp.generated.resources.en_alert_item_time_recent
import tamnnicare.composeapp.generated.resources.en_alerts_section_subtitle
import tamnnicare.composeapp.generated.resources.en_alerts_title
import ui.components.CalmSectionCard
import ui.components.SectionHeader
import ui.components.StatusChip
import ui.components.TamnniTopBar
import ui.i18n.tamnniString

@Composable
fun AlertsListScreen(
    onBack: () -> Unit
) {
    data class AlertRowUi(
        val title: String,
        val support: String,
        val time: String,
        val isCalm: Boolean
    )

    val alerts = listOf(
        AlertRowUi(
            title = tamnniString(Res.string.ar_alert_item_pending, Res.string.en_alert_item_pending),
            support = tamnniString(Res.string.ar_alert_item_pending_support, Res.string.en_alert_item_pending_support),
            time = tamnniString(Res.string.ar_alert_item_time_recent, Res.string.en_alert_item_time_recent),
            isCalm = false
        ),
        AlertRowUi(
            title = tamnniString(Res.string.ar_alert_item_delayed, Res.string.en_alert_item_delayed),
            support = tamnniString(Res.string.ar_alert_item_delayed_support, Res.string.en_alert_item_delayed_support),
            time = tamnniString(Res.string.ar_alert_item_time_earlier, Res.string.en_alert_item_time_earlier),
            isCalm = false
        )
    )

    Scaffold(
        topBar = {
            TamnniTopBar(
                title = tamnniString(Res.string.ar_alerts_title, Res.string.en_alerts_title),
                onBackClick = onBack
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                SectionHeader(
                    title = tamnniString(Res.string.ar_alerts_title, Res.string.en_alerts_title),
                    subtitle = tamnniString(Res.string.ar_alerts_section_subtitle, Res.string.en_alerts_section_subtitle)
                )
            }
            items(alerts) { alert ->
                CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = tamnniString(Res.string.ar_alert_entry_label, Res.string.en_alert_entry_label),
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = alert.title,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = alert.support,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = alert.time,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                            )
                        }
                        StatusChip(text = "!", isSuccess = alert.isCalm)
                    }
                }
            }
        }
    }
}

