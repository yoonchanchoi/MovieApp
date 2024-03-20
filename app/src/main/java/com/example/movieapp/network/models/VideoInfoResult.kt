package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VideoInfoResult(

    @SerializedName("iso_639_1")
    @Expose
    val languageCode: String = "",

    @SerializedName("iso_3166_1")
    @Expose
    val countryCode: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("key")
    val key: String = "",

    @SerializedName("site")
    val site: String = "",

    @SerializedName("size")
    val size: Int = 0,

    @SerializedName("type")
    val type: String = "",

    @SerializedName("official")
    val official: Boolean = false,

    @SerializedName("published_at")
    @Expose
    val publishedAt: String = "",

    @SerializedName("id")
    val id: String = "",

) : Serializable