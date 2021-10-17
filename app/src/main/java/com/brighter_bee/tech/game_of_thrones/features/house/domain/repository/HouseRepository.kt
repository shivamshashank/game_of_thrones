package com.brighter_bee.tech.game_of_thrones.features.house.domain.repository

import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.dto.house.HouseDto

interface HouseRepository {

    suspend fun getHouses(): List<HouseDto>

}