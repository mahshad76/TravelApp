package com.mahshad.authentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mahshad.authentication.R
import kotlinx.serialization.Serializable

@Serializable
data object LogInScreenRoute

@Composable
fun LogInScreen(viewModel: LogInScreenViewModel = hiltViewModel()) {
    val email = viewModel.emailStateFlow.collectAsStateWithLifecycle()
    val password = viewModel.passwordStateFlow.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(width = 39.72.dp, height = 48.dp)
            )
            Spacer(Modifier.padding(horizontal = 12.dp))
            Text(
                modifier = Modifier.weight(1.0F), text = stringResource(R.string.traveloop),
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(94.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = email.value,
            onValueChange = { viewModel.updateEmailStateFlow(it) },
            label = { Text(modifier = Modifier, text = "Email") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "email icon") },
            singleLine = true
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = password.value,
            onValueChange = { viewModel.updatePasswordStateFlow(it) },
            label = { Text("Password") },
            leadingIcon = { Icon(Icons.Default.Password, contentDescription = "password icon") },
            singleLine = true
        )
        Spacer(Modifier.height(52.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFE3311)),
            shape = RoundedCornerShape(8.dp),
            onClick = {}) {
            Text("Continue", color = Color.White)
        }
    }
}

@Preview
@Composable
fun Preview() {
    LogInScreen()
}