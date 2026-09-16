package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_page_profile
import tamnnicare.composeapp.generated.resources.ar_profile_section_identity
import tamnnicare.composeapp.generated.resources.ar_profile_section_support
import tamnnicare.composeapp.generated.resources.ar_profile_id_label
import tamnnicare.composeapp.generated.resources.ar_profile_role_label
import tamnnicare.composeapp.generated.resources.ar_profile_trust_note
import tamnnicare.composeapp.generated.resources.en_page_profile
import tamnnicare.composeapp.generated.resources.en_profile_section_identity
import tamnnicare.composeapp.generated.resources.en_profile_section_support
import tamnnicare.composeapp.generated.resources.en_profile_id_label
import tamnnicare.composeapp.generated.resources.en_profile_role_label
import tamnnicare.composeapp.generated.resources.en_profile_trust_note
import tamnnicare.composeapp.generated.resources.ar_role_caregiver_title
import tamnnicare.composeapp.generated.resources.en_role_caregiver_title
import tamnnicare.composeapp.generated.resources.ar_role_senior_title
import tamnnicare.composeapp.generated.resources.en_role_senior_title
import ui.components.CalmSectionCard
import ui.components.SectionHeader
import ui.components.TamnniTopBar
import ui.i18n.tamnniString
import ui.state.UserRole

@Composable
fun ProfileScreen(
    role: UserRole?,
    onBack: () -> Unit
) {
    val roleLabel = when (role) {
        UserRole.SENIOR -> tamnniString(Res.string.ar_role_senior_title, Res.string.en_role_senior_title)
        UserRole.CAREGIVER -> tamnniString(Res.string.ar_role_caregiver_title, Res.string.en_role_caregiver_title)
        null -> "-"
    }

    Scaffold(
        topBar = {
            TamnniTopBar(
                title = tamnniString(Res.string.ar_page_profile, Res.string.en_page_profile),
                onBackClick = onBack
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Text(
                            text = "TC",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = tamnniString(Res.string.ar_page_profile, Res.string.en_page_profile),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                SectionHeader(
                    title = tamnniString(Res.string.ar_profile_section_identity, Res.string.en_profile_section_identity),
                    subtitle = roleLabel
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "${tamnniString(Res.string.ar_profile_role_label, Res.string.en_profile_role_label)}: $roleLabel",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "${tamnniString(Res.string.ar_profile_id_label, Res.string.en_profile_id_label)}: TC-2026-01",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            CalmSectionCard(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    title = tamnniString(Res.string.ar_profile_section_support, Res.string.en_profile_section_support),
                    subtitle = tamnniString(Res.string.ar_profile_trust_note, Res.string.en_profile_trust_note)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = tamnniString(Res.string.ar_profile_trust_note, Res.string.en_profile_trust_note),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

