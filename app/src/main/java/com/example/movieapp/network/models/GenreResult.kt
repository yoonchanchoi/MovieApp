package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GenreResult(
    @SerializedName("id")
    @Expose
    val id: Int = 0,

    @SerializedName("name")
    @Expose
    val name: String = "",

) : Serializable
