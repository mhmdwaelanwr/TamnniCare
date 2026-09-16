package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_about_body
import tamnnicare.composeapp.generated.resources.ar_about_section_subtitle
import tamnnicare.composeapp.generated.resources.ar_about_section_title
import tamnnicare.composeapp.generated.resources.ar_about_supporting
import tamnnicare.composeapp.generated.resources.ar_about_values_body
import tamnnicare.composeapp.generated.resources.ar_about_values_title
import tamnnicare.composeapp.generated.resources.ar_page_about
import tamnnicare.composeapp.generated.resources.en_about_body
import tamnnicare.composeapp.generated.resources.en_about_section_subtitle
import tamnnicare.composeapp.generated.resources.en_about_section_title
import tamnnicare.composeapp.generated.resources.en_about_supporting
import tamnnicare.composeapp.generated.resources.en_about_values_body
import tamnnicare.composeapp.generated.resources.en_about_values_title
import tamnnicare.composeapp.generated.resources.en_page_about
import ui.components.CalmSectionCard
import ui.components.SectionHeader
import ui.components.TamnniTopBar
import ui.i18n.tamnniString

@Composable
fun AboutScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TamnniTopBar(
                title = tamnniString(Res.string.ar_page_about, Res.string.en_page_about),
                onBackClick = onBack
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    title = tamnniString(Res.string.ar_about_section_title, Res.string.en_about_section_title),
                    subtitle = tamnniString(Res.string.ar_about_section_subtitle, Res.string.en_about_section_subtitle)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = tamnniString(Res.string.ar_about_body, Res.string.en_about_body),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = tamnniString(Res.string.ar_about_supporting, Res.string.en_about_supporting),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    title = tamnniString(Res.string.ar_about_values_title, Res.string.en_about_values_title),
                    subtitle = tamnniString(Res.string.ar_page_about, Res.string.en_page_about)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = tamnniString(Res.string.ar_about_values_body, Res.string.en_about_values_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

