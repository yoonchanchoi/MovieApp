package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCompanyResult(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("logo_path")
    @Expose
    val logoPath: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("origin_country")
    @Expose
    val originCountry: String = ""

) : Serializable
