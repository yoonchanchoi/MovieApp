package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SimilarResult(

    @SerializedName("page")
    val page: Int = 0,

    @SerializedName("results")
    @Expose
    val movies: ArrayList<MovieResult>,

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int = 0,

    @SerializedName("total_results")
    @Expose
    val totalResults: Int = 0

) : Serializable