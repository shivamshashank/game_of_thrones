package com.brighter_bee.tech.game_of_thrones.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brighter_bee.tech.game_of_thrones.Screen
import com.brighter_bee.tech.game_of_thrones.features.home.presentation.HomeScreen
import com.brighter_bee.tech.game_of_thrones.SplashScreen
import com.brighter_bee.tech.game_of_thrones.features.character.domain.model.Character
import com.brighter_bee.tech.game_of_thrones.features.character.presentation.CharacterDetailScreen
import com.brighter_bee.tech.game_of_thrones.features.house.domain.model.House
import com.brighter_bee.tech.game_of_thrones.features.house.presentation.HouseDetailScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = Screen.SplashScreen.route,
    ){
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(Screen.HouseDetailScreen.route) {
            val house = navController.previousBackStackEntry?.savedStateHandle?.get<House>("house")
            house?.let { HouseDetailScreen(house) }
        }

        composable(Screen.CharacterDetailScreen.route) {
            val character = navController.previousBackStackEntry?.savedStateHandle?.get<Character>("character")
            character?.let { CharacterDetailScreen(character) }
        }
    }
}