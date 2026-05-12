package com.example.reciperecom.data

import com.example.reciperecom.model.Recipe

object RecipeRepository {

    val allRecipes = mutableListOf(
        Recipe(
            id = 1, name = "Spaghetti Bolognese", cuisine = "Italian", mood = "Comfort",
            ingredients = listOf("spaghetti", "minced beef", "tomato", "onion", "garlic", "olive oil", "basil"),
            steps = listOf("Boil pasta in salted water.", "Brown the beef in olive oil.", "Add chopped onion and garlic.", "Pour in tomato sauce.", "Simmer for 20 min.", "Combine with pasta and serve."),
            imageUrl = "https://media.istockphoto.com/id/1087833940/photo/traditional-pasta-spaghetti-bolognese-in-white-plate-on-wooden-table-background.jpg?s=612x612&w=0&k=20&c=uY_H8oWzidO1RyyLKIbVfAU5AWvRhGXDcnyXKkv6Wa4=",
            cookTimeMinutes = 35, chefName = "Gordon Ramsay",
            chefImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRye3D-p_oMewi3o9Hje8xngMYbdCf2wWUCcg&s",
            rating = 4.8f, difficulty = "Medium", calories = 520
        ),
        Recipe(
            id = 2, name = "Paneer Tikka", cuisine = "Indian", mood = "Festive",
            ingredients = listOf("paneer", "yogurt", "cumin", "turmeric", "bell pepper", "onion", "lemon"),
            steps = listOf("Cut paneer into cubes.", "Marinate with yogurt and spices.", "Skewer with veggies.", "Grill for 15 min.", "Serve with mint chutney."),
            imageUrl = "https://static.toiimg.com/thumb/128408985.jpg?photoid=128408985&imgsize=1507118&width=375&height=210&resizemode=75",
            cookTimeMinutes = 30, chefName = "Sanjeev Kapoor",
            chefImageUrl = "https://pbs.twimg.com/profile_images/911145420352450561/wJdHEVJv_400x400.jpg",
            rating = 4.7f, difficulty = "Easy", calories = 320
        ),
        Recipe(
            id = 3, name = "Avocado Toast", cuisine = "Western", mood = "Healthy",
            ingredients = listOf("sourdough bread", "avocado", "lemon juice", "chilli flakes", "salt", "olive oil"),
            steps = listOf("Toast the bread until golden.", "Mash avocado with lemon juice.", "Season with salt and chilli.", "Spread on toast.", "Drizzle olive oil and serve."),
            imageUrl = "https://cdn.prod.website-files.com/62a6520d16a4c82ce7aba2af/6321217d31f654796daabb20_avocado-toast-body.jpeg",
            cookTimeMinutes = 10, chefName = "Jamie Oliver",
            chefImageUrl = "https://restaurantindia.s3.ap-south-1.amazonaws.com/s3fs-public/content6882.jpg",
            rating = 4.5f, difficulty = "Easy", calories = 280
        ),
        Recipe(
            id = 4, name = "Chicken Tacos", cuisine = "Mexican", mood = "Quick",
            ingredients = listOf("tortillas", "chicken breast", "salsa", "cheddar cheese", "lettuce", "sour cream"),
            steps = listOf("Season and cook chicken.", "Slice into strips.", "Warm tortillas on pan.", "Assemble tacos.", "Top with salsa, cheese and sour cream."),
            imageUrl = "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg",
            cookTimeMinutes = 20, chefName = "Gordon Ramsay",
            chefImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRye3D-p_oMewi3o9Hje8xngMYbdCf2wWUCcg&s",
            rating = 4.6f, difficulty = "Easy", calories = 410
        ),
        Recipe(
            id = 5, name = "Mango Lassi", cuisine = "Indian", mood = "Quick",
            ingredients = listOf("ripe mango", "yogurt", "milk", "sugar", "cardamom", "ice"),
            steps = listOf("Peel and chop mango.", "Blend with yogurt and milk.", "Add sugar and cardamom.", "Blend until smooth.", "Serve chilled with ice."),
            imageUrl = "https://img.freepik.com/premium-photo/mango-lassi-parfait-isolated-white-background_787273-7889.jpg",
            cookTimeMinutes = 5, chefName = "Sanjeev Kapoor",
            chefImageUrl = "https://pbs.twimg.com/profile_images/911145420352450561/wJdHEVJv_400x400.jpg",
            rating = 4.9f, difficulty = "Easy", calories = 180
        ),
        Recipe(
            id = 6, name = "Greek Salad", cuisine = "Mediterranean", mood = "Healthy",
            ingredients = listOf("cucumber", "tomato", "kalamata olives", "feta cheese", "red onion", "olive oil", "oregano"),
            steps = listOf("Chop cucumber and tomato.", "Slice red onion.", "Combine all vegetables.", "Add feta and olives.", "Drizzle olive oil.", "Season with oregano and serve."),
            imageUrl = "https://media.istockphoto.com/id/636792302/photo/greek-salad.jpg?s=612x612&w=0&k=20&c=Ht65xqAMvAlI7WbPRXD_r_Qenmq-SLgjDDqq-In2SYY=",
            cookTimeMinutes = 10, chefName = "Jamie Oliver",
            chefImageUrl = "https://restaurantindia.s3.ap-south-1.amazonaws.com/s3fs-public/content6882.jpg",
            rating = 4.4f, difficulty = "Easy", calories = 220
        ),
        Recipe(
            id = 7, name = "Butter Chicken", cuisine = "Indian", mood = "Comfort",
            ingredients = listOf("chicken", "butter", "tomato puree", "cream", "garam masala", "ginger", "garlic"),
            steps = listOf("Marinate chicken in spices.", "Cook chicken in butter.", "Add tomato puree and simmer.", "Pour in cream.", "Cook for 15 min.", "Serve with naan."),
            imageUrl = "https://t3.ftcdn.net/jpg/06/01/41/68/360_F_601416862_AfYdeefqT1kGqWTx1DZCsJZVzYIDFzPR.jpg",
            cookTimeMinutes = 40, chefName = "Sanjeev Kapoor",
            chefImageUrl = "https://pbs.twimg.com/profile_images/911145420352450561/wJdHEVJv_400x400.jpg",
            rating = 4.9f, difficulty = "Medium", calories = 490
        ),
        Recipe(
            id = 8, name = "Margherita Pizza", cuisine = "Italian", mood = "Comfort",
            ingredients = listOf("pizza dough", "tomato sauce", "mozzarella", "basil", "olive oil", "salt"),
            steps = listOf("Preheat oven to 220°C.", "Roll out dough.", "Spread tomato sauce.", "Add mozzarella.", "Bake for 12 min.", "Top with fresh basil."),
            imageUrl = "https://www.themealdb.com/images/media/meals/x0lk931587671540.jpg",
            cookTimeMinutes = 25, chefName = "Gordon Ramsay",
            chefImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRye3D-p_oMewi3o9Hje8xngMYbdCf2wWUCcg&s",
            rating = 4.7f, difficulty = "Medium", calories = 580
        ),
        Recipe(
            id = 9, name = "Caesar Salad", cuisine = "Western", mood = "Healthy",
            ingredients = listOf("romaine lettuce", "croutons", "parmesan", "caesar dressing", "lemon", "black pepper"),
            steps = listOf("Wash and chop lettuce.", "Make or pour caesar dressing.", "Toss lettuce with dressing.", "Add croutons and parmesan.", "Season and serve."),
            imageUrl = "https://media.istockphoto.com/id/184938052/photo/a-bowl-of-caesar-salad-with-croutons-and-cheese-on-table.jpg",
            cookTimeMinutes = 15, chefName = "Jamie Oliver",
            chefImageUrl = "https://restaurantindia.s3.ap-south-1.amazonaws.com/s3fs-public/content6882.jpg",
            rating = 4.5f, difficulty = "Easy", calories = 310
        ),
        Recipe(
            id = 10, name = "Beef Tacos", cuisine = "Mexican", mood = "Festive",
            ingredients = listOf("beef mince", "taco shells", "cheese", "tomato", "lettuce", "taco seasoning"),
            steps = listOf("Cook beef with seasoning.", "Warm taco shells.", "Fill with beef.", "Add toppings.", "Serve immediately."),
            imageUrl = "https://media.istockphoto.com/id/1333647378/photo/homemade-american-soft-shell-beef-tacos.jpg?s=612x612&w=0&k=20&c=ZHhpFNbH_BO4MaXzmcKLjC4cPRptdXlp6IVUfs1sBEs=",
            cookTimeMinutes = 25, chefName = "Gordon Ramsay",
            chefImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRye3D-p_oMewi3o9Hje8xngMYbdCf2wWUCcg&s",
            rating = 4.6f, difficulty = "Easy", calories = 450
        ),
        Recipe(
            id = 11, name = "Pasta Carbonara", cuisine = "Italian", mood = "Comfort",
            ingredients = listOf("pasta", "eggs", "pancetta", "parmesan", "black pepper", "salt"),
            steps = listOf("Cook pasta al dente.", "Fry pancetta until crispy.", "Mix eggs and parmesan.", "Combine pasta with pancetta.", "Add egg mixture off heat.", "Toss and serve."),
            imageUrl = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
            cookTimeMinutes = 30, chefName = "Gordon Ramsay",
            chefImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRye3D-p_oMewi3o9Hje8xngMYbdCf2wWUCcg&s",
            rating = 4.8f, difficulty = "Medium", calories = 610
        ),
        Recipe(
            id = 12, name = "Dal Tadka", cuisine = "Indian", mood = "Comfort",
            ingredients = listOf("yellow dal", "onion", "tomato", "cumin", "mustard seeds", "garlic", "ghee"),
            steps = listOf("Boil dal until soft.", "Heat ghee in pan.", "Add cumin and mustard seeds.", "Add onion and garlic.", "Pour over dal.", "Simmer and serve with rice."),
            imageUrl = "https://www.themealdb.com/images/media/meals/wuxrtu1483564410.jpg",
            cookTimeMinutes = 30, chefName = "Sanjeev Kapoor",
            chefImageUrl = "https://pbs.twimg.com/profile_images/911145420352450561/wJdHEVJv_400x400.jpg",
            rating = 4.7f, difficulty = "Easy", calories = 280
        ),
        Recipe(
            id = 13, name = "Shahi Paneer", cuisine = "Indian", mood = "Festive",
            ingredients = listOf("paneer", "cream", "cashews", "onion", "tomato", "cardamom", "saffron"),
            steps = listOf("Soak cashews and blend.", "Cook onion and tomato.", "Add spices and cream.", "Add paneer cubes.", "Simmer for 10 min.", "Garnish with saffron."),
            imageUrl = "https://t4.ftcdn.net/jpg/07/27/22/19/360_F_727221901_pYUxK4G1WZKHHmz2qHikfPLaBJC3UTQp.jpg",
            cookTimeMinutes = 35, chefName = "Sanjeev Kapoor",
            chefImageUrl = "https://pbs.twimg.com/profile_images/911145420352450561/wJdHEVJv_400x400.jpg",
            rating = 4.8f, difficulty = "Medium", calories = 420
        ),
        Recipe(
            id = 14, name = "Chilli Paneer", cuisine = "Indian", mood = "Quick",
            ingredients = listOf("paneer", "bell pepper", "chilli sauce", "soy sauce", "onion", "garlic", "cornflour"),
            steps = listOf("Fry paneer until golden.", "Saute onion and peppers.", "Add sauces and mix.", "Add paneer.", "Toss and serve hot."),
            imageUrl = "https://t3.ftcdn.net/jpg/07/58/00/54/360_F_758005417_IH0OzF2WzrFspDrIxCEMr6zl5PAMt4S2.jpg",
            cookTimeMinutes = 20, chefName = "Sanjeev Kapoor",
            chefImageUrl = "https://pbs.twimg.com/profile_images/911145420352450561/wJdHEVJv_400x400.jpg",
            rating = 4.6f, difficulty = "Easy", calories = 380
        ),
        Recipe(
            id = 15, name = "Matar Paneer", cuisine = "Indian", mood = "Comfort",
            ingredients = listOf("paneer", "green peas", "tomato", "onion", "cumin", "garam masala", "ginger"),
            steps = listOf("Cook onion and tomato gravy.", "Add spices.", "Add peas and cook.", "Add paneer cubes.", "Simmer for 10 min.", "Serve with roti."),
            imageUrl = "https://t4.ftcdn.net/jpg/10/59/45/99/360_F_1059459954_OzKZb6YyIkR0jbfxDY5HEsr7L9PWdmKn.jpg",
            cookTimeMinutes = 30, chefName = "Sanjeev Kapoor",
            chefImageUrl = "https://pbs.twimg.com/profile_images/911145420352450561/wJdHEVJv_400x400.jpg",
            rating = 4.7f, difficulty = "Easy", calories = 350
        ),
        Recipe(
            id = 16, name = "Pepperoni Pizza", cuisine = "Italian", mood = "Comfort",
            ingredients = listOf("pizza dough", "tomato sauce", "mozzarella", "pepperoni", "olive oil", "oregano"),
            steps = listOf("Preheat oven to 220°C.", "Roll out dough.", "Spread sauce.", "Add cheese and pepperoni.", "Bake for 15 min.", "Serve hot."),
            imageUrl = "https://t3.ftcdn.net/jpg/06/39/44/24/360_F_639442426_W9G5DE7oldar0ANlS6AJ39kYFdAh9BKg.jpg",
            cookTimeMinutes = 30, chefName = "Gordon Ramsay",
            chefImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRye3D-p_oMewi3o9Hje8xngMYbdCf2wWUCcg&s",
            rating = 4.8f, difficulty = "Medium", calories = 620
        ),
        Recipe(
            id = 17, name = "BBQ Chicken Pizza", cuisine = "Italian", mood = "Festive",
            ingredients = listOf("pizza dough", "bbq sauce", "chicken", "mozzarella", "red onion", "cilantro"),
            steps = listOf("Cook chicken with BBQ sauce.", "Roll out dough.", "Spread BBQ sauce.", "Add chicken and cheese.", "Bake for 15 min.", "Top with cilantro."),
            imageUrl = "https://thumbs.dreamstime.com/b/summertime-feast-gourmet-bbq-chicken-pizza-captured-stunning-landscape-photography-indulge-your-senses-353693018.jpg",
            cookTimeMinutes = 35, chefName = "Jamie Oliver",
            chefImageUrl = "https://restaurantindia.s3.ap-south-1.amazonaws.com/s3fs-public/content6882.jpg",
            rating = 4.7f, difficulty = "Medium", calories = 590
        ),
        Recipe(
            id = 18, name = "Veggie Burger", cuisine = "Western", mood = "Quick",
            ingredients = listOf("burger bun", "veggie patty", "lettuce", "tomato", "cheese", "mayo", "mustard"),
            steps = listOf("Cook veggie patty.", "Toast the bun.", "Add lettuce and tomato.", "Place patty.", "Add cheese and sauces.", "Serve with fries."),
            imageUrl = "https://img.freepik.com/premium-photo/vegan-chickpea-veggie-burger-with-freshly-baked-bun-topped-with-sesame-seeds-lettuce-salad-black-plate-landscape-view-close-up-macro_268847-1310.jpg",
            cookTimeMinutes = 15, chefName = "Jamie Oliver",
            chefImageUrl = "https://restaurantindia.s3.ap-south-1.amazonaws.com/s3fs-public/content6882.jpg",
            rating = 4.4f, difficulty = "Easy", calories = 450
        ),
        Recipe(
            id = 19, name = "Chicken Burger", cuisine = "Western", mood = "Quick",
            ingredients = listOf("burger bun", "chicken fillet", "lettuce", "tomato", "cheese", "mayo", "pickles"),
            steps = listOf("Fry or grill chicken.", "Toast the bun.", "Add lettuce and tomato.", "Place chicken fillet.", "Add cheese and mayo.", "Serve hot."),
            imageUrl = "https://media.istockphoto.com/id/521207406/photo/southern-country-fried-chicken-sandwich.jpg?s=612x612&w=0&k=20&c=XfttLSxEO2YAjop4Gy0CIb1L5N_OK1tTKxmkiPr3QD8=",
            cookTimeMinutes = 20, chefName = "Gordon Ramsay",
            chefImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRye3D-p_oMewi3o9Hje8xngMYbdCf2wWUCcg&s",
            rating = 4.6f, difficulty = "Easy", calories = 520
        )
    )

    fun getByIngredient(ingredient: String) =
        allRecipes.filter { r -> r.ingredients.any { it.contains(ingredient, ignoreCase = true) } }

    fun getByCuisine(cuisine: String) =
        if (cuisine == "All") allRecipes else allRecipes.filter { it.cuisine == cuisine }

    fun getByMood(mood: String) =
        if (mood == "All") allRecipes else allRecipes.filter { it.mood == mood }

    fun getByDifficulty(difficulty: String) =
        if (difficulty == "All") allRecipes else allRecipes.filter { it.difficulty == difficulty }

    fun getFavourites() = allRecipes.filter { it.isFavourite }

    val cuisines = listOf("All", "Italian", "Indian", "Mexican", "Mediterranean", "Western")
    val moods    = listOf("All", "Quick", "Healthy", "Festive", "Comfort")
    val difficulties = listOf("All", "Easy", "Medium", "Hard")
}