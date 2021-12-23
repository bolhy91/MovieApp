package com.bcoding.movieapp.di

import com.bcoding.movieapp.network.Api
import com.bcoding.movieapp.datasource.MovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Api.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviePlayingNow(retrofit: Retrofit): MovieDataSource {
        return retrofit.create(MovieDataSource::class.java)
    }
}