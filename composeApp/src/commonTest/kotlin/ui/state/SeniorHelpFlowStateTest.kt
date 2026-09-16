package ui.state

import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class SeniorHelpFlowStateTest {

    @AfterTest
    fun tearDown() {
        DailyReassuranceStore.clearForTesting()
        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()
    }

    @Test
    fun initialState_isIdleWithExpectedHelpCopy() {
        DailyReassuranceStore.clearForTesting()
        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()

        val holder = SeniorHomeStateHolder()
        try {
            val state = holder.uiState.value

            assertFalse(state.help.isRequested)
            assertEquals("طلب مساعدة", state.help.buttonLabel)
            assertEquals("إذا احتجت مساعدة، يمكنك إرسال طلب الآن.", state.help.supportingText)
            assertNull(state.help.resetLabel)
        } finally {
            holder.clear()
        }
    }

    @Test
    fun helpClick_repeatNoOp_clear_returnsIdle_andReassuranceUnchanged() {
        DailyReassuranceStore.clearForTesting()
        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()

        val holder = SeniorHomeStateHolder()
        try {
            val initial = holder.uiState.value
            val initialReassured = initial.isReassuredToday
            val initialLastUpdate = initial.lastUpdateLabel

            val firstResult = holder.onHelpClick()
            val afterFirst = holder.uiState.value
            assertTrue(firstResult)
            assertTrue(afterFirst.help.isRequested)
            assertEquals("تم طلب المساعدة", afterFirst.help.buttonLabel)
            assertEquals("تم تسجيل طلبك، وسنقوم بإشعار من يهتم بك عند التفعيل.", afterFirst.help.supportingText)
            assertEquals("إلغاء الطلب", afterFirst.help.resetLabel)

            val secondResult = holder.onHelpClick()
            val afterSecond = holder.uiState.value
            assertFalse(secondResult)
            assertEquals(afterFirst.help, afterSecond.help)

            holder.onClearHelpRequest()
            val afterClear = holder.uiState.value
            assertFalse(afterClear.help.isRequested)
            assertEquals("طلب مساعدة", afterClear.help.buttonLabel)
            assertEquals("إذا احتجت مساعدة، يمكنك إرسال طلب الآن.", afterClear.help.supportingText)
            assertNull(afterClear.help.resetLabel)

            // Help local flow must stay isolated from reassurance flow.
            assertEquals(initialReassured, afterFirst.isReassuredToday)
            assertEquals(initialReassured, afterSecond.isReassuredToday)
            assertEquals(initialReassured, afterClear.isReassuredToday)
            assertEquals(initialLastUpdate, afterFirst.lastUpdateLabel)
            assertEquals(initialLastUpdate, afterSecond.lastUpdateLabel)
            assertEquals(initialLastUpdate, afterClear.lastUpdateLabel)
        } finally {
            holder.clear()
        }
    }

    @Test
    fun helpRequested_thenConfirmReassurance_keepsHelpRequested_untilExplicitClear() {
        DailyReassuranceStore.clearForTesting()
        InMemoryDailyReassuranceStateSource.restoreFromLocalStoreAndRefresh()

        val holder = SeniorHomeStateHolder()
        try {
            val initial = holder.uiState.value
            assertFalse(initial.help.isRequested)

            val helpRequestResult = holder.onHelpClick()
            val afterHelp = holder.uiState.value
            assertTrue(helpRequestResult)
            assertTrue(afterHelp.help.isRequested)
            assertEquals("تم طلب المساعدة", afterHelp.help.buttonLabel)
            assertEquals("إلغاء الطلب", afterHelp.help.resetLabel)

            holder.onConfirmReassurance()
            val afterReassurance = holder.uiState.value
            assertTrue(afterReassurance.isReassuredToday)
            assertTrue(afterReassurance.lastUpdateLabel == "الآن" || afterReassurance.lastUpdateLabel == "اليوم")

            // Help state must remain requested until explicitly cleared.
            assertTrue(afterReassurance.help.isRequested)
            assertEquals("تم طلب المساعدة", afterReassurance.help.buttonLabel)
            assertEquals("إلغاء الطلب", afterReassurance.help.resetLabel)

            holder.onClearHelpRequest()
            val afterClear = holder.uiState.value
            assertFalse(afterClear.help.isRequested)
            assertEquals("طلب مساعدة", afterClear.help.buttonLabel)
            assertNull(afterClear.help.resetLabel)

            // Clearing help must not rollback reassurance state.
            assertTrue(afterClear.isReassuredToday)
            assertTrue(afterClear.lastUpdateLabel == "الآن" || afterClear.lastUpdateLabel == "اليوم")
        } finally {
            holder.clear()
        }
    }
}
