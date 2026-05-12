package com.example.reciperecom.model

data class Recipe(
    val id: Int,
    val name: String,
    val cuisine: String,
    val mood: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val imageUrl: String,
    val cookTimeMinutes: Int,
    val chefName: String,
    val chefImageUrl: String,
    val rating: Float,
    val difficulty: String,
    val calories: Int,
    var isFavourite: Boolean = false
)