package com.example.monchefalgerien.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.monchefalgerien.data.local.Recette

@Composable
fun RecetteDialog(
    recette: Recette? = null,
    onDismiss: () -> Unit,
    onConfirm: (String, String, String, String) -> Unit
) {
    var title by remember { mutableStateOf(recette?.title ?: "") }
    var description by remember { mutableStateOf(recette?.description ?: "") }
    var categorie by remember { mutableStateOf(recette?.categorie ?: "Salée") }
    var ingredients by remember { mutableStateOf(recette?.ingredients ?: "") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (recette == null) "Ajouter une recette" else "Modifier la recette") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Titre") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = ingredients,
                    onValueChange = { ingredients = it },
                    label = { Text("Ingrédients (séparés par virgule)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = categorie == "Salée",
                        onClick = { categorie = "Salée" },
                        label = { Text("Salée") }
                    )
                    FilterChip(
                        selected = categorie == "Sucrée",
                        onClick = { categorie = "Sucrée" },
                        label = { Text("Sucrée") }
                    )
                }
            }
        },
        confirmButton = {
            Button(
                onClick = { onConfirm(title, description, categorie, ingredients) },
                enabled = title.isNotBlank()
            ) { Text("Confirmer") }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) { Text("Annuler") }
        }
    )
}