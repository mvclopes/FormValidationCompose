package br.com.mvclopes.formvalidationcompose.state

import androidx.annotation.StringRes
import br.com.mvclopes.formvalidationcompose.R

enum class PasswordRequirements(
    @StringRes val label: Int
) {
    CAPITAL_LETTER(R.string.password_requirements_capital),
    DIGIT(R.string.password_requirements_digit),
    EIGHT_CHARACTERS(R.string.password_requirements_characters)
}