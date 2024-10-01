package com.example.authui.core.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authui.core.screens.ErrorScreen
import com.example.authui.core.screens.SplashScreen
import com.example.authui.pages.AuthScreen


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Error : Screen("error")
    object Auth: Screen("auth")
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Error.route) {
            ErrorScreen(navController)
        }
        composable(Screen.Auth.route) {
            AuthScreen(navController)
        }
    }
}
