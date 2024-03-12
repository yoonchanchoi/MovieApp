package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DatesResult(
    @SerializedName("maximum")
    @Expose
    val maximum: String = "",

    @SerializedName("minimum")
    @Expose
    val minimum: String = ""

) : Serializable