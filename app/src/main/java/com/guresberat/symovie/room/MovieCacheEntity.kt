package com.guresberat.symovie.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "budget")
    val budget: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @ColumnInfo(name = "posterPath")
    val posterPath: String,

    @ColumnInfo(name = "releaseDate")
    val releaseDate: String,

    @ColumnInfo(name = "revenue")
    val revenue: Long,

    @ColumnInfo(name = "runtime")
    val runtime: Int,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "tagline")
    val tagline: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    )