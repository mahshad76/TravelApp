package com.mahshad.travelapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mahshad.authentication.presentation.navigation.AuthNavGraphRoute
import com.mahshad.authentication.presentation.navigation.authNavGraph

@Composable
fun AppNavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AuthNavGraphRoute
    ) {
        authNavGraph({}, {})
    }
}