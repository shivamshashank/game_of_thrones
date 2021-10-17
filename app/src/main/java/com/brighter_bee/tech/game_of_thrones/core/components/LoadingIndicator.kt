package com.brighter_bee.tech.game_of_thrones.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoadingIndicator() {
    CircularProgressIndicator(
        color = Color.White,
        modifier = Modifier.padding(vertical = 32.dp),
    )
}