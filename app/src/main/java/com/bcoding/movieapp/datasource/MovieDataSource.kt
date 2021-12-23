package com.bcoding.movieapp.datasource

import com.bcoding.movieapp.models.MovieResponse
import retrofit2.http.GET

interface MovieDataSource {

    @GET("/3/movie/now_playing?api_key=c597f96b64e654e060bb06a2b01d8a49")
    suspend fun getMovieNowPlaying(): MovieResponse
}
