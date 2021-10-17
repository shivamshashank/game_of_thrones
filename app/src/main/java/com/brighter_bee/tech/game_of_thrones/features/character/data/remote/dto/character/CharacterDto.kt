package com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto.character


import com.brighter_bee.tech.game_of_thrones.features.character.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("house")
    val house: House? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("quotes")
    val quotes: List<String>,
    @SerializedName("slug")
    val slug: String
)

fun CharacterDto.toCharacter() : Character{
    return Character(
        house,
        name,
        quotes,
        slug,
    )
}