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

data class SeniorMedicationUi(
    val name: String,
    val time: String,
    val isTaken: Boolean
)

data class SeniorHelpUi(
    val isRequested: Boolean,
    val buttonLabel: String,
    val supportingText: String,
    val resetLabel: String?
)

data class SeniorHomeUiState(
    val seniorDisplayName: String,
    val greeting: String,
    val reassuranceStatus: DailyReassuranceStatus,
    val isReassuredToday: Boolean,
    val lastUpdateLabel: String,
    val medication: SeniorMedicationUi,
    val help: SeniorHelpUi
)

class SeniorHomeStateHolder(
    displayProfileProvider: DisplayProfileProvider = InMemoryDisplayProfileProvider,
    reassuranceStateSource: DailyReassuranceStateSource = InMemoryDailyReassuranceStateSource
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val reassuranceSource = reassuranceStateSource
    private val seniorProfile = displayProfileProvider.seniorProfile()
    private val medication = displayProfileProvider.seniorMedicationSample()
    private var isHelpRequested = false

    private val _uiState = MutableStateFlow(
        buildUiState(
            reassurance = reassuranceSource.uiState.value,
            isHelpRequested = isHelpRequested
        )
    )
    val uiState: StateFlow<SeniorHomeUiState> = _uiState.asStateFlow()

    init {
        reassuranceSource.refreshPolicy()
        scope.launch {
            reassuranceSource.uiState.collect { reassurance ->
                _uiState.value = buildUiState(
                    reassurance = reassurance,
                    isHelpRequested = isHelpRequested
                )
            }
        }
    }

    fun onConfirmReassurance() {
        reassuranceSource.confirmReassurance()
        _uiState.value = buildUiState(
            reassurance = reassuranceSource.uiState.value,
            isHelpRequested = isHelpRequested
        )
    }

    fun onHelpClick(): Boolean {
        if (isHelpRequested) return false

        isHelpRequested = true
        _uiState.value = buildUiState(
            reassurance = reassuranceSource.uiState.value,
            isHelpRequested = isHelpRequested
        )
        return true
    }

    fun onClearHelpRequest() {
        if (!isHelpRequested) return

        isHelpRequested = false
        _uiState.value = buildUiState(
            reassurance = reassuranceSource.uiState.value,
            isHelpRequested = isHelpRequested
        )
    }

    private fun buildUiState(
        reassurance: DailyReassuranceUiState,
        isHelpRequested: Boolean
    ): SeniorHomeUiState {
        val helpUi = if (isHelpRequested) {
            SeniorHelpUi(
                isRequested = true,
                buttonLabel = "تم طلب المساعدة",
                supportingText = "تم تسجيل طلبك، وسنقوم بإشعار من يهتم بك عند التفعيل.",
                resetLabel = "إلغاء الطلب"
            )
        } else {
            SeniorHelpUi(
                isRequested = false,
                buttonLabel = "طلب مساعدة",
                supportingText = "إذا احتجت مساعدة، يمكنك إرسال طلب الآن.",
                resetLabel = null
            )
        }

        return SeniorHomeUiState(
            seniorDisplayName = seniorProfile.seniorDisplayName,
            greeting = "${seniorProfile.greetingPrefix} ${seniorProfile.seniorDisplayName}",
            reassuranceStatus = reassurance.status,
            isReassuredToday = reassurance.status == DailyReassuranceStatus.REASSURED_TODAY,
            lastUpdateLabel = reassurance.lastUpdateDisplay,
            medication = SeniorMedicationUi(
                name = medication.name,
                time = medication.time,
                isTaken = medication.isTaken
            ),
            help = helpUi
        )
    }

    fun clear() {
        scope.cancel()
    }
}

@Composable
fun rememberSeniorHomeStateHolder(
    displayProfileProvider: DisplayProfileProvider = InMemoryDisplayProfileProvider,
    reassuranceStateSource: DailyReassuranceStateSource = InMemoryDailyReassuranceStateSource
): SeniorHomeStateHolder {
    val holder = remember(displayProfileProvider, reassuranceStateSource) {
        SeniorHomeStateHolder(displayProfileProvider, reassuranceStateSource)
    }

    DisposableEffect(holder) {
        onDispose { holder.clear() }
    }

    return holder
}

fun defaultSeniorHomeUiState(
    displayProfileProvider: DisplayProfileProvider = InMemoryDisplayProfileProvider,
    reassuranceStateSource: DailyReassuranceStateSource = InMemoryDailyReassuranceStateSource
): SeniorHomeUiState {
    val seniorProfile = displayProfileProvider.seniorProfile()
    val medication = displayProfileProvider.seniorMedicationSample()
    val reassurance = reassuranceStateSource.uiState.value

    return SeniorHomeUiState(
        seniorDisplayName = seniorProfile.seniorDisplayName,
        greeting = "${seniorProfile.greetingPrefix} ${seniorProfile.seniorDisplayName}",
        reassuranceStatus = reassurance.status,
        isReassuredToday = reassurance.status == DailyReassuranceStatus.REASSURED_TODAY,
        lastUpdateLabel = reassurance.lastUpdateDisplay,
        medication = SeniorMedicationUi(
            name = medication.name,
            time = medication.time,
            isTaken = medication.isTaken
        ),
        help = SeniorHelpUi(
            isRequested = false,
            buttonLabel = "طلب مساعدة",
            supportingText = "إذا احتجت مساعدة، يمكنك إرسال طلب الآن.",
            resetLabel = null
        )
    )
}
