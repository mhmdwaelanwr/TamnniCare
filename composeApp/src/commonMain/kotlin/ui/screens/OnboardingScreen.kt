package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import tamnnicare.composeapp.generated.resources.Res
import tamnnicare.composeapp.generated.resources.ar_app_name
import tamnnicare.composeapp.generated.resources.ar_get_started
import tamnnicare.composeapp.generated.resources.ar_next
import tamnnicare.composeapp.generated.resources.ar_onboarding_highlight_1
import tamnnicare.composeapp.generated.resources.ar_onboarding_highlight_2
import tamnnicare.composeapp.generated.resources.ar_onboarding_highlight_3
import tamnnicare.composeapp.generated.resources.ar_onboarding_subtitle_1
import tamnnicare.composeapp.generated.resources.ar_onboarding_subtitle_2
import tamnnicare.composeapp.generated.resources.ar_onboarding_subtitle_3
import tamnnicare.composeapp.generated.resources.ar_onboarding_tagline
import tamnnicare.composeapp.generated.resources.ar_onboarding_title_1
import tamnnicare.composeapp.generated.resources.ar_onboarding_title_2
import tamnnicare.composeapp.generated.resources.ar_onboarding_title_3
import tamnnicare.composeapp.generated.resources.ar_skip
import tamnnicare.composeapp.generated.resources.en_app_name
import tamnnicare.composeapp.generated.resources.en_get_started
import tamnnicare.composeapp.generated.resources.en_next
import tamnnicare.composeapp.generated.resources.en_onboarding_highlight_1
import tamnnicare.composeapp.generated.resources.en_onboarding_highlight_2
import tamnnicare.composeapp.generated.resources.en_onboarding_highlight_3
import tamnnicare.composeapp.generated.resources.en_onboarding_subtitle_1
import tamnnicare.composeapp.generated.resources.en_onboarding_subtitle_2
import tamnnicare.composeapp.generated.resources.en_onboarding_subtitle_3
import tamnnicare.composeapp.generated.resources.en_onboarding_tagline
import tamnnicare.composeapp.generated.resources.en_onboarding_title_1
import tamnnicare.composeapp.generated.resources.en_onboarding_title_2
import tamnnicare.composeapp.generated.resources.en_onboarding_title_3
import tamnnicare.composeapp.generated.resources.en_skip
import tamnnicare.composeapp.generated.resources.tamnni_icon
import ui.components.PrimaryButton
import ui.components.SecondaryButton
import ui.i18n.tamnniString
import ui.state.rememberOnboardingStateHolder

@Composable
fun OnboardingScreen(
    onFinishOnboarding: () -> Unit
) {
    val stateHolder = rememberOnboardingStateHolder()
    val uiState by stateHolder.uiState.collectAsState()

    Scaffold(
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                PrimaryButton(
                    text = if (uiState.isLastSlide) {
                        tamnniString(Res.string.ar_get_started, Res.string.en_get_started)
                    } else {
                        tamnniString(Res.string.ar_next, Res.string.en_next)
                    },
                    onClick = {
                        if (stateHolder.onNext()) {
                            onFinishOnboarding()
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                if (!uiState.isLastSlide) {
                    SecondaryButton(
                        text = tamnniString(Res.string.ar_skip, Res.string.en_skip),
                        onClick = {
                            if (stateHolder.onSkip()) {
                                onFinishOnboarding()
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OnboardingHeroVisual(
                currentSlideIndex = uiState.currentSlideIndex,
                slideCount = uiState.slides.size,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = localizedOnboardingTitle(uiState.currentSlideIndex),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = localizedOnboardingSubtitle(uiState.currentSlideIndex),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "${uiState.currentSlideIndex + 1}/${uiState.slides.size}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun OnboardingHeroVisual(
    currentSlideIndex: Int,
    slideCount: Int,
    modifier: Modifier = Modifier
) {
    val (highlightText, icon) = when (currentSlideIndex) {
        0 -> tamnniString(Res.string.ar_onboarding_highlight_1, Res.string.en_onboarding_highlight_1) to Icons.Default.Favorite
        1 -> tamnniString(Res.string.ar_onboarding_highlight_2, Res.string.en_onboarding_highlight_2) to Icons.Default.Medication
        else -> tamnniString(Res.string.ar_onboarding_highlight_3, Res.string.en_onboarding_highlight_3) to Icons.Default.NotificationsActive
    }

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.35f)
            ) {
                Text(
                    text = highlightText,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            OnboardingBrandAndIcon(icon = icon)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = tamnniString(Res.string.ar_onboarding_tagline, Res.string.en_onboarding_tagline),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(slideCount) { index ->
                    val isSelected = index == currentSlideIndex
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(width = if (isSelected) 22.dp else 8.dp, height = 8.dp)
                            .clip(CircleShape)
                            .background(
                                if (isSelected) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.32f)
                            )
                    )
                }
            }
        }
    }
}

@Composable
private fun OnboardingBrandAndIcon(icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 1.dp
        ) {
            Icon(
                painter = painterResource(Res.drawable.tamnni_icon),
                contentDescription = null,
                modifier = Modifier.padding(10.dp).size(22.dp),
                tint = Color.Unspecified
            )
        }

        Text(
            text = tamnniString(Res.string.ar_app_name, Res.string.en_app_name),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(28.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun localizedOnboardingTitle(index: Int): String {
    return when (index) {
        0 -> tamnniString(Res.string.ar_onboarding_title_1, Res.string.en_onboarding_title_1)
        1 -> tamnniString(Res.string.ar_onboarding_title_2, Res.string.en_onboarding_title_2)
        else -> tamnniString(Res.string.ar_onboarding_title_3, Res.string.en_onboarding_title_3)
    }
}

@Composable
private fun localizedOnboardingSubtitle(index: Int): String {
    return when (index) {
        0 -> tamnniString(Res.string.ar_onboarding_subtitle_1, Res.string.en_onboarding_subtitle_1)
        1 -> tamnniString(Res.string.ar_onboarding_subtitle_2, Res.string.en_onboarding_subtitle_2)
        else -> tamnniString(Res.string.ar_onboarding_subtitle_3, Res.string.en_onboarding_subtitle_3)
    }
}

