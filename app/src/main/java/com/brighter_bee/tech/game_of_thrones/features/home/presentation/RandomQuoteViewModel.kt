package com.brighter_bee.tech.game_of_thrones.features.home.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brighter_bee.tech.game_of_thrones.core.Resource
import com.brighter_bee.tech.game_of_thrones.features.home.domain.use_case.get_random_quote.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RandomQuoteViewModel @Inject constructor(
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    private val _state = mutableStateOf(RandomQuoteState())
    val state: State<RandomQuoteState> = _state

    init { getRandomQuote() }

    private fun getRandomQuote(){
        getRandomQuoteUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = RandomQuoteState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = RandomQuoteState(randomQuote = result.data)
                }
                is Resource.Error -> {
                    _state.value = RandomQuoteState(error = result.message ?: "An unexpected error occurred!")
                }
            }
        }.launchIn(viewModelScope)
    }

}