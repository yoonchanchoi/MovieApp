package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpokenLanguageResult(

    @SerializedName("english_name")
    @Expose
    val englishName: String = "",

    @SerializedName("iso_639_1")
    @Expose
    val iso6391: String = "",

    @SerializedName("name")
    @Expose
    val name: String = ""
): Serializable
