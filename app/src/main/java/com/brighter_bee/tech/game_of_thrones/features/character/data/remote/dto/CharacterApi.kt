package com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto

import com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto.character.CharacterDto
import retrofit2.http.GET

interface CharacterApi {

    @GET("v1/characters")
    suspend fun getCharacters(): List<CharacterDto>

}