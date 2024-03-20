package com.example.movieapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.FragmentMovieBinding
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.ui.activity.DetailMovieActivity
import com.example.movieapp.ui.listener.MovieRecyclerListener
import com.example.movieapp.ui.adapter.PosterMovieAdapter
import com.example.movieapp.ui.adapter.PopularMovieAdapter
import com.example.movieapp.ui.adapter.TopRatedMovieAdapter
import com.example.movieapp.util.Constants
import com.example.movieapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(), MovieRecyclerListener {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var nowPlayingMovieAdapter: PosterMovieAdapter
    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private lateinit var topRatedMovieAdapter: TopRatedMovieAdapter
    private lateinit var navController: NavController
    private var flag = false
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initData()
        initObserve()
    }

    private fun initData() {
        setNowPlayingMovieAdapter()
        viewModel.requestNowPlaying(Constants.FIRST_PAGE)
        viewModel.requestPopular(Constants.FIRST_PAGE)
        viewModel.requestTopRated(Constants.FIRST_PAGE)
    }

    private fun initObserve() {
        viewModel.nowPlayingMovies.observe(viewLifecycleOwner) {
            nowPlayingMovieAdapter.setData(it)

        }
        viewModel.popularMovies.observe(viewLifecycleOwner) {
            setPopularMovieAdapter(it)

        }
        viewModel.topRatedMovies.observe(viewLifecycleOwner) {
            setTopRatedMovieAdapter(it)

        }
        viewModel.movieDetails.observe(viewLifecycleOwner) {
            if (flag) {
                flag = false
                val intent = Intent(requireActivity(), DetailMovieActivity::class.java)
                intent.putExtra(Constants.INTENT_KEY_MOVIE_DETAIL, it)
                startActivity(intent)
            }
        }
    }

    private fun setNowPlayingMovieAdapter() {
        nowPlayingMovieAdapter =
            PosterMovieAdapter(this)
        val movieManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvNowPlaying.apply {
            layoutManager = movieManager
            adapter = nowPlayingMovieAdapter
            scrollToPosition(0)
        }
    }

    private fun setPopularMovieAdapter(movies: ArrayList<MovieResult>) {
        popularMovieAdapter =
            PopularMovieAdapter(this, movies)
        val movieManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvPopular.apply {
            layoutManager = movieManager
            adapter = popularMovieAdapter
            scrollToPosition(0)
        }
    }

    private fun setTopRatedMovieAdapter(movies: ArrayList<MovieResult>) {
        topRatedMovieAdapter =
            TopRatedMovieAdapter(this, movies)
        val topRatedMovieManager =
            GridLayoutManager(requireActivity(), 4, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTopRated.apply {
            layoutManager = topRatedMovieManager
            adapter = topRatedMovieAdapter
            scrollToPosition(0)
        }
    }

    override fun onMovieItemClick(movieId: Int) {
        viewModel.requestMovieDetails(movieId)
        flag = true
    }
}