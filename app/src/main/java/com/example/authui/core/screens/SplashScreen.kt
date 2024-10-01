package com.example.authui.core.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.authui.core.navigation.Screen
import com.example.authui.core.navigation.isInternetAvailable
import kotlinx.coroutines.*


@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(2000L)
        if (isInternetAvailable(context)) {
            navController.navigate(Screen.Auth.route)
        } else {
            navController.navigate(Screen.Error.route)
        }
    }
        Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.darkTeal))
    ) {
        Text(
            text = "Grapzian POS",
            fontSize = 32.sp,
            color = colorResource(R.color.OffWhite),
            fontWeight = FontWeight(900),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
        )
        Spacer(
            modifier = Modifier
                .height(240.dp)
        )
        Text(
            text = "~ A customizable mobile pos application ~",
            fontSize = 16.sp,
            color = colorResource(R.color.secondMidTeal),
            fontWeight = FontWeight(900),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}
