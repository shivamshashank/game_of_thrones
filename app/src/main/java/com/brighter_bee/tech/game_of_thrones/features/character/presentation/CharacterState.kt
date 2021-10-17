package com.brighter_bee.tech.game_of_thrones.features.character.presentation

import com.brighter_bee.tech.game_of_thrones.features.character.domain.model.Character

data class CharacterState(
    val isLoading: Boolean = false,
    val characterList: List<Character> = emptyList(),
    val error: String = "",
)