package ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class CaregiverSummaryUi(
    val statusLabel: String,
    val mainState: String,
    val interpretation: String,
    val lastUpdate: String
)

data class CaregiverMedicationUi(
    val title: String,
    val name: String,
    val time: String,
    val isTaken: Boolean
)

data class CaregiverHomeUiState(
    val caregiverDisplayName: String,
    val trackedSeniorDisplayName: String,
    val reassuranceStatus: DailyReassuranceStatus,
    val topBarTitle: String,
    val trackedSeniorLabel: String,
    val summary: CaregiverSummaryUi,
    val alertsSectionTitle: String,
    val alertMessage: String,
    val alertIsAttention: Boolean,
    val medication: CaregiverMedicationUi
)

class CaregiverHomeStateHolder(
    displayProfileProvider: DisplayProfileProvider = InMemoryDisplayProfileProvider,
    reassuranceStateSource: DailyReassuranceStateSource = InMemoryDailyReassuranceStateSource
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val caregiverProfile = displayProfileProvider.caregiverProfile()
    private val medication = displayProfileProvider.caregiverMedicationSample()

    private val _uiState = MutableStateFlow(
        buildCaregiverUiState(
            caregiverProfile = caregiverProfile,
            medication = medication,
            reassurance = reassuranceStateSource.uiState.value
        )
    )
    val uiState: StateFlow<CaregiverHomeUiState> = _uiState.asStateFlow()

    init {
        reassuranceStateSource.refreshPolicy()
        scope.launch {
            reassuranceStateSource.uiState.collect { reassurance ->
                _uiState.value = buildUiState(reassurance)
            }
        }
    }

    fun onDetailsClick() {
        // Placeholder event hook for future details logic.
    }

    fun onCallClick() {
        // Placeholder event hook for future call integration.
    }

    fun onMessageClick() {
        // Placeholder event hook for future messaging integration.
    }

    private fun buildUiState(reassurance: DailyReassuranceUiState): CaregiverHomeUiState {
        return buildCaregiverUiState(
            caregiverProfile = caregiverProfile,
            medication = medication,
            reassurance = reassurance
        )
    }

    fun clear() {
        scope.cancel()
    }
}

@Composable
fun rememberCaregiverHomeStateHolder(
    displayProfileProvider: DisplayProfileProvider = InMemoryDisplayProfileProvider,
    reassuranceStateSource: DailyReassuranceStateSource = InMemoryDailyReassuranceStateSource
): CaregiverHomeStateHolder {
    val holder = remember(displayProfileProvider, reassuranceStateSource) {
        CaregiverHomeStateHolder(displayProfileProvider, reassuranceStateSource)
    }

    DisposableEffect(holder) {
        onDispose { holder.clear() }
    }

    return holder
}

fun defaultCaregiverHomeUiState(
    displayProfileProvider: DisplayProfileProvider = InMemoryDisplayProfileProvider,
    reassuranceStateSource: DailyReassuranceStateSource = InMemoryDailyReassuranceStateSource
): CaregiverHomeUiState {
    return buildCaregiverUiState(
        caregiverProfile = displayProfileProvider.caregiverProfile(),
        medication = displayProfileProvider.caregiverMedicationSample(),
        reassurance = reassuranceStateSource.uiState.value
    )
}

private fun buildCaregiverUiState(
    caregiverProfile: CaregiverProfileDisplayData,
    medication: MedicationDisplaySample,
    reassurance: DailyReassuranceUiState
): CaregiverHomeUiState {
    val summary = when (reassurance.status) {
        DailyReassuranceStatus.REASSURED_TODAY -> CaregiverSummaryUi(
            statusLabel = "حالة اليوم",
            mainState = "تم الاطمئنان اليوم",
            interpretation = "الأمور مطمئنة حتى الآن.",
            lastUpdate = reassurance.lastUpdateDisplay
        )

        DailyReassuranceStatus.NOT_REASSURED -> CaregiverSummaryUi(
            statusLabel = "حالة اليوم",
            mainState = "لم يصل الاطمئنان اليوم بعد",
            interpretation = "قد يفيد تواصل لطيف للاطمئنان.",
            lastUpdate = reassurance.lastUpdateDisplay
        )

        DailyReassuranceStatus.DELAYED -> CaregiverSummaryUi(
            statusLabel = "حالة اليوم",
            mainState = "تأخر الاطمئنان",
            interpretation = "يُفضّل الاطمئنان عليه قريبًا.",
            lastUpdate = reassurance.lastUpdateDisplay
        )

        DailyReassuranceStatus.NEEDS_FOLLOW_UP -> CaregiverSummaryUi(
            statusLabel = "حالة اليوم",
            mainState = "يحتاج متابعة",
            interpretation = "يُفضّل متابعة الحالة اليوم.",
            lastUpdate = reassurance.lastUpdateDisplay
        )
    }

    val alertMessage = when (reassurance.status) {
        DailyReassuranceStatus.REASSURED_TODAY -> "لا يوجد تنبيه يحتاج متابعة"
        DailyReassuranceStatus.NOT_REASSURED -> "لم يصل الاطمئنان اليوم بعد"
        DailyReassuranceStatus.DELAYED -> "يوجد تأخر في الاطمئنان"
        DailyReassuranceStatus.NEEDS_FOLLOW_UP -> "يحتاج متابعة للاطمئنان"
    }
    val alertIsAttention = reassurance.status == DailyReassuranceStatus.DELAYED ||
        reassurance.status == DailyReassuranceStatus.NEEDS_FOLLOW_UP

    return CaregiverHomeUiState(
        caregiverDisplayName = caregiverProfile.caregiverDisplayName,
        trackedSeniorDisplayName = caregiverProfile.trackedSeniorDisplayName,
        reassuranceStatus = reassurance.status,
        topBarTitle = "مرحبًا يا ${caregiverProfile.caregiverDisplayName}",
        trackedSeniorLabel = "متابعة: ${caregiverProfile.trackedSeniorDisplayName}",
        summary = summary,
        alertsSectionTitle = "التنبيهات",
        alertMessage = alertMessage,
        alertIsAttention = alertIsAttention,
        medication = CaregiverMedicationUi(
            title = medication.title,
            name = medication.name,
            time = medication.time,
            isTaken = medication.isTaken
        )
    )
}
