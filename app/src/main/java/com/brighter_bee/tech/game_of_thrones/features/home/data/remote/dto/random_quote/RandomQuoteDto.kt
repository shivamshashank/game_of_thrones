package com.brighter_bee.tech.game_of_thrones.features.home.data.remote.dto.random_quote


import com.google.gson.annotations.SerializedName

data class RandomQuoteDto(
    @SerializedName("character")
    val character: Character,
    @SerializedName("sentence")
    val sentence: String
)