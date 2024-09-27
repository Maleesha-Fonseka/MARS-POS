package com.example.authui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.authui.pages.App
import com.example.authui.pages.LoginForm
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
