package br.com.mvclopes.formvalidationcompose.viewModel

import androidx.lifecycle.ViewModel
import br.com.mvclopes.formvalidationcompose.state.AuthenticationState
import kotlinx.coroutines.flow.MutableStateFlow

class AuthenticationViewModel: ViewModel() {
    val uiState = MutableStateFlow(AuthenticationState())
}