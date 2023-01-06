package com.xthread.passwordandgmail.data.repository

import com.google.firebase.auth.FirebaseUser
import com.xthread.passwordandgmail.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

typealias SignUpResponse = Response<Boolean>
typealias SendEmailVerificationResponse = Response<Boolean>
typealias SignInResponse = Response<Boolean>
typealias ReloadUserResponse = Response<Boolean>
typealias SendPasswordResetEmailResponse = Response<Boolean>
typealias RevokeAccessResponse = Response<Boolean>
typealias AuthStateResponse = StateFlow<Boolean>

interface AuthRepository{
    val currentUser: FirebaseUser?

    //メールとパスワードで新しいアカウントを作ること
    suspend fun firebaseSignUpWithEmailAndPassword(email: String,password:String) :SignUpResponse

    //メール確認
    suspend fun sendEmailVerification(): SendEmailVerificationResponse

    //メールとパスワードで登録すること
    suspend fun firebaseSignInWithEmailAndPassword(email:String,password: String):SignInResponse

    suspend fun reloadFirebaseUser()  : ReloadUserResponse

    suspend fun sendPasswordResetEmail(email: String) : SendPasswordResetEmailResponse

    fun signOut()

    suspend fun revokeAccess(): RevokeAccessResponse

    fun getAuthState(viewModelScope: CoroutineScope): AuthStateResponse



}