package com.brighter_bee.tech.game_of_thrones.features.house.domain.use_case.get_houses

import com.brighter_bee.tech.game_of_thrones.core.Resource
import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.dto.house.toHouse
import com.brighter_bee.tech.game_of_thrones.features.house.domain.model.House
import com.brighter_bee.tech.game_of_thrones.features.house.domain.repository.HouseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHousesUseCase @Inject constructor(
    private val houseRepository: HouseRepository
) {

    operator fun invoke(): Flow<Resource<List<House>>> = flow {
        try {
            emit(Resource.Loading<List<House>>())
            val housesList = houseRepository.getHouses().map { it.toHouse() }
            emit(Resource.Success<List<House>>(housesList))
        } catch (e: HttpException){
            emit(Resource.Error<List<House>>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException){
            emit(Resource.Error<List<House>>("You are offline!"))
        }
    }

}