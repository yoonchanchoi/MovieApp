package com.example.movieapp.network.models.roomdb.converters

import androidx.room.TypeConverter
import com.example.movieapp.network.models.BelongsToCollection
import com.google.gson.Gson
@ProvidedTypeConverter

class BelongsToCollectionTypeConverter(private val gson: Gson) {
    @TypeConverter
    fun listToJson(value: BelongsToCollection): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): BelongsToCollection {
        return gson.fromJson(value, BelongsToCollection::class.java)
    }
}
