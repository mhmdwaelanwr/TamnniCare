package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_med_name_pressure
import tamnnicare.composeapp.generated.resources.ar_med_name_vitamin_d
import tamnnicare.composeapp.generated.resources.ar_medication_section_subtitle
import tamnnicare.composeapp.generated.resources.ar_page_medications
import tamnnicare.composeapp.generated.resources.ar_time_evening_6
import tamnnicare.composeapp.generated.resources.ar_time_morning_9
import tamnnicare.composeapp.generated.resources.en_med_name_pressure
import tamnnicare.composeapp.generated.resources.en_med_name_vitamin_d
import tamnnicare.composeapp.generated.resources.en_medication_section_subtitle
import tamnnicare.composeapp.generated.resources.en_page_medications
import tamnnicare.composeapp.generated.resources.en_time_evening_6
import tamnnicare.composeapp.generated.resources.en_time_morning_9
import ui.components.MedicationPreviewCard
import ui.components.SectionHeader
import ui.components.TamnniTopBar
import ui.i18n.tamnniString

@Composable
fun MedicationOverviewScreen(
    onBack: () -> Unit
) {
    val medications = listOf(
        Triple(
            tamnniString(Res.string.ar_med_name_pressure, Res.string.en_med_name_pressure),
            tamnniString(Res.string.ar_time_morning_9, Res.string.en_time_morning_9),
            false
        ),
        Triple(
            tamnniString(Res.string.ar_med_name_vitamin_d, Res.string.en_med_name_vitamin_d),
            tamnniString(Res.string.ar_time_evening_6, Res.string.en_time_evening_6),
            true
        )
    )

    Scaffold(
        topBar = {
            TamnniTopBar(
                title = tamnniString(Res.string.ar_page_medications, Res.string.en_page_medications),
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
                    title = tamnniString(Res.string.ar_page_medications, Res.string.en_page_medications),
                    subtitle = tamnniString(Res.string.ar_medication_section_subtitle, Res.string.en_medication_section_subtitle)
                )
            }
            items(medications) { entry ->
                MedicationPreviewCard(
                    medicationName = entry.first,
                    time = entry.second,
                    isTaken = entry.third
                )
            }
        }
    }
}

