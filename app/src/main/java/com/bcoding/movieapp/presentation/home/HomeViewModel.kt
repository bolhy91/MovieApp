package com.bcoding.movieapp.presentation.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcoding.movieapp.MainScreenHomeTab
import com.bcoding.movieapp.models.network.PlayingNowState
import com.bcoding.movieapp.repository.MovieRepository
import com.bcoding.movieapp.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel(){

    private val _state: MutableState<PlayingNowState> = mutableStateOf(PlayingNowState())
    val state: State<PlayingNowState> = _state

    private val _selectedTab: MutableState<MainScreenHomeTab> =
        mutableStateOf(MainScreenHomeTab.HOME)
    val selectedTab: State<MainScreenHomeTab> get() = _selectedTab

    init {
        getPlayingNow()
    }

    fun selectTab(tab: MainScreenHomeTab) {
        _selectedTab.value = tab
    }

    private fun getPlayingNow() {
        movieRepository.getMovieNowPlaying(1).onEach { result ->
            when(result){
                is Result.Error -> {
                    Log.i("ENTRO ERROR: ", result.toString())
                    _state.value = PlayingNowState(error = result.message ?: "Internal error")
                }
                is Result.Loading -> {
                    Log.i("ENTRO CARGANDO: ", result.toString())
                    _state.value = PlayingNowState(isLoading = true)
                }
                is Result.Success -> {
                    Log.i("ENTRO CON LA DATA: ", result.toString())
                    _state.value = PlayingNowState(movies = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}