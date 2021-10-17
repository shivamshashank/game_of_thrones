package com.brighter_bee.tech.game_of_thrones.features.house.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brighter_bee.tech.game_of_thrones.core.Resource
import com.brighter_bee.tech.game_of_thrones.features.house.domain.use_case.get_houses.GetHousesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HouseViewModel @Inject constructor(
    private val getHousesUseCase: GetHousesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HouseState())
    val state: State<HouseState> = _state

    init { getHouses() }

    private fun getHouses(){
        getHousesUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = HouseState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = HouseState(houseList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = HouseState(error = result.message ?: "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }

}