package ui.state

data class SeniorProfileDisplayData(
    val seniorDisplayName: String,
    val greetingPrefix: String
)

data class CaregiverProfileDisplayData(
    val caregiverDisplayName: String,
    val trackedSeniorDisplayName: String
)

data class MedicationDisplaySample(
    val title: String,
    val name: String,
    val time: String,
    val isTaken: Boolean
)

data class CaregiverSummaryDisplaySample(
    val statusLabel: String,
    val mainState: String,
    val interpretation: String,
    val lastUpdate: String
)

interface DisplayProfileProvider {
    fun seniorProfile(): SeniorProfileDisplayData
    fun caregiverProfile(): CaregiverProfileDisplayData
    fun seniorMedicationSample(): MedicationDisplaySample
    fun caregiverMedicationSample(): MedicationDisplaySample
    fun caregiverSummarySample(): CaregiverSummaryDisplaySample
    fun caregiverAlertSample(): String
}

object InMemoryDisplayProfileProvider : DisplayProfileProvider {
    override fun seniorProfile(): SeniorProfileDisplayData {
        return SeniorProfileDisplayData(
            seniorDisplayName = "أستاذ أحمد",
            greetingPrefix = "صباح الخير يا"
        )
    }

    override fun caregiverProfile(): CaregiverProfileDisplayData {
        return CaregiverProfileDisplayData(
            caregiverDisplayName = "سارة",
            trackedSeniorDisplayName = "أستاذ أحمد"
        )
    }

    override fun seniorMedicationSample(): MedicationDisplaySample {
        return MedicationDisplaySample(
            title = "الدواء القادم",
            name = "دواء الضغط",
            time = "٩:٠٠ صباحًا",
            isTaken = false
        )
    }

    override fun caregiverMedicationSample(): MedicationDisplaySample {
        return MedicationDisplaySample(
            title = "الدواء القادم",
            name = "دواء الضغط",
            time = "١٢:٣٠ م",
            isTaken = true
        )
    }

    override fun caregiverSummarySample(): CaregiverSummaryDisplaySample {
        return CaregiverSummaryDisplaySample(
            statusLabel = "حالة اليوم",
            mainState = "تم الاطمئنان اليوم",
            interpretation = "كل شيء يبدو مطمئنًا حتى الآن.",
            lastUpdate = "اليوم ٩:١٥ ص"
        )
    }

    override fun caregiverAlertSample(): String {
        return "لم يتم تسجيل الاطمئنان بعد"
    }
}

