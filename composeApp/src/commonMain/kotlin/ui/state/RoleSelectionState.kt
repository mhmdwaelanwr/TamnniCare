package ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RoleOptionUi(
    val role: UserRole,
    val title: String,
    val description: String
)

data class RoleSelectionUiState(
    val title: String,
    val options: List<RoleOptionUi>,
    val selectedRole: UserRole?
) {
    val isSelectionMade: Boolean get() = selectedRole != null
}

class RoleSelectionStateHolder(
    initialState: RoleSelectionUiState = defaultRoleSelectionUiState()
) {
    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<RoleSelectionUiState> = _uiState.asStateFlow()

    fun onSelectRole(role: UserRole) {
        _uiState.value = _uiState.value.copy(selectedRole = role)
    }
}

@Composable
fun rememberRoleSelectionStateHolder(): RoleSelectionStateHolder {
    return remember { RoleSelectionStateHolder() }
}

fun defaultRoleSelectionUiState(): RoleSelectionUiState {
    return RoleSelectionUiState(
        title = "من سيستخدم التطبيق؟",
        options = listOf(
            RoleOptionUi(
                role = UserRole.SENIOR,
                title = "كبير السن",
                description = "استخدام بسيط لطمأنة العائلة"
            ),
            RoleOptionUi(
                role = UserRole.CAREGIVER,
                title = "مقدم رعاية / أحد أفراد العائلة",
                description = "متابعة حالة الوالدين والاطمئنان عليهم"
            )
        ),
        selectedRole = null
    )
}

