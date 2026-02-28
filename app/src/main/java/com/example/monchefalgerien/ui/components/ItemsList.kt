package com.example.monchefalgerien.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.monchefalgerien.data.Item

@Composable
fun ItemsList(
    items: List<Item>,
    onAddFavorite: (String) -> Unit,
    onItemClick: (Item) -> Unit
) {
    LazyColumn {
        items(items) { item ->
            ItemCard(
                item = item,
                onAddFavorite = onAddFavorite,
                onClick = { onItemClick(item) }
            )
        }
    }
}

@Composable
fun ItemCard(
    item: Item,
    onAddFavorite: (String) -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(8.dp))

            Button(onClick = { onAddFavorite(item.title) }) {
                Text("Ajouter aux favoris")
            }
        }
    }
}
