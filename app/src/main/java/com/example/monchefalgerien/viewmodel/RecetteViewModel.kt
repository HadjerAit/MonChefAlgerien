package com.example.monchefalgerien.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.monchefalgerien.data.datastore.UserPreferences
import com.example.monchefalgerien.data.local.Recette
import com.example.monchefalgerien.data.local.RecetteDatabase
import com.example.monchefalgerien.data.repository.RecetteRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class RecetteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RecetteRepository

    // la recherche tapée par l'utilisateur
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    val darkTheme: StateFlow<Boolean>
    val showFavorisOnly: StateFlow<Boolean>

    // liste des recettes affichées
    val recettes: StateFlow<List<Recette>>

    init {
        // je crée la base de données et le repository
        val dao = RecetteDatabase.getInstance(application).recetteDao()
        val prefs = UserPreferences(application)
        repository = RecetteRepository(dao, prefs)

        // je récupère les préférences depuis DataStore
        darkTheme = repository.darkTheme
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

        showFavorisOnly = repository.showFavorisOnly
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

        // je récupère les recettes selon la recherche
        // si la recherche est vide, je prends tout
        recettes = _query
            .flatMapLatest { q ->
                if (q.isEmpty()) repository.getAll()
                else repository.search(q)
            }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
    }

    // quand l'utilisateur tape dans la barre de recherche
    fun setQuery(q: String) {
        _query.value = q
    }

    // ajouter une recette dans la BD
    fun insert(recette: Recette) = viewModelScope.launch {
        repository.insert(recette)
    }

    // modifier une recette existante
    fun update(recette: Recette) = viewModelScope.launch {
        repository.update(recette)
    }

    // supprimer une recette
    fun delete(recette: Recette) = viewModelScope.launch {
        repository.delete(recette)
    }

    // changer le thème clair/sombre
    fun toggleDarkTheme(v: Boolean) = viewModelScope.launch {
        repository.setDarkTheme(v)
    }

    // TODO: améliorer le filtre favoris plus tard
    fun toggleFavorisOnly(v: Boolean) = viewModelScope.launch {
        repository.setShowFavorisOnly(v)
    }

    // mettre ou enlever des favoris
    fun toggleFavori(recette: Recette) = viewModelScope.launch {
        repository.update(recette.copy(isFavori = !recette.isFavori))
    }
}