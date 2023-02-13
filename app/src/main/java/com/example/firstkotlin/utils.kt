package com.example.firstkotlin

interface FragmentClickListener {
    fun onChangeColorBackground()
}

fun generateActors(): List<Actor> {
    return listOf(
        Actor(name = "Adam", hasOscar = false),
        Actor(name = "Ronaldo", hasOscar = true),
        Actor(name = "Will", hasOscar = false),
        Actor(name = "Dorina", hasOscar = true),
        Actor(name = "Mateo", hasOscar = false),
        Actor(name = "Michaelle", hasOscar = true),
        Actor(name = "Dorian", hasOscar = false),
        Actor(name = "Patrik", hasOscar = false),
        Actor(name = "Leo", hasOscar = false),
    )
}