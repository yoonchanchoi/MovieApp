package com.example.movieapp.network.models

//import androidx.room.Entity
//import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResult(
    @SerializedName("adult")
    val adult: Boolean = false,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String = "",

    @SerializedName("genre_ids")
    @Expose
    val genreIds: ArrayList<Int>,

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String ="",

    @SerializedName("original_title")
    @Expose
    val originalTitle: String ="",

    @SerializedName("overview")
    val overview: String ="",

    @SerializedName("popularity")
    val popularity: Double = 0.0,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String = "",

    @SerializedName("release_date")
    @Expose
    val releaseDate: String = "",

    @SerializedName("title")
    val title: String = "",

    @SerializedName("video")
    val video: Boolean = false,

    @SerializedName("vote_average")
    @Expose
    val voteAverage: Float = 0.0f,

    @SerializedName("vote_count")
    @Expose
    val voteCount: Int = 0
    ) : Serializable
