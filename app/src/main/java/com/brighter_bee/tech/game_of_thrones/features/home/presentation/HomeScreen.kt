package com.brighter_bee.tech.game_of_thrones.features.home.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.brighter_bee.tech.game_of_thrones.core.components.ErrorText
import com.brighter_bee.tech.game_of_thrones.core.components.Heading
import com.brighter_bee.tech.game_of_thrones.core.components.LoadingIndicator
import com.brighter_bee.tech.game_of_thrones.features.character.presentation.CharacterViewModel
import com.brighter_bee.tech.game_of_thrones.features.character.presentation.components.CharacterListItem
import com.brighter_bee.tech.game_of_thrones.features.house.presentation.HouseViewModel
import com.brighter_bee.tech.game_of_thrones.features.house.presentation.components.HouseListItem

@Composable
fun HomeScreen(
    navController: NavController,
    houseViewModel: HouseViewModel = hiltViewModel(),
    randomQuoteViewModel: RandomQuoteViewModel = hiltViewModel(),
    characterViewModel: CharacterViewModel = hiltViewModel(),
) {

    val houseState = houseViewModel.state.value
    val randomQuoteState = randomQuoteViewModel.state.value
    val characterState = characterViewModel.state.value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        item {
            Spacer(Modifier.height(24.dp))

            Heading("Houses")

            when {
                houseState.isLoading -> LoadingIndicator()
                houseState.error.isNotBlank() -> ErrorText(errorMsg = houseState.error)
                else -> {
                    LazyRow(
                        Modifier.padding(
                            start = 24.dp,
                            top = 24.dp,
                            bottom = 24.dp,
                        )
                    ) {
                        items(houseState.houseList) { house -> HouseListItem(house, navController) }
                    }
                }
            }

            Heading("Quote")

            when {
                randomQuoteState.isLoading -> LoadingIndicator()
                randomQuoteState.error.isNotBlank() -> ErrorText(errorMsg = houseState.error)
                else -> {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 24.dp,vertical = 24.dp)
                            .border(
                                BorderStroke(2.dp, MaterialTheme.colors.secondary),
                                RoundedCornerShape(16.dp, 0.dp, 16.dp, 0.dp),
                            )
                            .fillMaxWidth(),
                    ) {
                        Text(
                            text = randomQuoteState.randomQuote!!.sentence,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(
                                    top = 12.dp,
                                    start = 16.dp,
                                    end = 16.dp,
                                ),
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "~ " + randomQuoteState.randomQuote.characterName,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(
                                    bottom = 12.dp,
                                    end = 16.dp,
                                ),
                        )
                    }
                }
            }

            Heading("Characters")

            when {
                characterState.isLoading -> LoadingIndicator()
                characterState.error.isNotBlank() -> ErrorText(errorMsg = characterState.error)
                else -> {
                    LazyRow(
                        Modifier.padding(
                            start = 24.dp,
                            top = 24.dp,
                            bottom = 4.dp,
                        )
                    ) {
                        items(characterState.characterList) { character -> CharacterListItem(character, navController) }
                    }
                }
            }
        }

    }

}