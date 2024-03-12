package com.example.movieapp.network.models.roomdb.converters

import androidx.room.TypeConverter
import com.example.movieapp.network.models.ProductionCompanyResult
import com.google.gson.Gson

@ProvidedTypeConverter
class ProductionCompanyResultTypeConverter(private val gson: Gson) {
    @TypeConverter
    fun listToJson(value: ArrayList<ProductionCompanyResult>): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): ArrayList<ProductionCompanyResult> {
        return gson.fromJson(value, Array<ProductionCompanyResult>::class.java).toList() as ArrayList<ProductionCompanyResult>
    }
}