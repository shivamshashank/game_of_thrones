package com.brighter_bee.tech.game_of_thrones.features.character.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brighter_bee.tech.game_of_thrones.core.Resource
import com.brighter_bee.tech.game_of_thrones.features.character.domain.use_case.get_characters.GetCharacterUseCase
import com.brighter_bee.tech.game_of_thrones.features.house.domain.use_case.get_houses.GetHousesUseCase
import com.brighter_bee.tech.game_of_thrones.features.house.presentation.HouseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharacterState())
    val state: State<CharacterState> = _state

    init { getCharacters() }

    private fun getCharacters(){
        getCharacterUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CharacterState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CharacterState(characterList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CharacterState(error = result.message ?: "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }

}