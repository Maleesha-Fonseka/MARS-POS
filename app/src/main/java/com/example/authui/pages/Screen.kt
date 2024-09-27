package com.example.authui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.authui.R

@Composable
fun App() {
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


@Preview(
    showSystemUi = true,
    showBackground = true
)

@Composable
fun DefaultPreview() {
    App()
}
