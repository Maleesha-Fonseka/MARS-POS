package com.example.authui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.authui.core.navigation.App
import com.example.authui.ui.theme.AuthUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthUiTheme {
                App()
            }
        }
    }
}
