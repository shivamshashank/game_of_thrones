package com.brighter_bee.tech.game_of_thrones.features.character.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.brighter_bee.tech.game_of_thrones.Screen
import com.brighter_bee.tech.game_of_thrones.core.methods.characterImageId
import com.brighter_bee.tech.game_of_thrones.features.character.domain.model.Character

@Composable
fun CharacterListItem(
    character: Character,
    navController: NavController,
) {

    Column(modifier = Modifier.padding(end = 24.dp)) {

        Image(
            painter = painterResource(id = characterImageId(character.slug)),
            contentDescription = character.name,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .size(width = 200.dp,height = 240.dp)
                .clickable {
                    navController.currentBackStackEntry?.savedStateHandle?.set("character", character)
                    navController.navigate(Screen.CharacterDetailScreen.route)
                },
            contentScale = ContentScale.FillBounds,
        )
        Text(
            text = character.name,
            modifier = Modifier.padding(start = 2.dp,top = 4.dp),
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.W500,
                color = Color.White,
            ),
        )
    }
}