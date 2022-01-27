package com.bcoding.movieapp.models.network

import com.bcoding.movieapp.models.entities.Movie

data class MovieState(
    val isLoading: Boolean = false,
    val movie: Movie? = null,
    val error: String = ""
)