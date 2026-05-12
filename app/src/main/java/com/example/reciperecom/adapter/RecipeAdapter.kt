package com.example.reciperecom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.reciperecom.R
import com.example.reciperecom.data.FavouritesManager
import com.example.reciperecom.model.Recipe

class RecipeAdapter(
    private var recipes: List<Recipe>,
    private val onClick: (Recipe) -> Unit,
    private val onFavouriteClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView      = view.findViewById(R.id.imgRecipe)
        val name: TextView        = view.findViewById(R.id.tvName)
        val cuisine: TextView     = view.findViewById(R.id.tvCuisine)
        val time: TextView        = view.findViewById(R.id.tvTime)
        val favBtn: ImageView     = view.findViewById(R.id.btnFavourite)
        val chefImg: ImageView    = view.findViewById(R.id.imgChef)
        val chefName: TextView    = view.findViewById(R.id.tvChefName)
        val rating: TextView      = view.findViewById(R.id.tvRating)
        val calories: TextView    = view.findViewById(R.id.tvCalories)
        val difficulty: TextView  = view.findViewById(R.id.tvDifficulty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]

        // Recipe image
        Glide.with(holder.itemView.context)
            .load(recipe.imageUrl)
            .placeholder(R.drawable.img_bolognese)
            .centerCrop()
            .into(holder.image)

        // Chef image (circular)
        Glide.with(holder.itemView.context)
            .load(recipe.chefImageUrl)
            .transform(CircleCrop())
            .placeholder(R.drawable.ic_browse)
            .error(R.drawable.ic_fav_filled)
            .into(holder.chefImg)

        holder.name.text       = recipe.name
        holder.cuisine.text    = recipe.cuisine
        holder.time.text       = "⏱ ${recipe.cookTimeMinutes} min"
        holder.chefName.text   = "Chef ${recipe.chefName}"
        holder.rating.text     = "⭐ ${recipe.rating}"
        holder.calories.text   = "🔥 ${recipe.calories} cal"
        holder.difficulty.text = recipe.difficulty

        // Difficulty color
        val diffColor = when (recipe.difficulty) {
            "Easy"   -> "#4CAF50"
            "Medium" -> "#FF9800"
            "Hard"   -> "#F44336"
            else     -> "#000000"
        }
        holder.difficulty.setBackgroundColor(
            android.graphics.Color.parseColor(diffColor)
        )

        holder.favBtn.setImageResource(
            if (recipe.isFavourite) R.drawable.ic_fav_filled
            else R.drawable.ic_fav_outline
        )

        holder.itemView.setOnClickListener { onClick(recipe) }

        holder.favBtn.setOnClickListener {
            recipe.isFavourite = !recipe.isFavourite
            FavouritesManager.saveFavourite(
                holder.itemView.context,
                recipe.id,
                recipe.isFavourite
            )
            notifyItemChanged(position)
            onFavouriteClick(recipe)
        }
    }

    override fun getItemCount() = recipes.size

    fun updateList(newList: List<Recipe>) {
        recipes = newList
        notifyDataSetChanged()
    }
}