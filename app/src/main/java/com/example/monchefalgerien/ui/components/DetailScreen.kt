package com.example.monchefalgerien.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.monchefalgerien.data.local.Recette

@Composable
fun DetailScreen(
    recette: Recette,
    onBack: () -> Unit
) {
    var showDescription by remember { mutableStateOf(false) }
    val ingredientsList = recette.ingredients.split(",").map { it.trim() }

    val context = LocalContext.current
    val imageId = context.resources.getIdentifier(recette.imageRes, "drawable", context.packageName)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        item {
            Button(onClick = onBack) { Text("← Retour") }

            Spacer(Modifier.height(12.dp))

            if (imageId != 0) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = recette.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.height(12.dp))

            Text(text = recette.title, style = MaterialTheme.typography.titleLarge)

            Spacer(Modifier.height(4.dp))

            Text(
                text = recette.categorie,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(Modifier.height(16.dp))

            Text(text = "Ingrédients :", style = MaterialTheme.typography.titleMedium)

            Spacer(Modifier.height(8.dp))
        }

        items(ingredientsList.size) { index ->
            Text("• ${ingredientsList[index]}", modifier = Modifier.padding(vertical = 2.dp))
        }

        item {
            Spacer(Modifier.height(16.dp))

            Button(onClick = { showDescription = !showDescription }) {
                Text(if (showDescription) "Masquer description" else "Voir description")
            }

            if (showDescription) {
                Spacer(Modifier.height(8.dp))
                Text(recette.description)
            }
        }
    }
}