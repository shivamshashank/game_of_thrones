package com.brighter_bee.tech.game_of_thrones.features.home.data.remote.repository

import com.brighter_bee.tech.game_of_thrones.features.home.data.remote.dto.RandomQuoteApi
import com.brighter_bee.tech.game_of_thrones.features.home.data.remote.dto.random_quote.RandomQuoteDto
import com.brighter_bee.tech.game_of_thrones.features.home.domain.repository.RandomQuoteRepository
import javax.inject.Inject

class RandomQuoteRepositoryImpl @Inject constructor(
    private val randomQuoteApi: RandomQuoteApi,
) : RandomQuoteRepository {

    override suspend fun getQuote(): RandomQuoteDto {
        return randomQuoteApi.getQuote()
    }

}