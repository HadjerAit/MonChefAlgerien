package com.example.monchefalgerien.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsSection(
    showSweet: Boolean,
    onToggleCategory: () -> Unit,
    showFavorisOnly: Boolean,
    onToggleFavorisOnly: () -> Unit,
    onShowFavorites: () -> Unit,
    onToggleColor: () -> Unit,
    onAddRecette: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ActionButton(emoji = "📁", label = "Favoris", onClick = onShowFavorites)
        ActionButton(
            emoji = if (showSweet) "🍽️" else "🍰",
            label = if (showSweet) "Voir Salé" else "Voir Sucré",
            onClick = onToggleCategory
        )
        ActionButton(emoji = "➕", label = "Ajouter", onClick = onAddRecette)
    }
}

@Composable
fun ActionButton(emoji: String, label: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.width(120.dp)) {
        Text("$emoji $label")
    }
}