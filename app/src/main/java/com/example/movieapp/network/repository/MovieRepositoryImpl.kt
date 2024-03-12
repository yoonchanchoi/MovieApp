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
//import com.example.movieapp.network.models.roomdb.MovieDatabase
import com.example.movieapp.network.services.MovieService
import retrofit2.Call
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val service: MovieService
//    private val movieDatabase: MovieDatabase
) : MovieRepository {
    override fun requestNowPlaying(page: Int): Call<NowPlayingResult> =
        service.requestNowPlaying(language = "en-US", page)

    override fun requestPopular(page: Int): Call<PopularResult> =
        service.requestPopular(language = "en-US", page)

    override fun requestTopRated(page: Int): Call<TopRatedResult> =
        service.requestTopRated(language = "en-US", page)

    override fun requestMovieDetails(movieId: Int): Call<MovieDetailsResult> =
        service.requestMovieDetails(movieId)

    override fun requestSimilarMovie(movieId: Int, page: Int): Call<SimilarResult> =
        service.requestSimilarMovie(movieId, language = "en-US", page)

    override fun requestVideos(movieId: Int): Call<VideosResult> =
        service.requestVideos(movieId, language = "en-US")

    override fun requestSearchMovie(
        query: String,
        page: Int,
    ): Call<SearchMoviesResult> =
        service.requestSearchMovie(query, includeAdult = false, language = "en-US", primaryReleaseYear = "", page, region = "", year = "")

//    override suspend fun requestLocalInsert(movieData: MovieData) {
//        movieDatabase.movieDao().insert(movieData)
//    }
//
//    override suspend fun requestLocalUpdate(movieData: MovieData) {
//        movieDatabase.movieDao().update(movieData)
//    }
//
//    override suspend fun requestLocalDelete(movieData: MovieData) {
//        movieDatabase.movieDao().delete(movieData)
//    }
//
//    override suspend fun requestLocalGetMovies(): List<MovieData> =
//        movieDatabase.movieDao().getMovies()
//
//    override suspend fun reqestSelectMovie(id: Int): MovieData? =
//        movieDatabase.movieDao().selectMovie(id)

}

