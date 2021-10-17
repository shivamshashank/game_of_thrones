package com.brighter_bee.tech.game_of_thrones.features.home.presentation

import com.brighter_bee.tech.game_of_thrones.features.home.domain.model.RandomQuote

data class RandomQuoteState(
    val isLoading: Boolean = false,
    val randomQuote: RandomQuote? = null,
    val error: String = "",
)