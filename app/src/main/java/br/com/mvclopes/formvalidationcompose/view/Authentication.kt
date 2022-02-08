package br.com.mvclopes.formvalidationcompose.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.mvclopes.formvalidationcompose.R
import br.com.mvclopes.formvalidationcompose.state.AuthenticationEvent
import br.com.mvclopes.formvalidationcompose.state.AuthenticationMode
import br.com.mvclopes.formvalidationcompose.state.AuthenticationState
import br.com.mvclopes.formvalidationcompose.viewModel.AuthenticationViewModel

@Composable
fun Authentication() {
    val viewModel: AuthenticationViewModel = viewModel()

    MaterialTheme {
        AuthenticationContent(
            modifier = Modifier.fillMaxSize(),
            authenticationState = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent
        )
    }
}

@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (authenticationState.isLoading) {
            CircularProgressIndicator()
        } else {

        }

    }

}

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier
) {
   Column(
       modifier = modifier,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {

   }
}

@Composable
fun AuthenticationTitle(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode
) {
    Text(
        text = stringResource(
            if (authenticationMode == AuthenticationMode.SIGN_IN) R.string.label_sign_in_to_account
            else R.string.label_sign_up_for_account
        ),
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
    )
}