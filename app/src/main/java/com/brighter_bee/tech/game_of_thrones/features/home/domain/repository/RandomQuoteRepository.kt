package com.brighter_bee.tech.game_of_thrones.features.home.domain.repository

import com.brighter_bee.tech.game_of_thrones.features.home.data.remote.dto.random_quote.RandomQuoteDto

interface RandomQuoteRepository {

    suspend fun getQuote(): RandomQuoteDto

}