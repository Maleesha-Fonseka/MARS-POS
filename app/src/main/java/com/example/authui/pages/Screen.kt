package com.example.authui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.example.authui.R

@Composable
fun AuthScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(color = colorResource(R.color.OffWhite))
            .fillMaxSize()
    ) {
        ScreenDetails(title = "Welcome Back", message = "Sign In with")
        GoogleButton()
        ScreenTabs()
    }
}

