package com.bcoding.movieapp.di

import com.bcoding.movieapp.repository.MovieRepository
import com.bcoding.movieapp.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun movieRepository(movieRepository: MovieRepositoryImpl): MovieRepository
}