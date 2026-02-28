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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.monchefalgerien.data.Item

@Composable
fun DetailScreen(
    item: Item,
    onBack: () -> Unit
) {
    var showDescription by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        item {
            Button(onClick = onBack) {
                Text("Retour")
            }

            Spacer(Modifier.height(16.dp))

            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Ingrédients",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(8.dp))
        }

        items(item.ingredients.size) { index ->
            Text("- ${item.ingredients[index]}")
        }

        item {
            Spacer(Modifier.height(16.dp))

            Button(onClick = { showDescription = !showDescription }) {
                Text(if (showDescription) "Masquer la description" else "Afficher la description")
            }

            if (showDescription) {
                Spacer(Modifier.height(8.dp))
                Text(item.description)
            }
        }
    }
}
