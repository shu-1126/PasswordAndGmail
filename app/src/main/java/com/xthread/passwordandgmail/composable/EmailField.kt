package com.xthread.passwordandgmail.composable


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.job

@Composable
fun EmailField(
    email: TextFieldValue,
    onEmailValueChange: (newValue :TextFieldValue) -> Unit,
){
    val focusRequester = FocusRequester()

    TextField(
        value = email,
        onValueChange = {
            newvalue -> onEmailValueChange(newvalue)

        },
        placeholder = {
            Text(
                text = "hint"
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        modifier = Modifier.focusRequester(focusRequester)
    )

    //CoroutineScopeでもいいのではという気がする
    //runblockingはメインスレッドをブロックしてしまう
    LaunchedEffect(Unit){
        coroutineContext.job.invokeOnCompletion {
            focusRequester.requestFocus()
        }

    }
}