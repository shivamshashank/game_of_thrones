package com.brighter_bee.tech.game_of_thrones

sealed class Screen(val route: String) {

    object SplashScreen: Screen("splash_screen")
    object HomeScreen: Screen("home_screen")
    object HouseDetailScreen: Screen("house_detail_screen")
    object CharacterDetailScreen: Screen("character_detail_screen")

}
