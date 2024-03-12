package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCompanyResult(
    @SerializedName("id")
    @Expose
    val id: Int = 0,

    @SerializedName("logo_path")
    @Expose
    val logoPath: String = "",

    @SerializedName("name")
    @Expose
    val name: String = "",

    @SerializedName("origin_country")
    @Expose
    val originCountry: String = ""

) : Serializable
