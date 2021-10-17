package com.brighter_bee.tech.game_of_thrones.features.home.domain.use_case.get_random_quote

import com.brighter_bee.tech.game_of_thrones.core.Resource
import com.brighter_bee.tech.game_of_thrones.features.home.domain.model.RandomQuote
import com.brighter_bee.tech.game_of_thrones.features.home.domain.repository.RandomQuoteRepository
import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.dto.house.toHouse
import com.brighter_bee.tech.game_of_thrones.features.house.domain.model.House
import com.brighter_bee.tech.game_of_thrones.features.house.domain.repository.HouseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val randomQuoteRepository: RandomQuoteRepository,
) {

    operator fun invoke(): Flow<Resource<RandomQuote>> = flow {
        try {
            emit(Resource.Loading<RandomQuote>())
            val randomQuoteDto = randomQuoteRepository.getQuote()
            val randomQuote = RandomQuote(
                sentence = randomQuoteDto.sentence,
                characterName = randomQuoteDto.character.name,
            )
            emit(Resource.Success<RandomQuote>(randomQuote))
        } catch (e: HttpException){
            emit(Resource.Error<RandomQuote>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException){
            emit(Resource.Error<RandomQuote>("You are offline!"))
        }
    }

}