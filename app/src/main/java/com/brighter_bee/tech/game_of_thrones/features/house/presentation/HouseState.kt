package com.brighter_bee.tech.game_of_thrones.features.house.presentation

import com.brighter_bee.tech.game_of_thrones.features.house.domain.model.House

data class HouseState(
    val isLoading: Boolean = false,
    val houseList: List<House> = emptyList(),
    val error: String = "",
)