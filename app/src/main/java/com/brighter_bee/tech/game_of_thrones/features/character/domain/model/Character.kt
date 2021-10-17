package com.brighter_bee.tech.game_of_thrones.features.character.domain.model

import android.os.Parcelable
import com.brighter_bee.tech.game_of_thrones.features.character.data.remote.dto.character.House
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val house: House?,
    val name: String,
    val quotes: List<String>,
    val slug: String,
) : Parcelable