package com.guresberat.symovie.api

import com.guresberat.symovie.api.model.MovieNetworkEntity
import retrofit2.http.GET

interface MovieRetrofit {
    @GET("movie")
    suspend fun get(): List<MovieNetworkEntity>
}