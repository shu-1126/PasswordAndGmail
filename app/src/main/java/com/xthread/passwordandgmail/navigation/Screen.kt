package com.xthread.passwordandgmail.navigation

sealed class Screen(val route: String) {
    object SignIn: Screen("signin")
    object ForgotPassword: Screen("forgotpassword")
    object SignUp: Screen("signup")
    object VerifyEmail: Screen("verifyemail")
    object Profile: Screen("profile")
}