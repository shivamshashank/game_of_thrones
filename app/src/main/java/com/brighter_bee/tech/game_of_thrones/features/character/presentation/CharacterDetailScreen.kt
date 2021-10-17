package com.brighter_bee.tech.game_of_thrones.features.character.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brighter_bee.tech.game_of_thrones.core.components.Heading
import com.brighter_bee.tech.game_of_thrones.core.methods.characterImageId
import com.brighter_bee.tech.game_of_thrones.features.character.domain.model.Character

@Composable
fun CharacterDetailScreen(character: Character) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Box {
            Image(
                painter = painterResource(id = characterImageId(character.slug)),
                contentDescription = character.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
                contentScale = ContentScale.FillBounds,
            )

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(color = MaterialTheme.colors.secondaryVariant)
                    .align(Alignment.BottomEnd),
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp,
                    ),
                )
            }

        }

        Spacer(modifier = Modifier.height(24.dp))

        Heading("House")

        Spacer(modifier = Modifier.height(24.dp))

        character.house?.let {
            Text(
                text = it.name,
                style = MaterialTheme.typography.h6.copy(color = Color.White),
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Heading("Quotes")

        LazyColumn(
            Modifier.padding(
                start = 24.dp,
                top = 24.dp,
                bottom = 4.dp,
                end = 24.dp,
            )
        ) {
            items(character.quotes) { quote ->
                Row(
                    modifier = Modifier.padding(bottom = 8.dp),
                ) {
                    Text(text = "* ", color = Color.White, fontSize = 24.sp)
                    Text(text = quote, color = Color.White, fontSize = 16.sp)
                }
            }
        }

    }

}