package com.example.monchefalgerien.data

data class Item(
    val id: Int,
    val title: String,
    val imageRes: Int,
    val ingredients: List<String>,
    val description: String
)
