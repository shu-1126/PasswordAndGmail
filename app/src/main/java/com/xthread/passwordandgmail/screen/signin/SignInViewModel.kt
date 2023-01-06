package com.xthread.passwordandgmail.screen.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import com.xthread.passwordandgmail.Response
import com.xthread.passwordandgmail.data.repository.AuthRepository
import com.xthread.passwordandgmail.data.repository.SignInResponse

import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel(){
    var signInResponse by mutableStateOf<SignInResponse>(Response.Success(false))
        private set

    fun signInWithEmailAndPassword(email : String,password:String) = viewModelScope.launch {
        signInResponse = Response.Loading
        signInResponse = repo.firebaseSignInWithEmailAndPassword(email, password)
    }

}