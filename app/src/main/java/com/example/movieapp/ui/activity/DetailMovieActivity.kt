package com.example.movieapp.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityDetailMovieBinding
import com.example.movieapp.network.models.GenreResult
import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.network.models.ProductionCompanyResult
import com.example.movieapp.network.models.ProductionCountryResult
import com.example.movieapp.network.models.VideoInfoResult
import com.example.movieapp.ui.adapter.CountryAdapter
import com.example.movieapp.ui.adapter.GenreAdapter
import com.example.movieapp.ui.listener.MovieRecyclerListener
import com.example.movieapp.ui.adapter.PosterMovieAdapter
import com.example.movieapp.ui.adapter.ProductionCmpAdapter
import com.example.movieapp.ui.adapter.VideoAdapter
import com.example.movieapp.ui.listener.VideoRecyclerListener
import com.example.movieapp.util.Constants
import com.example.movieapp.util.intentSerializable
import com.example.movieapp.viewmodels.DetailMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.DecimalFormat

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity(), MovieRecyclerListener, VideoRecyclerListener{

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var movieDetailsResult: MovieDetailsResult
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var genreAdapter: GenreAdapter
    private lateinit var productionCmpAdapter: ProductionCmpAdapter
    private lateinit var similarMovieAdapter: PosterMovieAdapter
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var localMovie: MovieResult


    private val viewModel: DetailMovieViewModel by viewModels()

    private var decimalFormat = DecimalFormat("#,###")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        initObserve()
        initListener()
    }

    private fun initData() {
        setSimilarMovieAdapter()
        intent.intentSerializable(Constants.INTENT_KEY_MOVIE_DETAIL, MovieDetailsResult::class.java)
            ?.let {
                movieDetailsResult = it
            }
        initCheckBox(movieDetailsResult.id)

        viewModel.requestSimilarMovie(movieDetailsResult.id,Constants.FIRST_PAGE)
        viewModel.requestVideos(movieDetailsResult.id)
        Log.e("cyc","여기여기여기1")
        binding.tvMovieTile.text = movieDetailsResult.originalTitle
        Glide.with(this)
            .load(Constants.IMAGE_BASE_URL + "w300" + movieDetailsResult.backdropPath)
            .error(R.drawable.error_img)
            .fitCenter()
            .into(binding.ivTop)
        Glide.with(this)
            .load(Constants.IMAGE_BASE_URL + "w342" + movieDetailsResult.posterPath)
            .error(R.drawable.error_img)
            .fitCenter()
            .into(binding.ivPoster)
        binding.rb.rating = (movieDetailsResult.voteAverage*5)/10
        binding.tvVoteCount.text = "(" + movieDetailsResult.voteCount + ")"
        binding.tvReleaseDate.text = "Release date: " + movieDetailsResult.releaseDate
        setCountryAdapter(movieDetailsResult.productionCountries)
        Log.e("cyc","여기여기여기2")

        binding.tvLanguage.text = "Language: " + if(movieDetailsResult.spokenLanguages.isNotEmpty())movieDetailsResult.spokenLanguages[0].name else ""
        Log.e("cyc","여기여기여기3")

        binding.tvRevenue.text = "Revennue: " + decimalFormat.format(movieDetailsResult.revenue) +"$"
        setGenreAdapter(movieDetailsResult.genres)
        setProductionCmpAdapter(movieDetailsResult.productionCompanies)
        binding.tvOverview.text = " " + movieDetailsResult.overview

    }


    private fun initObserve(){
        viewModel.similarMovies.observe(this){
            similarMovieAdapter.setData(it.movies)
        }
        viewModel.movieDetails.observe(this){
            val intent = Intent(this,this::class.java)
            intent.apply {
                this.putExtra(Constants.INTENT_KEY_MOVIE_DETAIL, it)
                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
            startActivity(intent)
        }

        viewModel.videos.observe(this){
            setVideoAdapter(it.videoInfos)
        }
        viewModel.localMovie.observe(this){
            if(it==null){
                binding.cbFavorite.isChecked = false
            }else{
                binding.cbFavorite.isChecked = true
            }
        }
    }

    private fun initListener(){
        binding.cbFavorite.setOnCheckedChangeListener { btn, isChecked ->
            if(isChecked) {
                lifecycleScope.launch {
                    viewModel.requestLocalInsert(movieDetailsResult)
                }
            }else{
                lifecycleScope.launch {
                    viewModel.requestLocalDelete(movieDetailsResult)
                }
            }
        }
    }



    private fun setCountryAdapter(productionCountries: ArrayList<ProductionCountryResult>) {
        countryAdapter =
            CountryAdapter(productionCountries)
        val countryManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCountry.apply {
            layoutManager = countryManager
            adapter = countryAdapter
            scrollToPosition(0)
        }
    }

    private fun setGenreAdapter(genres: ArrayList<GenreResult>) {
        genreAdapter =
            GenreAdapter(genres)
        val genreManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvGenres.apply {
            layoutManager = genreManager
            adapter = genreAdapter
            scrollToPosition(0)
        }
    }

    private fun setProductionCmpAdapter(productionCompanies: ArrayList<ProductionCompanyResult>) {
        productionCmpAdapter =
            ProductionCmpAdapter(productionCompanies)
        val productionCmpManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvProducCmp.apply {
            layoutManager = productionCmpManager
            adapter = productionCmpAdapter
            scrollToPosition(0)
        }
    }

    private fun setSimilarMovieAdapter() {
        similarMovieAdapter =
            PosterMovieAdapter(this)
        val similarMovieManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvSimilarMovies.apply {
            layoutManager = similarMovieManager
            adapter = similarMovieAdapter
            scrollToPosition(0)
        }

    }

    private fun setVideoAdapter(videoInfos: ArrayList<VideoInfoResult>) {
        videoAdapter =
            VideoAdapter( this, videoInfos)
        val videoManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvVideo.apply {
            layoutManager = videoManager
            adapter = videoAdapter
            scrollToPosition(0)
        }
    }

    private fun initCheckBox(id: Int){
        lifecycleScope.launch {
            viewModel.reqestSelectMovie(id)
        }
    }


    override fun onMovieItemClick(movieId: Int) {
        viewModel.requestMovieDetails(movieId)
    }

    override fun onVideoItemClick(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    }



}