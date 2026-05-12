package com.example.reciperecom.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.reciperecom.R
import com.example.reciperecom.adapter.RecipeAdapter
import com.example.reciperecom.data.FavouritesManager
import com.example.reciperecom.data.RecipeRepository

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("RECIPE_ID", -1)
        val recipe = RecipeRepository.allRecipes.find { it.id == id } ?: return

        // Back button
        findViewById<CardView>(R.id.btnBack).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Recipe image
        Glide.with(this)
            .load(recipe.imageUrl)
            .centerCrop()
            .into(findViewById(R.id.imgDetail))

        // Chef image circular
        Glide.with(this)
            .load(recipe.chefImageUrl)
            .transform(CircleCrop())
            .into(findViewById(R.id.imgDetailChef))

        // Text fields
        findViewById<TextView>(R.id.tvDetailName).text = recipe.name
        findViewById<TextView>(R.id.tvDetailCuisine).text =
            "${recipe.cuisine} • ${recipe.mood}"
        findViewById<TextView>(R.id.tvDetailRating).text = "⭐ ${recipe.rating}"
        findViewById<TextView>(R.id.tvDetailCalories).text = "🔥 ${recipe.calories}"
        findViewById<TextView>(R.id.tvDetailTime).text = "⏱ ${recipe.cookTimeMinutes}"
        findViewById<TextView>(R.id.tvDetailChef).text = recipe.chefName

        // Difficulty with color
        val diffView = findViewById<TextView>(R.id.tvDetailDifficulty)
        diffView.text = recipe.difficulty
        diffView.setTextColor(
            when (recipe.difficulty) {
                "Easy"   -> android.graphics.Color.parseColor("#4CAF50")
                "Medium" -> android.graphics.Color.parseColor("#FF9800")
                "Hard"   -> android.graphics.Color.parseColor("#F44336")
                else     -> android.graphics.Color.BLACK
            }
        )

        // Ingredients
        findViewById<TextView>(R.id.tvIngredients).text =
            recipe.ingredients.joinToString("\n") { "• $it" }

        // Steps
        findViewById<TextView>(R.id.tvSteps).text =
            recipe.steps.mapIndexed { i, s -> "${i + 1}. $s" }.joinToString("\n")

        // Favourite button
        val favBtn = findViewById<ImageView>(R.id.btnFavDetail)
        fun updateFavIcon() {
            favBtn.setImageResource(
                if (recipe.isFavourite) R.drawable.ic_fav_filled
                else R.drawable.ic_fav_outline
            )
        }
        updateFavIcon()
        favBtn.setOnClickListener {
            recipe.isFavourite = !recipe.isFavourite
            FavouritesManager.saveFavourite(this, recipe.id, recipe.isFavourite)
            updateFavIcon()
        }

        // Smart recommendation logic
        val keyword = getKeyword(recipe.name)
        val relatedLabel = findViewById<TextView>(R.id.tvRelatedLabel)
        val relatedSection = findViewById<LinearLayout>(R.id.relatedSection)
        val relatedRv = findViewById<RecyclerView>(R.id.rvRelated)

        // Step 1 — Try to find same keyword (pizza→pizza, paneer→paneer, burger→burger)
        var related = RecipeRepository.allRecipes.filter { other ->
            other.id != recipe.id &&
                    getKeyword(other.name) == keyword
        }

        // Step 2 — If no keyword match, fallback to same cuisine
        if (related.isEmpty()) {
            related = RecipeRepository.allRecipes.filter { other ->
                other.id != recipe.id &&
                        other.cuisine == recipe.cuisine
            }
        }

        // Step 3 — If still empty, suggest same mood
        if (related.isEmpty()) {
            related = RecipeRepository.allRecipes.filter { other ->
                other.id != recipe.id &&
                        other.mood == recipe.mood
            }
        }

        if (related.isEmpty()) {
            relatedSection.visibility = View.GONE
        } else {
            relatedSection.visibility = View.VISIBLE

            // Set smart label
            relatedLabel.text = when {
                getKeyword(recipe.name) != "other" ->
                    "🍴 More ${keyword.replaceFirstChar { it.uppercase() }} Recipes"
                else -> "🍴 More ${recipe.cuisine} Recipes"
            }

            relatedRv.layoutManager = LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false
            )
            relatedRv.adapter = RecipeAdapter(
                related,
                onClick = { relatedRecipe ->
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("RECIPE_ID", relatedRecipe.id)
                    startActivity(intent)
                },
                onFavouriteClick = {}
            )
        }
    }

    // Extract keyword from recipe name for smart grouping
    private fun getKeyword(name: String): String {
        val lower = name.lowercase()
        return when {
            lower.contains("pizza")   -> "pizza"
            lower.contains("burger")  -> "burger"
            lower.contains("paneer")  -> "paneer"
            lower.contains("taco")    -> "taco"
            lower.contains("pasta")   -> "pasta"
            lower.contains("salad")   -> "salad"
            lower.contains("lassi")   -> "lassi"
            lower.contains("chicken") -> "chicken"
            lower.contains("dal")     -> "dal"
            else                      -> "other"
        }
    }
}