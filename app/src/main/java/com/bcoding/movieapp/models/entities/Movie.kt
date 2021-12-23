package com.bcoding.movieapp.models.entities

import java.util.*

data class Movie(
    var id: Long,
    var title: String,
    var original_title: String,
    var original_language: String,
    var overview: String,
    var popularity: Double,
    var adult: Boolean,
    var backdrop_path: String,
    var genre_ids: List<Int>,
    var poster_path: String,
    var release_date: Date,
    var video: Boolean,
    var vote_average: Float,
    var vote_count: Int
)