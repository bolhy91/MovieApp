package com.bcoding.movieapp.presentation.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcoding.movieapp.models.network.MovieState
import com.bcoding.movieapp.repository.MovieRepository
import com.bcoding.movieapp.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _state: MutableState<MovieState> = mutableStateOf(MovieState())
    val state: State<MovieState> = _state

    fun getMovie(movieId: Long) {
        movieRepository.getMovieId(movieId = movieId).onEach { result ->
            when (result) {
                is Result.Error -> _state.value =
                    MovieState(error = result.message ?: "unexpected error")
                is Result.Loading -> _state.value = MovieState(isLoading = true)
                is Result.Success -> _state.value = MovieState(movie = result.data)
            }
        }.launchIn(viewModelScope)
    }
}