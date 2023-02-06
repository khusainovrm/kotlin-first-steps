package com.example.firstkotlin

interface FragmentClickListener {
    fun onChangeColorBackground()
}

fun generateActors(): List<Actor> {
    return listOf(
        Actor(name = "Rinat", avatar = "https://via.placeholder.com/600/92c952", hasOscar = true),
        Actor(name = "Arnold", avatar = "https://via.placeholder.com/600/56a8c2", hasOscar = false),
        Actor(name = "Deni", avatar = "https://via.placeholder.com/600/b0f7cc", hasOscar = false),
        Actor(name = "Dinara", avatar = "https://via.placeholder.com/600/f66b9", hasOscar = true),
        Actor(name = "Olivia", avatar = "https://via.placeholder.com/600/54176f", hasOscar = false),
        Actor(name = "Silver", avatar = "https://via.placeholder.com/600/51aa97", hasOscar = false),
        Actor(name = "Malika", avatar = "https://via.placeholder.com/600/771796", hasOscar = true),
        Actor(name = "Mina", avatar = "https://via.placeholder.com/600/810b14", hasOscar = false),
        Actor(name = "Maligan", avatar = "https://via.placeholder.com/600/1ee8a4", hasOscar =
        false),
        Actor(name = "Otto", avatar = "https://via.placeholder.com/600/66b7d2", hasOscar = false),

    )
}