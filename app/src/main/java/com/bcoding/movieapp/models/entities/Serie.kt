package com.bcoding.movieapp.models.entities

import androidx.room.Entity

@Entity(primaryKeys = [("id")], tableName = "series")
data class Serie(
    val id: Long,
    val name: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val origin_country: List<String>,
    val original_language: String,
    val poster_path: String?,
    val backdrop_path: String?,
    val vote_average: Double,
    val vote_count: Double,
    var page: Int
)