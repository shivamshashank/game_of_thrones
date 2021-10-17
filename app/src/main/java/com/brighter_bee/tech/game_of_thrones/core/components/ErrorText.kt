package com.brighter_bee.tech.game_of_thrones.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorText(errorMsg: String) {
    Text(
        text = errorMsg,
        color = MaterialTheme.colors.error,
        fontSize = 24.sp,
        modifier = Modifier.padding(horizontal = 20.dp),
    )
}