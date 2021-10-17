package com.brighter_bee.tech.game_of_thrones.features.home.data.remote.dto

import com.brighter_bee.tech.game_of_thrones.features.home.data.remote.dto.random_quote.RandomQuoteDto
import com.brighter_bee.tech.game_of_thrones.features.home.domain.model.RandomQuote
import retrofit2.http.GET

interface RandomQuoteApi {

    @GET("v1/random")
    suspend fun getQuote(): RandomQuoteDto

}