package com.bcoding.movieapp.persistence

import androidx.room.*
import com.bcoding.movieapp.models.entities.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE page = :page_")
    suspend fun getMovieList(page_: Long): List<Movie>

    @Query("SELECT * FROM movies WHERE id = :id_")
    suspend fun getMovieById(id_: Long): Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieList(movies: List<Movie>)

    @Update
    suspend fun updateMovie(movie: Movie)
}