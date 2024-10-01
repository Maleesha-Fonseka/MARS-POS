package com.example.authui.core.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.authui.R
import com.example.authui.core.navigation.isInternetAvailable


@Composable
fun ErrorScreen(navController: NavHostController) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.darkTeal))
    ) {
        Text(
            text = "Error!",
            fontSize = 32.sp,
            color = colorResource(R.color.OffWhite),
            fontWeight = FontWeight(900),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Text(
            text = "Please Connect to the Internet",
            fontSize = 16.sp,
            color = colorResource(R.color.secondMidTeal),
            fontWeight = FontWeight(900),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(16.dp)
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Button(
            onClick = {
                if (isInternetAvailable(context)) {
                    navController.popBackStack() // Go back to the splash screen for retry
                }
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.OffWhite)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        ) {
            Text(
                text = "Retry",
                fontWeight = FontWeight(700),
                fontStyle = FontStyle.Italic,
                color = colorResource(R.color.darkTeal)
            )
        }
    }
}