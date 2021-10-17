package com.brighter_bee.tech.game_of_thrones.features.home.data.remote.dto.random_quote


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("house")
    val house: House,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)