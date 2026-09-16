package ui.state

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.datetime.Clock

enum class DailyReassuranceStatus {
    NOT_REASSURED,
    REASSURED_TODAY,
    DELAYED,
    NEEDS_FOLLOW_UP
}

data class DailyReassuranceUiState(
    val status: DailyReassuranceStatus,
    val lastUpdateEpochMillis: Long?,
    val lastUpdateDisplay: String
)

interface DailyReassuranceStateSource {
    val uiState: StateFlow<DailyReassuranceUiState>
    fun confirmReassurance()
    fun refreshPolicy()
}

object InMemoryDailyReassuranceStateSource : DailyReassuranceStateSource {
    private val _uiState = MutableStateFlow(
        DailyReassuranceUiState(
            status = DailyReassuranceStatus.NOT_REASSURED,
            lastUpdateEpochMillis = null,
            lastUpdateDisplay = "لا يوجد تحديث بعد"
        )
    )

    override val uiState: StateFlow<DailyReassuranceUiState> = _uiState.asStateFlow()

    init {
        restoreFromLocalStoreAndRefresh()
    }

    override fun confirmReassurance() {
        val nowEpochMillis = Clock.System.now().toEpochMilliseconds()

        DailyReassuranceStore.saveLastUpdateEpochMillis(nowEpochMillis)
        _uiState.value = _uiState.value.copy(
            lastUpdateEpochMillis = nowEpochMillis
        )
        refreshPolicy()
    }

    override fun refreshPolicy() {
        val nowEpochMillis = Clock.System.now().toEpochMilliseconds()
        val lastUpdateEpochMillis = _uiState.value.lastUpdateEpochMillis

        val derivedStatus = deriveDailyReassuranceStatus(
            lastUpdateEpochMillis = lastUpdateEpochMillis,
            nowEpochMillis = nowEpochMillis
        )
        val derivedLastUpdateDisplay = deriveDailyReassuranceLastUpdateDisplay(
            lastUpdateEpochMillis = lastUpdateEpochMillis,
            status = derivedStatus,
            nowEpochMillis = nowEpochMillis,
            language = AppPreferencesStore.load().language
        )

        _uiState.value = _uiState.value.copy(
            status = derivedStatus,
            lastUpdateDisplay = derivedLastUpdateDisplay
        )
    }

    // Small shared restore entry point used by startup flow and integration tests.
    fun restoreFromLocalStoreAndRefresh() {
        restoreFromLocalStore()
        refreshPolicy()
    }

    private fun restoreFromLocalStore() {
        val restoredLastUpdate = DailyReassuranceStore.loadLastUpdateEpochMillis()
        _uiState.value = _uiState.value.copy(lastUpdateEpochMillis = restoredLastUpdate)
    }
}
