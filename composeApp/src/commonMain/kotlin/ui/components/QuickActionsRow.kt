package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_call
import tamnnicare.composeapp.generated.resources.ar_message
import tamnnicare.composeapp.generated.resources.en_call
import tamnnicare.composeapp.generated.resources.en_message
import ui.i18n.tamnniString

@Composable
fun QuickActionsRow(
    onCallClick: () -> Unit,
    onMessageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = onCallClick,
            modifier = Modifier.weight(1f).height(56.dp),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(Icons.Default.Call, contentDescription = null, modifier = Modifier.size(18.dp))
                Text(
                    tamnniString(Res.string.ar_call, Res.string.en_call),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
        Button(
            onClick = onMessageClick,
            modifier = Modifier.weight(1f).height(56.dp),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.Message, contentDescription = null, modifier = Modifier.size(18.dp))
                Text(
                    tamnniString(Res.string.ar_message, Res.string.en_message),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

