package com.example.movieapp.network.models.roomdb.converters

import androidx.room.TypeConverter
import com.example.movieapp.network.models.GenreResult
import com.google.gson.Gson

@ProvidedTypeConverter
class GenreResultListTypeConverter(private val gson: Gson) {
    @TypeConverter
    fun listToJson(value: ArrayList<GenreResult>): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): ArrayList<GenreResult> {
        return gson.fromJson(value, Array<GenreResult>::class.java).toList() as ArrayList<GenreResult>
    }
}