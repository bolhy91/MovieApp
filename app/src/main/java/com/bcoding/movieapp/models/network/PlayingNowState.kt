package com.bcoding.movieapp.models.network

import com.bcoding.movieapp.models.entities.Movie

data class PlayingNowState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)