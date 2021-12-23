package com.bcoding.movieapp.repository

import android.util.Log
import com.bcoding.movieapp.datasource.MovieDataSource
import com.bcoding.movieapp.models.entities.Movie
import javax.inject.Inject

interface MovieRepository {
    suspend fun getMovieNowPlaying(): List<Movie>
}

class MovieRepositoryImpl
@Inject constructor(
    private val movieDataSource: MovieDataSource
) : MovieRepository {

    override suspend fun getMovieNowPlaying(): List<Movie> {
        val movies = movieDataSource.getMovieNowPlaying()
        Log.i("RESULTADO: ", movies.toString())
        return movies.results
    }
}