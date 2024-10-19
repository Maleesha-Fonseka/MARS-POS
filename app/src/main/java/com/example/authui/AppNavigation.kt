package com.example.authui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authui.pages.App
import com.example.authui.pages.AuthViewModel
import com.example.authui.pages.LoginForm
import com.example.authui.pages.ScreenDetails
import com.example.authui.pages.ScreenTabs
import com.example.authui.pages.SignUpForm

@Composable
fun AppNavigation(modifier: Modifier = Modifier,authViewModel: AuthViewModel) {
    val navController= rememberNavController()
    
    NavHost(navController = navController, startDestination ="home" , builder = {
        composable("login"){
            LoginForm(modifier,navController , authViewModel  )
        }

        composable("signup"){
            SignUpForm(modifier,navController , authViewModel  )
        }

        composable("home"){
            ScreenTabs(modifier,navController , authViewModel  )
        }
    })
}
