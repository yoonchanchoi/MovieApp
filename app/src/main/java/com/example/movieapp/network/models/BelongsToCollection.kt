package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BelongsToCollection(

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("poster_path")
    @Expose
    val posterPath: String = "",

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String = ""

) : Serializable
