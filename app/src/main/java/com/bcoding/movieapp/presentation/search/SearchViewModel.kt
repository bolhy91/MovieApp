package com.bcoding.movieapp.presentation.search

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcoding.movieapp.models.network.SerieState
import com.bcoding.movieapp.repository.MovieRepository
import com.bcoding.movieapp.repository.Result
import com.bcoding.movieapp.repository.SerieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val serieRepository: SerieRepository
): ViewModel() {
    private val _state: MutableState<SerieState> = mutableStateOf(SerieState())
    val state: State<SerieState> = _state

    init {
        getSeriesList()
    }

    private fun getSeriesList() {
        serieRepository.getSeriePopular(1).onEach { result ->
            when(result) {
                is Result.Error -> {
                    Log.i("ENTER ERROR GET SERIES", result.toString())
                    _state.value = SerieState(error = result.message ?: "Internal error: getSeries")
                }
                is Result.Loading -> {
                    Log.i("ENTER LOADING SERIES", result.toString())
                    _state.value = SerieState(isLoading = true)
                }
                is Result.Success -> {
                    Log.i("SUCCESS SERIES LIST: ", result.toString())
                    _state.value = SerieState(series = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}