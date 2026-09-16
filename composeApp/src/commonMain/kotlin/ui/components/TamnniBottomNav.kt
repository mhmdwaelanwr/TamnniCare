package ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp

enum class BottomNavDestination {
    HOME,
    ALERTS,
    PROFILE
}

@Composable
fun TamnniBottomNav(
    selected: BottomNavDestination,
    homeLabel: String,
    alertsLabel: String,
    profileLabel: String,
    onHomeClick: () -> Unit,
    onAlertsClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 2.dp
    ) {
        NavigationBarItem(
            selected = selected == BottomNavDestination.HOME,
            onClick = onHomeClick,
            icon = { Icon(Icons.Default.Home, contentDescription = homeLabel, modifier = Modifier.size(22.dp)) },
            label = { Text(homeLabel) }
        )
        NavigationBarItem(
            selected = selected == BottomNavDestination.ALERTS,
            onClick = onAlertsClick,
            icon = { Icon(Icons.Default.Notifications, contentDescription = alertsLabel, modifier = Modifier.size(22.dp)) },
            label = { Text(alertsLabel) }
        )
        NavigationBarItem(
            selected = selected == BottomNavDestination.PROFILE,
            onClick = onProfileClick,
            icon = { Icon(Icons.Default.Person, contentDescription = profileLabel, modifier = Modifier.size(22.dp)) },
            label = { Text(profileLabel) }
        )
    }
}

