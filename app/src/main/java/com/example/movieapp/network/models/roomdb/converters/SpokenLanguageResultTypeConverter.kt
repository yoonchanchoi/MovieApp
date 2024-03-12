package com.example.movieapp.network.models.roomdb.converters

import androidx.room.TypeConverter
import com.example.movieapp.network.models.SpokenLanguageResult
import com.google.gson.Gson
@ProvidedTypeConverter

class SpokenLanguageResultTypeConverter(private val gson: Gson) {
    @TypeConverter
    fun listToJson(value: ArrayList<SpokenLanguageResult>): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): ArrayList<SpokenLanguageResult> {
        return gson.fromJson(value, Array<SpokenLanguageResult>::class.java).toList() as ArrayList<SpokenLanguageResult>
    }
}