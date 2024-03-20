package com.example.movieapp.network.services

import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.NowPlayingResult
import com.example.movieapp.network.models.PopularResult
import com.example.movieapp.network.models.SearchMoviesResult
import com.example.movieapp.network.models.SimilarResult
import com.example.movieapp.network.models.TopRatedResult
import com.example.movieapp.network.models.VideosResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/now_playing")
    fun requestNowPlaying(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<NowPlayingResult>

    @GET("/3/movie/popular")
    fun requestPopular(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<PopularResult>

    @GET("/3/movie/top_rated")
    fun requestTopRated(
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<TopRatedResult>

    @GET("/3/movie/{movie_id}")
    fun requestMovieDetails(
        @Path("movie_id") movieId: Int
    ): Call<MovieDetailsResult>

    @GET("/3/movie/{movie_id}/similar")
    fun requestSimilarMovie(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<SimilarResult>

    @GET("/3/movie/{movie_id}/videos")
    fun requestVideos(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String,
    ): Call<VideosResult>

    @GET("/3/search/movie")
    fun requestSearchMovie(
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("language") language: String,
        @Query("primary_release_year") primaryReleaseYear: String,
        @Query("page") page: Int,
        @Query("region") region: String,
        @Query("year") year: String,
    ): Call<SearchMoviesResult>
}