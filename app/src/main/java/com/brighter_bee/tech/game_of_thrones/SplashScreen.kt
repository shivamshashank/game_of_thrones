package com.brighter_bee.tech.game_of_thrones

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.brighter_bee.tech.game_of_thrones.core.Constants.splash_duration
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
) {
    LaunchedEffect(key1 = true) {
        delay(splash_duration)
        navController.navigate(Screen.HomeScreen.route) {
            popUpTo(Screen.SplashScreen.route) {
                inclusive = true
            }
        }
    }

    Box {
        Image(
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = "Splash Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
        )
    }
}