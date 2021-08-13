package com.guresberat.symovie.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieCacheEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase(){
    abstract fun movieDAO(): MovieDao

    companion object{
        val DATABASE_NAME: String = "movie_db"
    }
}