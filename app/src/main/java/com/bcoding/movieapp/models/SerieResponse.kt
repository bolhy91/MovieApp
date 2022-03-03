package com.bcoding.movieapp.models

import com.bcoding.movieapp.models.entities.Serie
import javax.annotation.concurrent.Immutable

@Immutable
data class SeriesResponse(
    val page: Int,
    val results: List<Serie>,
    val total_pages: Int,
    val total_results: Int
)