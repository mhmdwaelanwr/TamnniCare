package ui.state

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun deriveDailyReassuranceStatus(
    lastUpdateEpochMillis: Long?,
    nowEpochMillis: Long,
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): DailyReassuranceStatus {
    if (lastUpdateEpochMillis == null) return DailyReassuranceStatus.NOT_REASSURED

    val nowDate = Instant.fromEpochMilliseconds(nowEpochMillis).toLocalDateTime(timeZone).date
    val lastDate = Instant.fromEpochMilliseconds(lastUpdateEpochMillis).toLocalDateTime(timeZone).date
    val dayDiff = nowDate.toEpochDays() - lastDate.toEpochDays()

    return when {
        dayDiff <= 0 -> DailyReassuranceStatus.REASSURED_TODAY
        dayDiff == 1 -> DailyReassuranceStatus.DELAYED
        else -> DailyReassuranceStatus.NEEDS_FOLLOW_UP
    }
}

fun deriveDailyReassuranceLastUpdateDisplay(
    lastUpdateEpochMillis: Long?,
    status: DailyReassuranceStatus,
    nowEpochMillis: Long,
    language: AppLanguage = AppPreferencesStore.load().language,
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): String {
    val isEnglish = language == AppLanguage.ENGLISH
    if (lastUpdateEpochMillis == null) {
        return if (isEnglish) "No updates yet" else "لا يوجد تحديث بعد"
    }

    val nowDate = Instant.fromEpochMilliseconds(nowEpochMillis).toLocalDateTime(timeZone).date
    val lastDate = Instant.fromEpochMilliseconds(lastUpdateEpochMillis).toLocalDateTime(timeZone).date
    val dayDiff = nowDate.toEpochDays() - lastDate.toEpochDays()
    val millisDiff = nowEpochMillis - lastUpdateEpochMillis

    return when {
        // Same-day reassurance gets the warmest and shortest wording.
        status == DailyReassuranceStatus.REASSURED_TODAY && dayDiff <= 0 && millisDiff in 0..59_999 -> {
            if (isEnglish) "Now" else "الآن"
        }
        status == DailyReassuranceStatus.REASSURED_TODAY && dayDiff <= 0 -> {
            if (isEnglish) "Today" else "اليوم"
        }
        dayDiff == 1 -> {
            if (isEnglish) "Yesterday" else "أمس"
        }
        dayDiff == 2 -> {
            if (isEnglish) "Two days ago" else "منذ يومين"
        }
        else -> {
            if (isEnglish) "Several days ago" else "منذ عدة أيام"
        }
    }
}
