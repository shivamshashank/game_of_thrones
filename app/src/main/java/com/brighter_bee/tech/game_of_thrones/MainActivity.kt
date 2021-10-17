package com.brighter_bee.tech.game_of_thrones

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.brighter_bee.tech.game_of_thrones.navigation.Navigation
import com.brighter_bee.tech.game_of_thrones.ui.theme.GameOfThronesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        setContent {
            GameOfThronesTheme {
                Surface(
                    color = MaterialTheme.colors.surface,
                ) {
                    Navigation()
                }
            }
        }
    }
}
