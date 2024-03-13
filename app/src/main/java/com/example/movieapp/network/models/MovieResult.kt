package com.example.movieapp.network.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResult(
    @SerializedName("adult")
    @Expose
    val adult: Boolean = false,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String = "",

    @SerializedName("genre_ids")
    @Expose
    val genreIds: ArrayList<Int>,

    @SerializedName("id")
    @Expose
    val id: Int = 0,

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String ="",

    @SerializedName("original_title")
    @Expose
    val originalTitle: String ="",

    @SerializedName("overview")
    @Expose
    val overview: String ="",

    @SerializedName("popularity")
    @Expose
    val popularity: Double = 0.0,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String = "",

    @SerializedName("release_date")
    @Expose
    val releaseDate: String = "",

    @SerializedName("title")
    @Expose
    val title: String = "",

    @SerializedName("video")
    @Expose
    val video: Boolean = false,

    @SerializedName("vote_average")
    @Expose
    val voteAverage: Float = 0.0f,

    @SerializedName("vote_count")
    @Expose
    val voteCount: Int = 0
    ) : Serializable
