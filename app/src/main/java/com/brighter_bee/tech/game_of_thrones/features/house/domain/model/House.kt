package com.brighter_bee.tech.game_of_thrones.features.house.domain.model

import android.os.Parcelable
import com.brighter_bee.tech.game_of_thrones.features.house.data.remote.dto.house.Member
import kotlinx.parcelize.Parcelize

@Parcelize
data class House(
    val slug: String,
    val name: String,
    val members: List<Member>,
) : Parcelable