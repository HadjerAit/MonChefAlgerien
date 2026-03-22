package com.example.monchefalgerien.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.monchefalgerien.data.local.Recette

@Composable
fun RecettesList(
    recettes: List<Recette>,
    onItemClick: (Recette) -> Unit,
    onToggleFavori: (Recette) -> Unit,
    onDelete: (Recette) -> Unit,
    onEdit: (Recette) -> Unit
) {
    LazyColumn {
        items(recettes, key = { it.id }) { recette ->
            RecetteCard(
                recette = recette,
                onClick = { onItemClick(recette) },
                onToggleFavori = { onToggleFavori(recette) },
                onDelete = { onDelete(recette) },
                onEdit = { onEdit(recette) }
            )
        }
    }
}

@Composable
fun RecetteCard(
    recette: Recette,
    onClick: () -> Unit,
    onToggleFavori: () -> Unit,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    val context = LocalContext.current
    val imageId = context.resources.getIdentifier(recette.imageRes, "drawable", context.packageName)

    var showConfirm by remember { mutableStateOf(false) }

    if (showConfirm) {
        AlertDialog(
            onDismissRequest = { showConfirm = false },
            title = { Text("Supprimer ?") },
            text = { Text("Voulez-vous vraiment supprimer \"${recette.title}\" ?") },
            confirmButton = {
                Button(onClick = {
                    onDelete()
                    showConfirm = false
                }) { Text("Oui, supprimer") }
            },
            dismissButton = {
                OutlinedButton(onClick = { showConfirm = false }) { Text("Annuler") }
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onClick() }
    ) {
        Column {
            if (imageId != 0) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = recette.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = recette.title, style = MaterialTheme.typography.titleMedium)
                    Text(
                        text = recette.categorie,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = onToggleFavori) {
                    Icon(
                        imageVector = if (recette.isFavori) Icons.Default.Favorite
                        else Icons.Default.FavoriteBorder,
                        contentDescription = "Favori",
                        tint = if (recette.isFavori) Color.Red else Color.Gray
                    )
                }
                IconButton(onClick = onEdit) {
                    Icon(Icons.Default.Edit, contentDescription = "Modifier")
                }
                IconButton(onClick = { showConfirm = true }) {
                    Icon(Icons.Default.Delete, contentDescription = "Supprimer", tint = Color.Red)
                }
            }
        }
    }
}