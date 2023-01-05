package com.xthread.passwordandgmail.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@Composable
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun NavGraph(
    navController: NavHostController,
){
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.SignIn.route,
        enterTransition = { EnterTransition.None},
        exitTransition = {ExitTransition.None}

    ){
        composable(
            route = Screen.SignIn.route
        ){

        }
        composable(
            route = Screen.ForgotPassword.route
        ){

        }
        composable(
            route = Screen.SignUp.route
        ){

        }
        composable(
            route = Screen.VerifyEmail.route
        ){

        }
        composable(
            route = Screen.Profile.route
        ){

        }


    }
}