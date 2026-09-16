package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

data class QuickLinkAction(
    val label: String,
    val onClick: () -> Unit
)

@Composable
fun QuickLinksCard(
    title: String,
    subtitle: String,
    first: QuickLinkAction,
    second: QuickLinkAction,
    third: QuickLinkAction,
    modifier: Modifier = Modifier
) {
    val actions = listOf(first, second, third)

    CalmSectionCard(modifier = modifier) {
        SectionHeader(
            title = title,
            subtitle = subtitle
        )
        QuickLinksFlow(
            actions = actions,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun QuickLinksFlow(
    actions: List<QuickLinkAction>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        maxItemsInEachRow = 2
    ) {
        actions.forEach { action ->
            AssistChip(
                onClick = action.onClick,
                label = {
                    Text(
                        text = action.label,
                        style = MaterialTheme.typography.labelMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    labelColor = MaterialTheme.colorScheme.primary,
                    leadingIconContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

