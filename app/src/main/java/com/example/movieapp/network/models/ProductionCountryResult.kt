package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCountryResult(

    @SerializedName("iso_3166_1")
    @Expose
    val countryCode: String = "",

    @SerializedName("name")
    val name: String = ""

): Serializable
