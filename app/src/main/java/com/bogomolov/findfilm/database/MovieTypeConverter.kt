package com.bogomolov.findfilm.database

import androidx.room.TypeConverter
import com.bogomolov.findfilm.data.MovieType

class MovieTypeConverter {
    @TypeConverter
    fun convertMovieTypeToString(movieType: MovieType) = movieType.name

    @TypeConverter
    fun convertStringToMovieType(type: String) = MovieType.valueOf(type)
}