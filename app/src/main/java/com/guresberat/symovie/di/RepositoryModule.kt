package com.guresberat.symovie.di

import com.guresberat.symovie.api.MovieRetrofit
import com.guresberat.symovie.api.util.NetworkMapper
import com.guresberat.symovie.repository.MainRepository
import com.guresberat.symovie.room.CacheMapper
import com.guresberat.symovie.room.MovieDao
import com.guresberat.symovie.ui.MainActivity
import com.guresberat.symovie.ui.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        movieDao: MovieDao,
        retrofit: MovieRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(movieDao, retrofit, cacheMapper, networkMapper)
    }
}