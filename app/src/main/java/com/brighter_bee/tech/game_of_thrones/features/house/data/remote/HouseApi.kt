package com.brighter_bee.tech.game_of_thrones.features.house.data.remote

import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.dto.house.HouseDto
import retrofit2.http.GET

interface HouseApi {

    @GET("v1/houses")
    suspend fun getHouses(): List<HouseDto>

}