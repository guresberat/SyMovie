package com.guresberat.symovie.repository

import com.guresberat.symovie.api.MovieRetrofit
import com.guresberat.symovie.api.util.NetworkMapper
import com.guresberat.symovie.room.CacheMapper
import com.guresberat.symovie.room.MovieDao
import com.guresberat.symovie.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val movieDao: MovieDao,
    private val movieRetrofit: MovieRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getMovie(): Flow<DataState> = flow {
        emit(DataState.Loading)
        try {
            val networkMovies = movieRetrofit.get("0e1f01f16c3e578a51669cf7ba8e369b")
            val movies = networkMapper.mapFromEntityList(networkMovies.results)
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
