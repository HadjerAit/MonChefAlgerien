package com.example.monchefalgerien.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recettes")
data class Recette(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val imageRes: String,
    val ingredients: String,
    val description: String,
    val categorie: String,
    val isFavori: Boolean = false
)