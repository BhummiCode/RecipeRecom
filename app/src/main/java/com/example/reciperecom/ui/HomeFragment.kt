package com.example.reciperecom.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reciperecom.R
import com.example.reciperecom.adapter.RecipeAdapter
import com.example.reciperecom.data.RecipeRepository

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val rv = view.findViewById<RecyclerView>(R.id.recyclerView)
        val searchBar = view.findViewById<EditText>(R.id.etSearch)
        val moodSpinner = view.findViewById<Spinner>(R.id.spinnerMood)

        rv.layoutManager = LinearLayoutManager(requireContext())
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

        // Mood spinner
        val moodAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            RecipeRepository.moods
        )
        moodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        moodSpinner.adapter = moodAdapter
        moodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p: AdapterView<*>?, v: View?, pos: Int, id: Long) {
                val mood = RecipeRepository.moods[pos]
                adapter.updateList(RecipeRepository.getByMood(mood))
            }
            override fun onNothingSelected(p: AdapterView<*>?) {}
        }

        // Ingredient search
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString()
                adapter.updateList(
                    if (query.isBlank()) RecipeRepository.allRecipes
                    else RecipeRepository.getByIngredient(query)
                )
            }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })

        return view
    }
}