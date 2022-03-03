package com.bcoding.movieapp.models.network

import com.bcoding.movieapp.models.entities.Serie

data class SerieState(
    val isLoading: Boolean = false,
    val series: List<Serie> = emptyList(),
    val error: String = ""
)