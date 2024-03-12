package com.example.movieapp.network.models.roomdb.converters

import androidx.room.TypeConverter
import com.example.movieapp.network.models.ProductionCountryResult
import com.google.gson.Gson
@ProvidedTypeConverter

class ProductionCountryResultTypeConverter(private val gson: Gson) {
    @TypeConverter
    fun listToJson(value: ArrayList<ProductionCountryResult>): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): ArrayList<ProductionCountryResult> {
        return gson.fromJson(value, Array<ProductionCountryResult>::class.java).toList() as ArrayList<ProductionCountryResult>
    }
}