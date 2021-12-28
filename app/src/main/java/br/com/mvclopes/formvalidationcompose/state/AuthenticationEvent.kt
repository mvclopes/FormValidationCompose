package br.com.mvclopes.formvalidationcompose.state

sealed class AuthenticationEvent {
    object ToggleAuthenticationMode: AuthenticationEvent()
}
