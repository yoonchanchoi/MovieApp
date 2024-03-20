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
    val languageCode: String = "",

    @SerializedName("name")
    val name: String = ""

): Serializable
