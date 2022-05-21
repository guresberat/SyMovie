package com.guresberat.symovie.api

import com.guresberat.symovie.api.model.MovieTopRatedNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRetrofit {

    @GET("3/movie/top_rated?")
    suspend fun get(
        @Query("api_key") api_key:String
    ): MovieTopRatedNetworkEntity

}