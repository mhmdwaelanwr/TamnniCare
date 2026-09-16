package ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class OnboardingSlideUi(
    val title: String,
    val subtitle: String
)

data class OnboardingUiState(
    val slides: List<OnboardingSlideUi>,
    val currentSlideIndex: Int
) {
    val currentSlide: OnboardingSlideUi get() = slides[currentSlideIndex]
    val isLastSlide: Boolean get() = currentSlideIndex == slides.lastIndex
}

class OnboardingStateHolder(
    initialState: OnboardingUiState = defaultOnboardingUiState()
) {
    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun onNext(): Boolean {
        val state = _uiState.value
        return if (state.currentSlideIndex < state.slides.lastIndex) {
            _uiState.value = state.copy(currentSlideIndex = state.currentSlideIndex + 1)
            false
        } else {
            true
        }
    }

    fun onSkip(): Boolean = true
}

@Composable
fun rememberOnboardingStateHolder(): OnboardingStateHolder {
    return remember { OnboardingStateHolder() }
}

fun defaultOnboardingUiState(): OnboardingUiState {
    return OnboardingUiState(
        slides = listOf(
            OnboardingSlideUi(
                title = "اطمئنان يومي بضغطة زر",
                subtitle = "لا حاجة لمكالمات طويلة، طمئن عائلتك كل صباح بلمسة واحدة."
            ),
            OnboardingSlideUi(
                title = "متابعة لطيفة للأدوية",
                subtitle = "تذكير هادئ وبسيط لمواعيد أدويتك اليومية."
            ),
            OnboardingSlideUi(
                title = "عائلتك دائمًا معك",
                subtitle = "مشاركة الحالة الصحية بسهولة وبدون إزعاج."
            )
        ),
        currentSlideIndex = 0
    )
}

