package ui.state

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlin.test.Test
import kotlin.test.assertEquals

class DailyReassurancePolicyTest {

    private val zone = TimeZone.UTC

    @Test
    fun noTimestamp_returnsNotReassured() {
        val now = epoch(2026, 4, 5, 10, 0)

        val status = deriveDailyReassuranceStatus(
            lastUpdateEpochMillis = null,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals(DailyReassuranceStatus.NOT_REASSURED, status)
    }

    @Test
    fun sameLocalDay_returnsReassuredToday() {
        val now = epoch(2026, 4, 5, 20, 0)
        val lastUpdate = epoch(2026, 4, 5, 8, 0)

        val status = deriveDailyReassuranceStatus(
            lastUpdateEpochMillis = lastUpdate,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals(DailyReassuranceStatus.REASSURED_TODAY, status)
    }

    @Test
    fun previousLocalDay_returnsDelayed() {
        val now = epoch(2026, 4, 5, 10, 0)
        val lastUpdate = epoch(2026, 4, 4, 23, 30)

        val status = deriveDailyReassuranceStatus(
            lastUpdateEpochMillis = lastUpdate,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals(DailyReassuranceStatus.DELAYED, status)
    }

    @Test
    fun olderThanPreviousDay_returnsNeedsFollowUp() {
        val now = epoch(2026, 4, 5, 10, 0)
        val lastUpdate = epoch(2026, 4, 3, 22, 0)

        val status = deriveDailyReassuranceStatus(
            lastUpdateEpochMillis = lastUpdate,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals(DailyReassuranceStatus.NEEDS_FOLLOW_UP, status)
    }

    @Test
    fun display_noTimestamp_returnsNoUpdateYet() {
        val now = epoch(2026, 4, 5, 10, 0)

        val text = deriveDailyReassuranceLastUpdateDisplay(
            lastUpdateEpochMillis = null,
            status = DailyReassuranceStatus.NOT_REASSURED,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals("لا يوجد تحديث بعد", text)
    }

    @Test
    fun display_sameDayUnderOneMinute_returnsNow() {
        val now = epoch(2026, 4, 5, 10, 0)
        val lastUpdate = now - 30_000

        val text = deriveDailyReassuranceLastUpdateDisplay(
            lastUpdateEpochMillis = lastUpdate,
            status = DailyReassuranceStatus.REASSURED_TODAY,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals("الآن", text)
    }

    @Test
    fun display_sameDayOtherwise_returnsToday() {
        val now = epoch(2026, 4, 5, 10, 0)
        val lastUpdate = epoch(2026, 4, 5, 8, 0)

        val text = deriveDailyReassuranceLastUpdateDisplay(
            lastUpdateEpochMillis = lastUpdate,
            status = DailyReassuranceStatus.REASSURED_TODAY,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals("اليوم", text)
    }

    @Test
    fun display_previousDay_returnsYesterday() {
        val now = epoch(2026, 4, 5, 10, 0)
        val lastUpdate = epoch(2026, 4, 4, 12, 0)

        val text = deriveDailyReassuranceLastUpdateDisplay(
            lastUpdateEpochMillis = lastUpdate,
            status = DailyReassuranceStatus.DELAYED,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals("أمس", text)
    }

    @Test
    fun display_twoDaysOld_returnsSinceTwoDays() {
        val now = epoch(2026, 4, 5, 10, 0)
        val lastUpdate = epoch(2026, 4, 3, 12, 0)

        val text = deriveDailyReassuranceLastUpdateDisplay(
            lastUpdateEpochMillis = lastUpdate,
            status = DailyReassuranceStatus.NEEDS_FOLLOW_UP,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals("منذ يومين", text)
    }

    @Test
    fun display_older_returnsSinceSeveralDays() {
        val now = epoch(2026, 4, 5, 10, 0)
        val lastUpdate = epoch(2026, 4, 1, 12, 0)

        val text = deriveDailyReassuranceLastUpdateDisplay(
            lastUpdateEpochMillis = lastUpdate,
            status = DailyReassuranceStatus.NEEDS_FOLLOW_UP,
            nowEpochMillis = now,
            timeZone = zone
        )

        assertEquals("منذ عدة أيام", text)
    }

    private fun epoch(year: Int, month: Int, day: Int, hour: Int, minute: Int): Long {
        return LocalDateTime(year, month, day, hour, minute)
            .toInstant(zone)
            .toEpochMilliseconds()
    }
}

