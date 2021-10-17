package com.brighter_bee.tech.game_of_thrones.features.character.domain.repository

import com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto.character.CharacterDto

interface CharacterRepository {

    suspend fun getCharacters(): List<CharacterDto>

}