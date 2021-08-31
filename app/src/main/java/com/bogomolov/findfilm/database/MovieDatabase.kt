package com.bogomolov.findfilm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bogomolov.findfilm.data.Movie

@Database(entities = [Movie::class], version = MovieDatabase.DB_VERSION)
abstract class MovieDatabase : RoomDatabase() {
    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "movie_database"
    }
    abstract fun movieDao(): MovieDao
}