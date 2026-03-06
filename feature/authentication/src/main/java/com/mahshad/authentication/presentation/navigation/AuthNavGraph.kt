package com.mahshad.authentication.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mahshad.authentication.presentation.LogInScreen
import com.mahshad.authentication.presentation.LogInScreenRoute
import com.mahshad.authentication.presentation.SignUpScreen
import com.mahshad.authentication.presentation.SignUpScreenRoute
import com.mahshad.authentication.presentation.WelcomeScreen
import com.mahshad.authentication.presentation.WelcomeScreenRoute
import kotlinx.serialization.Serializable

@Serializable
data object AuthNavGraphRoute

fun NavGraphBuilder.authNavGraph(onSignInClicked: () -> Unit, onSignUpClicked: () -> Unit) {
    navigation<AuthNavGraphRoute>(
        startDestination = LogInScreenRoute::class
    ) {
        composable<WelcomeScreenRoute> {
            WelcomeScreen()
        }
        composable<SignUpScreenRoute> {
            SignUpScreen()
        }
        composable<LogInScreenRoute> {
            LogInScreen()
        }
    }
}