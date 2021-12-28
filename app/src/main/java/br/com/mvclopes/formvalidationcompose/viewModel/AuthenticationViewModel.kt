package br.com.mvclopes.formvalidationcompose.viewModel

import androidx.lifecycle.ViewModel
import br.com.mvclopes.formvalidationcompose.state.AuthenticationEvent
import br.com.mvclopes.formvalidationcompose.state.AuthenticationMode
import br.com.mvclopes.formvalidationcompose.state.AuthenticationState
import br.com.mvclopes.formvalidationcompose.state.PasswordRequirements
import kotlinx.coroutines.flow.MutableStateFlow

class AuthenticationViewModel: ViewModel() {
    val uiState = MutableStateFlow(AuthenticationState())

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when(authenticationEvent) {
            is AuthenticationEvent.ToggleAuthenticationMode -> toggleAuthenticationMode()
            is AuthenticationEvent.EmailChanged -> updateEmail(authenticationEvent.email)
            is AuthenticationEvent.PasswordChanged -> updatePassword(authenticationEvent.password)
        }
    }

    private fun toggleAuthenticationMode() {
        val authenticationMode = uiState.value.authenticationMode
        val newAuthenticationState = if (
            authenticationMode == AuthenticationMode.SIGN_IN
        ) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.SIGN_IN
        }
        uiState.value = uiState.value.copy(authenticationMode = newAuthenticationState)
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(email = email)
    }

    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()
        if (password.length > 7)
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        if (password.any { it.isUpperCase() })
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        if (password.any { it.isDigit() })
            requirements.add(PasswordRequirements.DIGIT)

        uiState.value = uiState.value.copy(
            password = password,
            passwordRequirements = requirements.toList()
        )
    }

}