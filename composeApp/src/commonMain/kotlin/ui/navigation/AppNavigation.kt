package ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.screens.AboutScreen
import ui.screens.AlertsListScreen
import ui.screens.CaregiverHomeScreen
import ui.screens.MedicationOverviewScreen
import ui.screens.OnboardingScreen
import ui.screens.ProfileScreen
import ui.screens.ReassuranceHistoryScreen
import ui.screens.RoleSelectionScreen
import ui.screens.SettingsScreen
import ui.screens.SeniorHomeScreen
import ui.screens.SplashScreen
import ui.state.AppAppearance
import ui.state.AppLanguage
import ui.state.AppStateStore
import ui.state.DailyReassuranceRefreshIntent
import ui.state.UserRole

object Routes {
    const val SPLASH = "splash"
    const val ONBOARDING = "onboarding"
    const val ROLE_SELECTION = "role_selection"
    const val SENIOR_HOME = "senior_home"
    const val CAREGIVER_HOME = "caregiver_home"
    const val SETTINGS = "settings"
    const val PROFILE = "profile"
    const val HISTORY = "history"
    const val ALERTS = "alerts"
    const val MEDICATIONS = "medications"
    const val ABOUT = "about"
}

@Composable
fun AppNavigation(
    appLanguage: AppLanguage,
    appAppearance: AppAppearance,
    onLanguageSelected: (AppLanguage) -> Unit,
    onAppearanceSelected: (AppAppearance) -> Unit
) {
    val navController = rememberNavController()
    var persistedState by remember { mutableStateOf(AppStateStore.loadState()) }
    var splashRouteHandled by rememberSaveable { mutableStateOf(false) }

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onSplashComplete = {
                    if (splashRouteHandled) return@SplashScreen

                    splashRouteHandled = true
                    DailyReassuranceRefreshIntent.onAppBecameActive()
                    persistedState = AppStateStore.loadState()
                    val startupRoute = resolveStartupRoute(persistedState)
                    navController.navigate(startupRoute) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.ONBOARDING) {
            OnboardingScreen(
                onFinishOnboarding = {
                    AppStateStore.saveOnboardingCompleted(completed = true)
                    persistedState = AppStateStore.loadState()
                    navController.navigate(Routes.ROLE_SELECTION) {
                        popUpTo(Routes.ONBOARDING) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.ROLE_SELECTION) {
            RoleSelectionScreen(
                onSelectSenior = {
                    AppStateStore.saveOnboardingCompleted(completed = true)
                    AppStateStore.saveSelectedRole(UserRole.SENIOR)
                    persistedState = AppStateStore.loadState()
                    navController.navigate(Routes.SENIOR_HOME) {
                        popUpTo(Routes.ROLE_SELECTION) { inclusive = true }
                    }
                },
                onSelectCaregiver = {
                    AppStateStore.saveOnboardingCompleted(completed = true)
                    AppStateStore.saveSelectedRole(UserRole.CAREGIVER)
                    persistedState = AppStateStore.loadState()
                    navController.navigate(Routes.CAREGIVER_HOME) {
                        popUpTo(Routes.ROLE_SELECTION) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.SENIOR_HOME) {
            SeniorHomeScreen(
                onHelpRequested = {
                    // TODO: Help request bottom sheet or alert dialog
                },
                onOpenSettings = { navController.navigate(Routes.SETTINGS) },
                onOpenProfile = { navController.navigate(Routes.PROFILE) },
                onOpenHistory = { navController.navigate(Routes.HISTORY) },
                onOpenMedications = { navController.navigate(Routes.MEDICATIONS) }
            )
        }

        composable(Routes.CAREGIVER_HOME) {
            CaregiverHomeScreen(
                onOpenSettings = { navController.navigate(Routes.SETTINGS) },
                onOpenAlerts = { navController.navigate(Routes.ALERTS) },
                onOpenProfile = { navController.navigate(Routes.PROFILE) },
                onOpenHome = {
                    navController.navigate(Routes.CAREGIVER_HOME) {
                        launchSingleTop = true
                    }
                },
                onOpenHistory = { navController.navigate(Routes.HISTORY) },
                onOpenMedications = { navController.navigate(Routes.MEDICATIONS) }
            )
        }

        composable(Routes.SETTINGS) {
            SettingsScreen(
                appLanguage = appLanguage,
                appAppearance = appAppearance,
                onLanguageSelected = onLanguageSelected,
                onAppearanceSelected = onAppearanceSelected,
                onOpenProfile = { navController.navigate(Routes.PROFILE) },
                onOpenHistory = { navController.navigate(Routes.HISTORY) },
                onOpenAlerts = { navController.navigate(Routes.ALERTS) },
                onOpenMedications = { navController.navigate(Routes.MEDICATIONS) },
                onOpenAbout = { navController.navigate(Routes.ABOUT) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.PROFILE) {
            ProfileScreen(
                role = persistedState.selectedRole,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.HISTORY) {
            ReassuranceHistoryScreen(onBack = { navController.popBackStack() })
        }

        composable(Routes.ALERTS) {
            AlertsListScreen(onBack = { navController.popBackStack() })
        }

        composable(Routes.MEDICATIONS) {
            MedicationOverviewScreen(onBack = { navController.popBackStack() })
        }

        composable(Routes.ABOUT) {
            AboutScreen(onBack = { navController.popBackStack() })
        }
    }
}
