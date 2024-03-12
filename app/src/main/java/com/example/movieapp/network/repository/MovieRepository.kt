package com.example.movieapp.network.repository

import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.network.models.NowPlayingResult
import com.example.movieapp.network.models.PopularResult
import com.example.movieapp.network.models.SearchMoviesResult
import com.example.movieapp.network.models.SimilarResult
import com.example.movieapp.network.models.TopRatedResult
import com.example.movieapp.network.models.VideosResult
//import com.example.movieapp.network.models.roomdb.MovieData
import retrofit2.Call

interface MovieRepository {
    fun requestNowPlaying(page: Int): Call<NowPlayingResult>

    fun requestPopular(page: Int): Call<PopularResult>

    fun requestTopRated(page: Int): Call<TopRatedResult>

    fun requestMovieDetails(movieId: Int): Call<MovieDetailsResult>

    fun requestSimilarMovie(movieId: Int, page: Int): Call<SimilarResult>

    fun requestVideos(movieId: Int): Call<VideosResult>

    fun requestSearchMovie(
        query: String,
        page: Int,
    ): Call<SearchMoviesResult>

//    suspend fun requestLocalInsert(movieData: MovieData)
//
//    suspend fun requestLocalUpdate(movieData: MovieData)
//
//    suspend fun requestLocalDelete(movieData: MovieData)
//
//    suspend fun requestLocalGetMovies(): List<MovieData>
//
//    suspend fun reqestSelectMovie(id: Int): MovieData?

}


