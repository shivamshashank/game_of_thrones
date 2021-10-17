package com.brighter_bee.tech.game_of_thrones.features.character.domain.use_case.get_characters

import com.brighter_bee.tech.game_of_thrones.core.Resource
import com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto.character.toCharacter
import com.brighter_bee.tech.game_of_thrones.features.character.domain.model.Character
import com.brighter_bee.tech.game_of_thrones.features.character.domain.repository.CharacterRepository
import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.dto.house.toHouse
import com.brighter_bee.tech.game_of_thrones.features.house.domain.model.House
import com.brighter_bee.tech.game_of_thrones.features.house.domain.repository.HouseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {

    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading<List<Character>>())
            val charactersList = characterRepository.getCharacters().map { it.toCharacter() }
            emit(Resource.Success<List<Character>>(charactersList))
        } catch (e: HttpException){
            emit(Resource.Error<List<Character>>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException){
            emit(Resource.Error<List<Character>>("You are offline!"))
        }
    }

}