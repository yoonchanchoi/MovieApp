package com.example.movieapp.network.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DatesResult(

    @SerializedName("maximum")
    val maximum: String = "",

    @SerializedName("minimum")
    val minimum: String = ""

) : Serializable