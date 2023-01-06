package com.xthread.passwordandgmail.screen.signin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.xthread.passwordandgmail.Response
import com.xthread.passwordandgmail.composable.EmailField
import com.xthread.passwordandgmail.composable.PasswordField
import com.xthread.passwordandgmail.composable.ProgressBar
import com.xthread.passwordandgmail.composable.SmallSpacer
import com.xthread.showMessage

@Composable
@ExperimentalComposeUiApi
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit,
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            SignInTopBar()
        },
        content = { padding ->
            SignInContent(
                padding = padding,
                signIn = { email, password ->
                    viewModel.signInWithEmailAndPassword(email, password)
                },
                navigateToForgotPasswordScreen = navigateToForgotPasswordScreen,
                navigateToSignUpScreen = navigateToSignUpScreen,

            )
        }
    )

    SignIn(
        showErrorMessage = {
            errorMessage -> showMessage(context,errorMessage)
        }
    )

}

@Composable
fun SignIn(
    viewModel: SignInViewModel = hiltViewModel(),
    showErrorMessage: (errorMessage: String?) -> Unit
) {
    when(val signInResponse = viewModel.signInResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> Unit
        is Response.Failure -> signInResponse.apply {
            LaunchedEffect(e) {
                print(e)
                showErrorMessage(e.message)
            }
        }
    }
}

@Composable
fun SignInTopBar(){
    TopAppBar(
        title = {
            Text(
                text = "sign_in_screen"
            )
        }
    )
}

@Composable
@ExperimentalComposeUiApi
fun SignInContent(
    padding: PaddingValues,
    signIn: (email:String,password:String) -> Unit,
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
){
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) { mutableStateOf(TextFieldValue("")) }
    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) { mutableStateOf(TextFieldValue("")) }
    val keyboard = LocalSoftwareKeyboardController.current

    EmailField(
        email = email,
        onEmailValueChange = { newValue ->
            email = newValue
        }
    )
    SmallSpacer()
    PasswordField(
        password = password,
        onPasswordValueChange = { newValue ->
            password = newValue
        }
    )

    SmallSpacer()
    Button(
        onClick = {
            keyboard?.hide()
            signIn(email.text, password.text)
        }
    ) {
        Text(
            text = "sign_in",
            fontSize = 15.sp
        )
    }
    Row {
        Text(
            modifier = Modifier.clickable {
                navigateToForgotPasswordScreen()
            },
            text = "forgot password",
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
            text = "VERTICAL_DIVIDER",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable {
                navigateToSignUpScreen()
            },
            text = "no account",
            fontSize = 15.sp
        )
    }
}