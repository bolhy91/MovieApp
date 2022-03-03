package com.bcoding.movieapp.persistence

import androidx.room.*
import com.bcoding.movieapp.models.entities.Serie

@Dao
interface SerieDao {
    @Query("SELECT * FROM series WHERE page = :page_")
    suspend fun getSerieList(page_: Long) : List<Serie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSerieList(series: List<Serie>)

    @Update
    suspend fun updateSerie(serie: Serie)
}