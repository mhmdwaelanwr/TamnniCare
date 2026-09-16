package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_app_name
import tamnnicare.composeapp.generated.resources.en_app_name
import tamnnicare.composeapp.generated.resources.ar_splash_subtitle
import tamnnicare.composeapp.generated.resources.en_splash_subtitle
import tamnnicare.composeapp.generated.resources.tamnni_icon
import ui.i18n.tamnniString

private const val SPLASH_DELAY_MS = 900L

@Composable
fun SplashScreen(
    onSplashComplete: () -> Unit
) {
    var didAutoAdvance by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (!didAutoAdvance) {
            didAutoAdvance = true
            delay(SPLASH_DELAY_MS)
            onSplashComplete()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 36.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(88.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.tamnni_icon),
                        contentDescription = null,
                        modifier = Modifier.size(56.dp),
                        tint = Color.Unspecified
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
                Text(
                    text = tamnniString(Res.string.ar_app_name, Res.string.en_app_name),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = tamnniString(Res.string.ar_splash_subtitle, Res.string.en_splash_subtitle),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
            }
        }
    }
}

