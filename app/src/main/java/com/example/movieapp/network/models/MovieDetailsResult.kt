package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDetailsResult(

    @SerializedName("adult")
    val adult: Boolean = false,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String = "",

    @SerializedName("belongs_to_collection")
    @Expose
    val belongsToCollection: BelongsToCollection,

    @SerializedName("budget")
    val budget: Int = 0,

    @SerializedName("genres")
    val genres: ArrayList<GenreResult>,

    @SerializedName("homepage")
    val homepage: String = "",

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("imdb_id")
    @Expose
    val imdbId: String = "",

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String = "",

    @SerializedName("original_title")
    @Expose
    val originalTitle: String = "",

    @SerializedName("overview")
    val overview: String = "",

    @SerializedName("popularity")
    val popularity: Float = 0f,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String = "",

    @SerializedName("production_companies")
    @Expose
    val productionCompanies: ArrayList<ProductionCompanyResult>,

    @SerializedName("production_countries")
    @Expose
    val productionCountries: ArrayList<ProductionCountryResult>,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String = "",

    @SerializedName("revenue")
    val revenue: Int = 0,

    @SerializedName("runtime")
    val runtime: Int = 0,

    @SerializedName("spoken_languages")
    @Expose
    val spokenLanguages: ArrayList<SpokenLanguageResult>,

    @SerializedName("status")
    val status: String = "",

    @SerializedName("tagline")
    val tagline: String = "",

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
