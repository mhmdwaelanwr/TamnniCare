package ui.state

import kotlinx.datetime.Clock
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DailyReassuranceRefreshIntentTest {

    @AfterTest
    fun tearDown() {
        DailyReassuranceStore.clearForTesting()
        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()
    }

    @Test
    fun staleStoredTimestamp_onAppBecameActive_derivesStaleStatus() {
        val now = Clock.System.now().toEpochMilliseconds()
        val oldTimestamp = now - (3L * 24L * 60L * 60L * 1000L)
        DailyReassuranceStore.saveLastUpdateEpochMillis(oldTimestamp)

        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()
        DailyReassuranceRefreshIntent.onAppBecameActive()

        val state = InMemoryDailyReassuranceStateSource.uiState.value
        assertEquals(oldTimestamp, state.lastUpdateEpochMillis)
        assertEquals(DailyReassuranceStatus.NEEDS_FOLLOW_UP, state.status)
        assertTrue(state.lastUpdateDisplay == "منذ يومين" || state.lastUpdateDisplay == "منذ عدة أيام")
    }

    @Test
    fun noStoredTimestamp_onAppBecameActive_keepsNotReassured() {
        DailyReassuranceStore.clearForTesting()
        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()

        DailyReassuranceRefreshIntent.onAppBecameActive()

        val state = InMemoryDailyReassuranceStateSource.uiState.value
        assertEquals(null, state.lastUpdateEpochMillis)
        assertEquals(DailyReassuranceStatus.NOT_REASSURED, state.status)
        assertEquals("لا يوجد تحديث بعد", state.lastUpdateDisplay)
    }
}

