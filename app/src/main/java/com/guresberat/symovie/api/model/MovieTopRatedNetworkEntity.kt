package com.guresberat.symovie.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieTopRatedNetworkEntity(
    @SerializedName("page")
    @Expose
    var page: Int,

    @SerializedName("results")
    @Expose
    var results: List<MovieNetworkEntity>,

    @SerializedName("total_pages")
    @Expose
    var total_pages: Int,

    @SerializedName("total_results")
    @Expose
    var total_results: Int,
)