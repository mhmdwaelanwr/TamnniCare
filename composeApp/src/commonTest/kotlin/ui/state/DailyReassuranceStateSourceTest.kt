package ui.state

import kotlinx.datetime.Clock
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class DailyReassuranceStateSourceTest {

    @AfterTest
    fun tearDown() {
        // Keep tests isolated from each other and from local dev runs.
        DailyReassuranceStore.clearForTesting()
        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()
    }

    @Test
    fun noStoredTimestamp_derivesNotReassured() {
        DailyReassuranceStore.clearForTesting()

        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()
        val state = InMemoryDailyReassuranceStateSource.uiState.value

        assertEquals(DailyReassuranceStatus.NOT_REASSURED, state.status)
        assertEquals(null, state.lastUpdateEpochMillis)
        assertEquals("لا يوجد تحديث بعد", state.lastUpdateDisplay)
    }

    @Test
    fun restoredTimestamp_refreshPolicy_derivesExpectedStatus() {
        val now = Clock.System.now().toEpochMilliseconds()
        val oldTimestamp = now - (3L * 24L * 60L * 60L * 1000L)
        DailyReassuranceStore.saveLastUpdateEpochMillis(oldTimestamp)

        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()
        val state = InMemoryDailyReassuranceStateSource.uiState.value

        assertEquals(oldTimestamp, state.lastUpdateEpochMillis)
        assertEquals(DailyReassuranceStatus.NEEDS_FOLLOW_UP, state.status)
        assertTrue(state.lastUpdateDisplay == "منذ يومين" || state.lastUpdateDisplay == "منذ عدة أيام")
    }

    @Test
    fun confirmReassurance_updatesTimestamp_andDerivesReassuredToday() {
        DailyReassuranceStore.clearForTesting()
        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()

        InMemoryDailyReassuranceStateSource.confirmReassurance()
        val state = InMemoryDailyReassuranceStateSource.uiState.value

        assertEquals(DailyReassuranceStatus.REASSURED_TODAY, state.status)
        assertTrue(state.lastUpdateDisplay == "الآن" || state.lastUpdateDisplay == "اليوم")
        assertNotNull(state.lastUpdateEpochMillis)
        assertEquals(state.lastUpdateEpochMillis, DailyReassuranceStore.loadLastUpdateEpochMillis())
    }
}
