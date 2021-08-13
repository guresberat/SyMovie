package com.guresberat.symovie.model

data class Movie(
    val budget: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Long,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val rating: Double
)