package com.bcoding.movieapp.datasource

import com.bcoding.movieapp.models.SeriesResponse
import retrofit2.http.GET

interface SeriesDataSource {
    @GET("/3/tv/popular?api_key=c597f96b64e654e060bb06a2b01d8a49")
    suspend fun getSeries(): SeriesResponse
}