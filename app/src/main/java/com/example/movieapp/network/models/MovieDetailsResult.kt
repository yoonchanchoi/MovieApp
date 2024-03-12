package com.example.movieapp.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDetailsResult(
    @SerializedName("adult")
    @Expose
    val adult: Boolean = false,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String = "",

    @SerializedName("belongs_to_collection")
    @Expose
    val belongsToCollection: BelongsToCollection,

    @SerializedName("budget")
    @Expose
    val budget: Int = 0,

    @SerializedName("genres")
    @Expose
    val genres: ArrayList<GenreResult>,

    @SerializedName("homepage")
    @Expose
    val homepage: String = "",

    @SerializedName("id")
    @Expose
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
    @Expose
    val overview: String = "",

    @SerializedName("popularity")
    @Expose
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
    @Expose
    val revenue: Int = 0,

    @SerializedName("runtime")
    @Expose
    val runtime: Int = 0,

    @SerializedName("spoken_languages")
    @Expose
    val spokenLanguages: ArrayList<SpokenLanguageResult>,

    @SerializedName("status")
    @Expose
    val status: String = "",

    @SerializedName("tagline")
    @Expose
    val tagline: String = "",

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
