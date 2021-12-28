package br.com.mvclopes.formvalidationcompose

import androidx.annotation.StringRes

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val email: String? = null,
    val isLoading: Boolean = false,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList()
)

enum class PasswordRequirements(
    @StringRes val label: Int
) {
    CAPITAL_LETTER(R.string.password_requirements_capital),
    DIGIT(R.string.password_requirements_digit),
    EIGHT_CHARACTERS(R.string.password_requirements_characters)
}

enum class AuthenticationMode {
    SIGN_UP, SIGN_IN
}