package com.example.monchefalgerien.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

object PrefsKeys {
    val DARK_THEME = booleanPreferencesKey("dark_theme")
    val SHOW_FAVORIS_ONLY = booleanPreferencesKey("show_favoris_only")
}

class UserPreferences(private val context: Context) {
    val darkTheme = context.dataStore.data.map { it[PrefsKeys.DARK_THEME] ?: false }
    val showFavorisOnly = context.dataStore.data.map { it[PrefsKeys.SHOW_FAVORIS_ONLY] ?: false }

    suspend fun setDarkTheme(enabled: Boolean) {
        context.dataStore.edit { it[PrefsKeys.DARK_THEME] = enabled }
    }

    suspend fun setShowFavorisOnly(enabled: Boolean) {
        context.dataStore.edit { it[PrefsKeys.SHOW_FAVORIS_ONLY] = enabled }
    }
}