package com.example.authui.pages

import android.util.Patterns

object ValidationUtils {

    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 8 &&
                password.contains(Regex("[A-Z]")) &&
                password.contains(Regex("[a-z]")) &&
                password.contains(Regex("[0-9]"))
    }

    fun isValidRepassword(password: String, rePassword: String): Boolean {
        return password == rePassword
    }
}