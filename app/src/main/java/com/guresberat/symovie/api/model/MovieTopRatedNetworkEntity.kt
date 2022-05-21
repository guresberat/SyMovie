package com.guresberat.symovie.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieTopRatedNetworkEntity(
    @SerializedName("page")
    @Expose
    val page: Int,

    @SerializedName("results")
    @Expose
    val results: List<MovieNetworkEntity>,

    @SerializedName("total_pages")
    @Expose
    val total_pages: Int,

    @SerializedName("total_results")
    @Expose
    val total_results: Int,
)