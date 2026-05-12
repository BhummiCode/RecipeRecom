package com.example.reciperecom.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reciperecom.R
import com.example.reciperecom.adapter.RecipeAdapter
import com.example.reciperecom.data.RecipeRepository
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class BrowseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_browse, container, false)

        val rv = view.findViewById<RecyclerView>(R.id.recyclerView)
        val chipGroup = view.findViewById<ChipGroup>(R.id.filterChips)

        rv.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = RecipeAdapter(
            RecipeRepository.allRecipes,
            onClick = { recipe ->
                val intent = Intent(requireContext(), DetailActivity::class.java)
                intent.putExtra("RECIPE_ID", recipe.id)
                startActivity(intent)
            },
            onFavouriteClick = {}
        )
        rv.adapter = adapter

        // Cuisine chips
        RecipeRepository.cuisines.forEach { cuisine ->
            val chip = Chip(requireContext())
            chip.text = cuisine
            chip.isCheckable = true
            chip.setOnCheckedChangeListener { _, checked ->
                if (checked) adapter.updateList(RecipeRepository.getByCuisine(cuisine))
            }
            chipGroup.addView(chip)
        }
        return view
    }
}