package com.bcoding.movieapp.models

import androidx.compose.runtime.Immutable
import com.bcoding.movieapp.models.entities.Movie

@Immutable
data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Long,
    val dates: Any
)