package com.brighter_bee.tech.game_of_thrones.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    surface = primaryColor,
    primary = primaryColor,
    secondary = primaryDarkColor,
    secondaryVariant = primaryLightColor,
)

@Composable
fun GameOfThronesTheme(content: @Composable () -> Unit) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = appTypography,
        shapes = Shapes,
        content = content
    )
}