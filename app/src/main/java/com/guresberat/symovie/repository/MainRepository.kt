package com.guresberat.symovie.repository

import com.guresberat.symovie.api.MovieRetrofit
import com.guresberat.symovie.api.util.NetworkMapper
import com.guresberat.symovie.domain.model.Movie
import com.guresberat.symovie.room.CacheMapper
import com.guresberat.symovie.room.MovieDao
import com.guresberat.symovie.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val movieDao: MovieDao,
    private val movieRetrofit: MovieRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getMovie(): Flow<DataState<List<Movie>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkMovies = movieRetrofit.get()
            val movies = networkMapper.mapFromEntityList(networkMovies)
            for (movie in movies) {
                movieDao.insert(cacheMapper.mapToEntity(movie))
            }
            val cachedMovies = movieDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedMovies)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
