package com.brighter_bee.tech.game_of_thrones.features.house.data.remote.dto.house

import com.brighter_bee.tech.game_of_thrones.features.house.domain.model.House
import com.google.gson.annotations.SerializedName

data class HouseDto(
    @SerializedName("members")
    val members: List<Member>,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)

fun HouseDto.toHouse() : House{
    return House(
        slug,
        name,
        members,
    )
}