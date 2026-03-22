package com.example.monchefalgerien.data.repository

import com.example.monchefalgerien.data.datastore.UserPreferences
import com.example.monchefalgerien.data.local.Recette
import com.example.monchefalgerien.data.local.RecetteDao
import kotlinx.coroutines.flow.Flow

class RecetteRepository(
    private val dao: RecetteDao,
    private val prefs: UserPreferences
) {
    fun getAll(): Flow<List<Recette>> = dao.getAll()
    fun getFavoris(): Flow<List<Recette>> = dao.getFavoris()
    fun search(query: String): Flow<List<Recette>> = dao.search(query)

    suspend fun insert(recette: Recette) = dao.insert(recette)
    suspend fun update(recette: Recette) = dao.update(recette)
    suspend fun delete(recette: Recette) = dao.delete(recette)

    val darkTheme = prefs.darkTheme
    val showFavorisOnly = prefs.showFavorisOnly

    suspend fun setDarkTheme(v: Boolean) = prefs.setDarkTheme(v)
    suspend fun setShowFavorisOnly(v: Boolean) = prefs.setShowFavorisOnly(v)
}