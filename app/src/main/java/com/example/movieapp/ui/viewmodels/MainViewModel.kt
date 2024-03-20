package com.example.movieapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.network.models.NowPlayingResult
import com.example.movieapp.network.models.PopularResult
import com.example.movieapp.network.models.SearchMoviesResult
import com.example.movieapp.network.models.TopRatedResult
import com.example.movieapp.network.repository.remote.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) :ViewModel() {

    private val _nowPlayingMovies = MutableLiveData<ArrayList<MovieResult>>()
    val nowPlayingMovies: LiveData<ArrayList<MovieResult>>
        get() = _nowPlayingMovies

    private val _popularMovies = MutableLiveData<ArrayList<MovieResult>>()
    val popularMovies: LiveData<ArrayList<MovieResult>>
        get() = _popularMovies

    private val _topRatedMovies = MutableLiveData<ArrayList<MovieResult>>()
    val topRatedMovies: LiveData<ArrayList<MovieResult>>
        get() = _topRatedMovies

    private val _movieDetails = MutableLiveData<MovieDetailsResult>()
    val movieDetails: LiveData<MovieDetailsResult>
        get() = _movieDetails

    private val _searchMovie = MutableLiveData<SearchMoviesResult>()
    val searchMovie: LiveData<SearchMoviesResult>
        get() = _searchMovie

    private val _addSearchMovie = MutableLiveData<SearchMoviesResult>()
    val addSearchMovie: LiveData<SearchMoviesResult>
        get() = _addSearchMovie

    fun requestNowPlaying(page:Int){
        val result = movieRepository.requestNowPlaying(page)
        result.enqueue(object : Callback<NowPlayingResult>{
            override fun onResponse(
                call: Call<NowPlayingResult>,
                response: Response<NowPlayingResult>
            ) {
                if(response.isSuccessful){
                    Log.e("cyc","NowPlayingResult 통신 성공")
                    response.body()?.let {
                        _nowPlayingMovies.postValue(it.movies)
                    }
                }else{
                    Log.e("cyc","NowPlayingResult 실패")
                }
            }
            override fun onFailure(call: Call<NowPlayingResult>, t: Throwable) {
                Log.e("cyc","NowPlayingResult 통신 실패")
            }
        })
    }

    fun requestPopular(page:Int){
        val result = movieRepository.requestPopular(page)
        result.enqueue(object : Callback<PopularResult>{
            override fun onResponse(
                call: Call<PopularResult>,
                response: Response<PopularResult>
            ) {
                if(response.isSuccessful){
                    Log.e("cyc","PopularResult 통신 성공")
                    response.body()?.let {
                        _popularMovies.postValue(it.movies)
                    }
                }else{
                    Log.e("cyc","PopularResult 실패")
                }
            }
            override fun onFailure(call: Call<PopularResult>, t: Throwable) {
                Log.e("cyc","PopularResult 통신 실패")
            }
        })
    }

    fun requestTopRated(page:Int){
        val result = movieRepository.requestTopRated(page)
        result.enqueue(object : Callback<TopRatedResult>{
            override fun onResponse(
                call: Call<TopRatedResult>,
                response: Response<TopRatedResult>
            ) {
                if(response.isSuccessful){
                    Log.e("cyc","TopRatedResult 통신 성공")
                    response.body()?.let {
                        _topRatedMovies.postValue(it.movies)
                    }
                }else{
                    Log.e("cyc","TopRatedResult 실패")
                }
            }
            override fun onFailure(call: Call<TopRatedResult>, t: Throwable) {
                Log.e("cyc","TopRatedResult 통신 실패")
            }
        })
    }

    fun requestMovieDetails(movieId: Int){
        val result = movieRepository.requestMovieDetails(movieId)
        result.enqueue(object : Callback<MovieDetailsResult>{
            override fun onResponse(
                call: Call<MovieDetailsResult>,
                response: Response<MovieDetailsResult>
            ) {
                if(response.isSuccessful){
                    Log.e("cyc","Main-MovieDetailsResult 통신 성공")
                    response.body()?.let {
                        _movieDetails.postValue(it)
                    }
                }else{
                    Log.e("cyc","Main-MovieDetailsResult 실패")
                }
            }
            override fun onFailure(call: Call<MovieDetailsResult>, t: Throwable) {
                Log.e("cyc","Main-MovieDetailsResult 통신 실패")
            }
        })
    }

    fun requestSearchMovie(query: String ,page: Int, isCheckPaging: Boolean){
        val result = movieRepository.requestSearchMovie(query,page)
        result.enqueue(object : Callback<SearchMoviesResult>{
            override fun onResponse(
                call: Call<SearchMoviesResult>,
                response: Response<SearchMoviesResult>
            ) {
                if(response.isSuccessful){
                    Log.e("cyc","SearchMoviesResult 통신 성공")
                    if(isCheckPaging){
                        response.body()?.let {
                            _addSearchMovie.postValue(it)
                        }
                    }else{
                        response.body()?.let {
                            _searchMovie.postValue(it)
                        }
                    }

                }else{
                    Log.e("cyc","SearchMoviesResult 실패")
                }
            }
            override fun onFailure(call: Call<SearchMoviesResult>, t: Throwable) {
                Log.e("cyc","SearchMoviesResult 통신 실패")
            }
        })
    }
}