package com.example.monchefalgerien.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsSection(
    showSweet: Boolean,
    onToggleCategory: () -> Unit,
    favorites: List<String>,
    onAddFavorite: (String) -> Unit,
    onShowFavorites: () -> Unit,
    onToggleColor: () -> Unit  
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --- Ligne 1 : Favoris + Couleur ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            ActionButton(
                emoji = "📁",
                label = "Favoris (${favorites.size})",
                onClick = { onShowFavorites() }
            )

            ActionButton(
                emoji = "🎨",
                label = "Couleur",
                onClick = { onToggleColor() }
            )
        }

        Spacer(Modifier.height(12.dp))

        // --- Ligne 2 : Sucré / Salé ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            ActionButton(
                emoji = "🍽️",
                label = if (showSweet) "Salé" else "Sucré",
                onClick = { onToggleCategory() }
            )
        }
    }
}

@Composable
fun ActionButton(emoji: String, label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.width(160.dp)
    ) {
        Text("$emoji  $label")
    }
}
