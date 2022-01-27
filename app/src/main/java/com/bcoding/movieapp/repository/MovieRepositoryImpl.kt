package com.bcoding.movieapp.repository

import com.bcoding.movieapp.datasource.MovieDataSource
import com.bcoding.movieapp.models.entities.Movie
import com.bcoding.movieapp.persistence.MovieDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface MovieRepository {
    fun getMovieNowPlaying(page: Int): Flow<Result<List<Movie>>>
    fun getMovieId(movieId: Long): Flow<Result<Movie>>
}

class MovieRepositoryImpl
@Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val movieDao: MovieDao
) : MovieRepository {

    override fun getMovieNowPlaying(page: Int): Flow<Result<List<Movie>>> = flow<Result<List<Movie>>> {
        try {
            // Capture movies the database
            var movies = movieDao.getMovieList(1)
            // If not exist movies, get api service
            if (movies.isEmpty()) {
                emit(Result.Loading())
                val response = movieDataSource.getMovieNowPlaying()
                movies = response.results
                movies.forEach { it.page  = page }
                movieDao.insertMovieList(movies)
                emit(Result.Success(data = response.results))
            } else {
                emit(Result.Success(data = movies))
            }
        } catch (e: Exception) {
            emit(Result.Error(message = e.localizedMessage ?: "Internal error"))
        }
    }

    override fun getMovieId(movieId: Long) = flow<Result<Movie>> {
        try {
            val movie = movieDao.getMovieById(movieId)
            emit(Result.Success(data = movie))
        } catch (e: Exception) {
            emit(Result.Error(message = "Internal Error: ${e.localizedMessage}"))
        }
    }
}