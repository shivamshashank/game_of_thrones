package com.brighter_bee.tech.game_of_thrones.features.character.data.repository

import com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto.CharacterApi
import com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto.character.CharacterDto
import com.brighter_bee.tech.game_of_thrones.features.character.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterApi: CharacterApi,
) : CharacterRepository {

    override suspend fun getCharacters(): List<CharacterDto> {
        return characterApi.getCharacters()
    }

}