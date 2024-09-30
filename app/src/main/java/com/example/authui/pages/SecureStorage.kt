package com.example.authui.pages

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SecureStorage {

    private lateinit var encryptedSharedPreferences: SharedPreferences

    fun initialize(context: Context) {
        // Create or retrieve the MasterKey for encryption
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        // Initialize the EncryptedSharedPreferences
        encryptedSharedPreferences = EncryptedSharedPreferences.create(
            context,
            "secret_shared_prefs", // Filename
            masterKey, // MasterKey instance
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
    fun storeCredentials(email: String, password: String) {
        encryptedSharedPreferences.edit()
            .putString("email", email)
            .putString("password", password)
            .apply()
    }

    fun getCredentials(): Pair<String, String>? {
        return if (hasCredentials()) {
            Pair(
                encryptedSharedPreferences.getString("email", "")!!,
                encryptedSharedPreferences.getString("password", "")!!
            )
        } else {
            null
        }
    }

    fun hasCredentials(): Boolean {
        return encryptedSharedPreferences.contains("email") &&
                encryptedSharedPreferences.contains("password")
    }

    fun clearCredentials() {
        encryptedSharedPreferences.edit().clear().apply()}
}