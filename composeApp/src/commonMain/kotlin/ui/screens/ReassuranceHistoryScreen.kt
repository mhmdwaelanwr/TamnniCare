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
import tamnnicare.composeapp.generated.resources.ar_empty_history
import tamnnicare.composeapp.generated.resources.ar_history_item_today
import tamnnicare.composeapp.generated.resources.ar_history_item_two_days
import tamnnicare.composeapp.generated.resources.ar_history_item_time_today
import tamnnicare.composeapp.generated.resources.ar_history_item_time_two_days
import tamnnicare.composeapp.generated.resources.ar_history_item_time_yesterday
import tamnnicare.composeapp.generated.resources.ar_history_item_today_support
import tamnnicare.composeapp.generated.resources.ar_history_item_two_days_support
import tamnnicare.composeapp.generated.resources.ar_history_item_yesterday_support
import tamnnicare.composeapp.generated.resources.ar_history_item_yesterday
import tamnnicare.composeapp.generated.resources.ar_page_history
import tamnnicare.composeapp.generated.resources.ar_history_entry_label
import tamnnicare.composeapp.generated.resources.ar_history_section_subtitle
import tamnnicare.composeapp.generated.resources.en_empty_history
import tamnnicare.composeapp.generated.resources.en_history_entry_label
import tamnnicare.composeapp.generated.resources.en_history_item_today
import tamnnicare.composeapp.generated.resources.en_history_item_two_days
import tamnnicare.composeapp.generated.resources.en_history_item_time_today
import tamnnicare.composeapp.generated.resources.en_history_item_time_two_days
import tamnnicare.composeapp.generated.resources.en_history_item_time_yesterday
import tamnnicare.composeapp.generated.resources.en_history_item_today_support
import tamnnicare.composeapp.generated.resources.en_history_item_two_days_support
import tamnnicare.composeapp.generated.resources.en_history_item_yesterday_support
import tamnnicare.composeapp.generated.resources.en_history_item_yesterday
import tamnnicare.composeapp.generated.resources.en_page_history
import tamnnicare.composeapp.generated.resources.en_history_section_subtitle
import ui.components.CalmSectionCard
import ui.components.SectionHeader
import ui.components.StatusChip
import ui.components.TamnniTopBar
import ui.i18n.tamnniString

@Composable
fun ReassuranceHistoryScreen(
    onBack: () -> Unit
) {
    data class HistoryRowUi(
        val title: String,
        val support: String,
        val time: String,
        val isPositive: Boolean
    )

    val items = listOf(
        HistoryRowUi(
            title = tamnniString(Res.string.ar_history_item_today, Res.string.en_history_item_today),
            support = tamnniString(Res.string.ar_history_item_today_support, Res.string.en_history_item_today_support),
            time = tamnniString(Res.string.ar_history_item_time_today, Res.string.en_history_item_time_today),
            isPositive = true
        ),
        HistoryRowUi(
            title = tamnniString(Res.string.ar_history_item_yesterday, Res.string.en_history_item_yesterday),
            support = tamnniString(Res.string.ar_history_item_yesterday_support, Res.string.en_history_item_yesterday_support),
            time = tamnniString(Res.string.ar_history_item_time_yesterday, Res.string.en_history_item_time_yesterday),
            isPositive = false
        ),
        HistoryRowUi(
            title = tamnniString(Res.string.ar_history_item_two_days, Res.string.en_history_item_two_days),
            support = tamnniString(Res.string.ar_history_item_two_days_support, Res.string.en_history_item_two_days_support),
            time = tamnniString(Res.string.ar_history_item_time_two_days, Res.string.en_history_item_time_two_days),
            isPositive = false
        )
    )

    Scaffold(
        topBar = {
            TamnniTopBar(
                title = tamnniString(Res.string.ar_page_history, Res.string.en_page_history),
                onBackClick = onBack
            )
        }
    ) { padding ->
        if (items.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = tamnniString(Res.string.ar_empty_history, Res.string.en_empty_history),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    SectionHeader(
                        title = tamnniString(Res.string.ar_page_history, Res.string.en_page_history),
                        subtitle = tamnniString(Res.string.ar_history_section_subtitle, Res.string.en_history_section_subtitle)
                    )
                }
                items(items) { entry ->
                    CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = tamnniString(Res.string.ar_history_entry_label, Res.string.en_history_entry_label),
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = entry.title,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = entry.support,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = entry.time,
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                                )
                            }
                            StatusChip(
                                text = if (entry.isPositive) "✓" else "!",
                                isSuccess = entry.isPositive
                            )
                        }
                    }
                }
            }
        }
    }
}

