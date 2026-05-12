package com.example.reciperecom.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reciperecom.R
import com.example.reciperecom.adapter.RecipeAdapter
import com.example.reciperecom.data.RecipeRepository

class FavouritesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_favourites, container, false)

        val rv = view.findViewById<RecyclerView>(R.id.recyclerView)
        val emptyText = view.findViewById<TextView>(R.id.tvEmpty)

        val favourites = RecipeRepository.getFavourites()

        if (favourites.isEmpty()) {
            rv.visibility = View.GONE
            emptyText.visibility = View.VISIBLE
        } else {
            rv.visibility = View.VISIBLE
            emptyText.visibility = View.GONE
            rv.layoutManager = LinearLayoutManager(requireContext())
            rv.adapter = RecipeAdapter(
                favourites,
                onClick = { recipe ->
                    val intent = Intent(requireContext(), DetailActivity::class.java)
                    intent.putExtra("RECIPE_ID", recipe.id)
                    startActivity(intent)
                },
                onFavouriteClick = {}
            )
        }

        return view
    }
}