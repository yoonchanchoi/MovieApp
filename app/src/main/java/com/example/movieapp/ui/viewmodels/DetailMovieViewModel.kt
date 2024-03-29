package com.example.movieapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.SimilarResult
import com.example.movieapp.network.models.VideosResult
import com.example.movieapp.network.repository.remote.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) :ViewModel() {

    private val _similarMovies = MutableLiveData<SimilarResult>()
    val similarMovies: LiveData<SimilarResult>
        get() = _similarMovies

    private val _movieDetails = MutableLiveData<MovieDetailsResult>()
    val movieDetails: LiveData<MovieDetailsResult>
        get() = _movieDetails

    private val _videos = MutableLiveData<VideosResult>()
    val videos: LiveData<VideosResult>
        get() = _videos

    fun requestSimilarMovie(movieId: Int, page:Int){
        val result = movieRepository.requestSimilarMovie(movieId,page)
        result.enqueue(object : Callback<SimilarResult>{
            override fun onResponse(
                call: Call<SimilarResult>,
                response: Response<SimilarResult>
            ) {
                if(response.isSuccessful){
                    Log.e("cyc","SimilarResult 통신 성공")
                    response.body()?.let {
                        _similarMovies.postValue(it)
                    }
                }else{
                    Log.e("cyc","SimilarResult 실패")
                }
            }
            override fun onFailure(call: Call<SimilarResult>, t: Throwable) {
                Log.e("cyc","SimilarResult 통신 실패")
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
                    Log.e("cyc","Detail-MovieDetailsResult 통신 성공")
                    response.body()?.let {
                        _movieDetails.postValue(it)
                    }
                }else{
                    Log.e("cyc","Detail-MovieDetailsResult 실패")
                }
            }
            override fun onFailure(call: Call<MovieDetailsResult>, t: Throwable) {
                Log.e("cyc","Detail-MovieDetailsResult 통신 실패")
            }
        })
    }

    fun requestVideos(movieId: Int){
        val result = movieRepository.requestVideos(movieId)
        result.enqueue(object : Callback<VideosResult>{
            override fun onResponse(
                call: Call<VideosResult>,
                response: Response<VideosResult>
            ) {
                if(response.isSuccessful){
                    Log.e("cyc","VideosResult 통신 성공")
                    response.body()?.let {
                        _videos.postValue(it)
                    }
                }else{
                    Log.e("cyc","VideosResult 실패")
                }
            }
            override fun onFailure(call: Call<VideosResult>, t: Throwable) {
                Log.e("cyc","VideosResult 통신 실패")
            }
        })
    }
}