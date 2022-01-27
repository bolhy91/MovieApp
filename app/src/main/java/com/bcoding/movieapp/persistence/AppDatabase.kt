package com.bcoding.movieapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bcoding.movieapp.models.entities.Movie
import com.bcoding.movieapp.persistence.converters.GenreListConverter

@Database(entities = [Movie::class], version = 1)

@TypeConverters(
    value = [
        (GenreListConverter::class)
    ]
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}