package com.example.monchefalgerien.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.monchefalgerien.data.Item
import com.example.monchefalgerien.data.local.Recette
import com.example.monchefalgerien.ui.components.*
import com.example.monchefalgerien.viewmodel.RecetteViewModel

@Composable
fun MainScreen(vm: RecetteViewModel = viewModel()) {

    val recettes by vm.recettes.collectAsState()
    val darkTheme by vm.darkTheme.collectAsState()
    val showFavorisOnly by vm.showFavorisOnly.collectAsState()
    val query by vm.query.collectAsState()

    var selectedRecette by remember { mutableStateOf<Recette?>(null) }
    var showFavorites by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var recetteToEdit by remember { mutableStateOf<Recette?>(null) }
    var showSweet by remember { mutableStateOf(false) }

    val filteredRecettes = recettes.filter { recette ->
        val categorieOk = if (showSweet) recette.categorie == "Sucrée" else recette.categorie == "Salée"
        val favOk = if (showFavorisOnly) recette.isFavori else true
        categorieOk && favOk
    }

    val bgColor = if (darkTheme) Color(0xFF1E1E1E) else Color.White
    val textColor = if (darkTheme) Color.White else Color.Black

    // tout dans un seul LazyColumn pour que le scroll marche
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Mon Chef Algérien 🍽️",
                    style = MaterialTheme.typography.headlineSmall,
                    color = textColor
                )
                Switch(
                    checked = darkTheme,
                    onCheckedChange = { vm.toggleDarkTheme(it) }
                )
            }
        }

        item {
            OutlinedTextField(
                value = query,
                onValueChange = { vm.setQuery(it) },
                placeholder = { Text("Rechercher...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                singleLine = true
            )
            Spacer(Modifier.height(8.dp))
        }

        item {
            ButtonsSection(
                showSweet = showSweet,
                onToggleCategory = { showSweet = !showSweet },
                showFavorisOnly = showFavorisOnly,
                onToggleFavorisOnly = { vm.toggleFavorisOnly(!showFavorisOnly) },
                onShowFavorites = { showFavorites = true },
                onToggleColor = { vm.toggleDarkTheme(!darkTheme) },
                onAddRecette = { showAddDialog = true }
            )
            Spacer(Modifier.height(8.dp))
        }

        items(filteredRecettes, key = { it.id }) { recette ->
            RecetteCard(
                recette = recette,
                onClick = { selectedRecette = recette },
                onToggleFavori = { vm.toggleFavori(recette) },
                onDelete = { vm.delete(recette) },
                onEdit = { recetteToEdit = recette }
            )
        }
    }

    // ces écrans s'affichent par dessus la liste
    if (showFavorites) {
        FavoritesScreen(
            recettes = recettes.filter { it.isFavori },
            onBack = { showFavorites = false }
        )
    }

    selectedRecette?.let {
        DetailScreen(
            recette = it,
            onBack = { selectedRecette = null }
        )
    }

    if (showAddDialog) {
        RecetteDialog(
            onDismiss = { showAddDialog = false },
            onConfirm = { title, desc, cat, ing ->
                vm.insert(Recette(
                    title = title,
                    description = desc,
                    categorie = cat,
                    ingredients = ing,
                    imageRes = "default"
                ))
                showAddDialog = false
            }
        )
    }

    recetteToEdit?.let { recette ->
        RecetteDialog(
            recette = recette,
            onDismiss = { recetteToEdit = null },
            onConfirm = { title, desc, cat, ing ->
                vm.update(recette.copy(
                    title = title,
                    description = desc,
                    categorie = cat,
                    ingredients = ing
                ))
                recetteToEdit = null
            }
        )
    }
}