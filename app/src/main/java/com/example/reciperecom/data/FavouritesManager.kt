package com.example.reciperecom.data

import android.content.Context

object FavouritesManager {

    private const val PREF_NAME = "favourites"

    fun saveFavourite(context: Context, recipeId: Int, isFavourite: Boolean) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean("recipe_$recipeId", isFavourite).apply()
    }

    fun loadFavourites(context: Context) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        RecipeRepository.allRecipes.forEach { recipe ->
            recipe.isFavourite = prefs.getBoolean("recipe_${recipe.id}", false)
        }
    }
}