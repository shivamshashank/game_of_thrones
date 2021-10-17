package com.brighter_bee.tech.game_of_thrones.features.house.data.repository

import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.HouseApi
import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.dto.house.HouseDto
import com.brighter_bee.tech.game_of_thrones.features.house.domain.repository.HouseRepository
import javax.inject.Inject

class HouseRepositoryImpl @Inject constructor(
    private val houseApi: HouseApi,
) : HouseRepository {

    override suspend fun getHouses(): List<HouseDto> {
        return houseApi.getHouses()
    }

}