package com.example.monchefalgerien.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.monchefalgerien.data.*
import com.example.monchefalgerien.ui.components.*

@Composable
fun MainScreen() {

    var showSweet by remember { mutableStateOf(false) }
    var favorites by remember { mutableStateOf(listOf<String>()) }
    var showFavorites by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<Item?>(null) }
    var isDark by remember { mutableStateOf(false) }

    val currentList = if (showSweet) sweetRecipes else saltyRecipes

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDark) Color(0xFF1E1E1E) else Color.White)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            ButtonsSection(
                showSweet = showSweet,
                onToggleCategory = { showSweet = !showSweet },
                favorites = favorites,
                onAddFavorite = { favorites = favorites + it },
                onShowFavorites = { showFavorites = true },
                onToggleColor = { isDark = !isDark }
            )

            Spacer(Modifier.height(16.dp))

            ItemsList(
                items = currentList,
                onAddFavorite = { favorites = favorites + it },
                onItemClick = { selectedItem = it }
            )
        }

        if (showFavorites) {
            FavoritesScreen(
                favorites = favorites,
                onBack = { showFavorites = false }
            )
        }

        selectedItem?.let { item ->
            DetailScreen(
                item = item,
                onBack = { selectedItem = null }
            )
        }
    }
}
