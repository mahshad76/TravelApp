package com.mahshad.authentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahshad.authentication.R
import kotlinx.serialization.Serializable

@Serializable
data object LogInScreenRoute

@Composable
fun LogInScreen() {
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
            Text(modifier = Modifier.weight(1.0F), text = stringResource(R.string.traveloop))
        }
    }
}

@Preview
@Composable
fun Preview() {
    LogInScreen()
}