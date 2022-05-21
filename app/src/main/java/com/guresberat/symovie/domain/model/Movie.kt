package com.guresberat.symovie.domain.model

data class Movie(
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val backdropPath: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val ratingAverage: Double,
    val rating: Int
)