package com.bcoding.movieapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bcoding.movieapp.models.entities.Movie
import com.bcoding.movieapp.models.entities.Serie
import com.bcoding.movieapp.persistence.converters.GenreListConverter
import com.bcoding.movieapp.persistence.converters.OriginCountryListConverter

@Database(entities = [Movie::class, Serie::class], version = 1)

@TypeConverters(
    value = [
        (GenreListConverter::class),
        (OriginCountryListConverter::class)
    ]
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun serieDao(): SerieDao
}