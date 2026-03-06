package com.mahshad.authentication.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable

@Serializable
data object WelcomeScreenRoute

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Text("Hi")
}