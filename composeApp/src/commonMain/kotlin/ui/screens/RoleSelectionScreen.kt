package ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_app_name
import tamnnicare.composeapp.generated.resources.ar_role_caregiver_desc
import tamnnicare.composeapp.generated.resources.ar_role_caregiver_title
import tamnnicare.composeapp.generated.resources.ar_role_selected
import tamnnicare.composeapp.generated.resources.ar_role_senior_desc
import tamnnicare.composeapp.generated.resources.ar_role_senior_title
import tamnnicare.composeapp.generated.resources.ar_role_subtitle
import tamnnicare.composeapp.generated.resources.ar_role_title
import tamnnicare.composeapp.generated.resources.en_app_name
import tamnnicare.composeapp.generated.resources.en_role_caregiver_desc
import tamnnicare.composeapp.generated.resources.en_role_caregiver_title
import tamnnicare.composeapp.generated.resources.en_role_selected
import tamnnicare.composeapp.generated.resources.en_role_senior_desc
import tamnnicare.composeapp.generated.resources.en_role_senior_title
import tamnnicare.composeapp.generated.resources.en_role_subtitle
import tamnnicare.composeapp.generated.resources.en_role_title
import tamnnicare.composeapp.generated.resources.tamnni_icon
import ui.i18n.tamnniString
import ui.state.UserRole
import ui.state.rememberRoleSelectionStateHolder

@Composable
fun RoleSelectionScreen(
    onSelectSenior: () -> Unit,
    onSelectCaregiver: () -> Unit
) {
    val stateHolder = rememberRoleSelectionStateHolder()
    val uiState by stateHolder.uiState.collectAsState()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    painter = painterResource(Res.drawable.tamnni_icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(14.dp)
                        .size(26.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = tamnniString(Res.string.ar_app_name, Res.string.en_app_name),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = tamnniString(Res.string.ar_role_title, Res.string.en_role_title),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = tamnniString(Res.string.ar_role_subtitle, Res.string.en_role_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(34.dp))

            uiState.options.forEachIndexed { index, option ->
                val (title, description) = if (option.role == UserRole.SENIOR) {
                    tamnniString(Res.string.ar_role_senior_title, Res.string.en_role_senior_title) to
                        tamnniString(Res.string.ar_role_senior_desc, Res.string.en_role_senior_desc)
                } else {
                    tamnniString(Res.string.ar_role_caregiver_title, Res.string.en_role_caregiver_title) to
                        tamnniString(Res.string.ar_role_caregiver_desc, Res.string.en_role_caregiver_desc)
                }

                RoleSelectionCard(
                    title = title,
                    description = description,
                    icon = if (option.role == UserRole.SENIOR) Icons.Default.Person else Icons.Default.Groups,
                    isSelected = uiState.selectedRole == option.role,
                    onClick = {
                        stateHolder.onSelectRole(option.role)
                        when (option.role) {
                            UserRole.SENIOR -> onSelectSenior()
                            UserRole.CAREGIVER -> onSelectCaregiver()
                        }
                    }
                )
                if (index < uiState.options.lastIndex) {
                    Spacer(modifier = Modifier.height(18.dp))
                }
            }
        }
    }
}

@Composable
fun RoleSelectionCard(
    title: String,
    description: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .height(156.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 3.dp else 1.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(alpha = 0.24f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(8.dp))
                if (isSelected) {
                    Text(
                        text = tamnniString(Res.string.ar_role_selected, Res.string.en_role_selected),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

