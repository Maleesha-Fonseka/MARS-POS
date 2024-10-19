package com.example.authui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.security.crypto.MasterKey
import com.example.authui.pages.App
import com.example.authui.pages.LoginForm
import com.example.authui.ui.theme.AuthUiTheme
import androidx.security.crypto.EncryptedSharedPreferences
import com.example.authui.pages.AuthViewModel
import com.example.authui.pages.SecureStorage


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val authViewModel:AuthViewModel by viewModels()

        // Initialize Secure Storage
        SecureStorage.initialize(this)

        setContent {
            AuthUiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        authViewModel = authViewModel
                    )
                }

            }
        }
    }
}
