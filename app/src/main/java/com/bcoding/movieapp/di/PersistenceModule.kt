package com.bcoding.movieapp.di

import android.content.Context
import androidx.room.Room
import com.bcoding.movieapp.persistence.AppDatabase
import com.bcoding.movieapp.persistence.MovieDao
import com.bcoding.movieapp.persistence.SerieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "Movie.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideSerieDao(appDatabase: AppDatabase) : SerieDao {
        return appDatabase.serieDao()
    }
}