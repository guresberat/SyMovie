package com.guresberat.symovie.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieNetworkEntity(

    @SerializedName("budget")
    @Expose
    var budget: Int,

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("overview")
    @Expose
    var overview: String,

    @SerializedName("popularity")
    @Expose
    var popularity: Double,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String,

    @SerializedName("revenue")
    @Expose
    val revenue: Long,

    @SerializedName("runtime")
    @Expose
    val runtime: Int,

    @SerializedName("status")
    @Expose
    val status: String,

    @SerializedName("tagline")
    @Expose
    val tagline: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("vote_average")
    @Expose
    val rating: Double,
)