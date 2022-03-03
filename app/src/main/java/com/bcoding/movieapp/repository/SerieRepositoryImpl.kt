package com.bcoding.movieapp.repository

import com.bcoding.movieapp.datasource.SeriesDataSource
import com.bcoding.movieapp.models.entities.Serie
import com.bcoding.movieapp.persistence.SerieDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

interface SerieRepository {
    fun getSeriePopular(page: Int): Flow<Result<List<Serie>>>
    fun getSerieId(serieId: Long): Flow<Result<Serie>>
}

class SerieRepositoryImpl
@Inject constructor(
    private val seriesDataSource: SeriesDataSource,
    private val serieDao: SerieDao
) : SerieRepository{
    override fun getSeriePopular(page: Int): Flow<Result<List<Serie>>> = flow<Result<List<Serie>>> {
        try {
            var series = serieDao.getSerieList(1)
            if (series.isEmpty()){
                emit(Result.Loading())
                val response = seriesDataSource.getSeries()
                series = response.results
                series.forEach { it.page = page }
                serieDao.insertSerieList(series = series)
                emit(Result.Success(data = response.results))
            } else {
                emit(Result.Success(data = series))
            }
        } catch (e: Exception) {
            emit(Result.Error(message = e.localizedMessage ?: "Internal error: capture series"))
        }
    }

    override fun getSerieId(serieId: Long): Flow<Result<Serie>> {
        TODO("Not yet implemented")
    }
}