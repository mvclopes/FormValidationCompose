package br.com.mvclopes.formvalidationcompose.viewModel

import androidx.lifecycle.ViewModel
import br.com.mvclopes.formvalidationcompose.state.AuthenticationEvent
import br.com.mvclopes.formvalidationcompose.state.AuthenticationMode
import br.com.mvclopes.formvalidationcompose.state.AuthenticationState
import kotlinx.coroutines.flow.MutableStateFlow

class AuthenticationViewModel: ViewModel() {
    val uiState = MutableStateFlow(AuthenticationState())

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when(authenticationEvent) {
            is AuthenticationEvent.ToggleAuthenticationMode -> toggleAuthenticationMode()
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

}