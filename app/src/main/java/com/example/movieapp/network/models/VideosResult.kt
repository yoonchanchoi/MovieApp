package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VideosResult(

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("results")
    @Expose
    val videoInfos: ArrayList<VideoInfoResult>

) : Serializable