package com.guresberat.symovie.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieNetworkEntity(

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("original_title")
    @Expose
    val originalTitle: String,

    @SerializedName("overview")
    @Expose
    val overview: String,

    @SerializedName("popularity")
    @Expose
    val popularity: Double,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("vote_average")
    @Expose
    val ratingAverage: Double,

    @SerializedName("vote_count")
    @Expose
    val rating: Int,
)