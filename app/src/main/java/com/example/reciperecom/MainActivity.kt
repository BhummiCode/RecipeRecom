package com.example.reciperecom

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.reciperecom.data.FavouritesManager
import com.example.reciperecom.databinding.ActivityMainBinding
import com.example.reciperecom.ui.BrowseFragment
import com.example.reciperecom.ui.FavouritesFragment
import com.example.reciperecom.ui.HomeFragment
import com.example.reciperecom.ui.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FavouritesManager.loadFavourites(this)

        // Show user info in header
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            binding.tvUserName.text = "Hi, ${user.displayName?.split(" ")?.first() ?: "Chef"}! 👋"
            Glide.with(this)
                .load(user.photoUrl)
                .transform(CircleCrop())
                .into(binding.imgUserPhoto)
        }

        // Logout button
        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Load default fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment()).commit()

        binding.bottomNav.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_browse -> BrowseFragment()
                R.id.nav_favourites -> FavouritesFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment).commit()
            true
        }
    }
}