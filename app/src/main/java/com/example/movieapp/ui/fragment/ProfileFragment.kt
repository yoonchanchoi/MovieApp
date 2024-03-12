package com.example.movieapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.FragmentProfileBinding
import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.ui.activity.DetailMovieActivity
import com.example.movieapp.ui.adapter.FavoriteAdapter
import com.example.movieapp.ui.adapter.PopularMovieAdapter
import com.example.movieapp.ui.listener.MovieRecyclerListener
import com.example.movieapp.util.Constants
import com.example.movieapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment(), MovieRecyclerListener {

    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var binding: FragmentProfileBinding
    private val viewModel: MainViewModel by viewModels()
    private var flag = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initObserve()
    }

    private fun initData() {
        lifecycleScope.launch {
            viewModel.requestLocalGetMovies()
        }
    }

    private fun initObserve() {
        viewModel.localMovies.observe(viewLifecycleOwner){
            setFavoriteMovieAdapter(it)
        }
        viewModel.movieDetails.observe(viewLifecycleOwner){
            if(flag)
            flag = false
            val intent = Intent(requireActivity(), DetailMovieActivity::class.java)
            intent.putExtra(Constants.INTENT_KEY_MOVIE_DETAIL, it)
            startActivity(intent)
        }
    }


    private fun setFavoriteMovieAdapter(movies: ArrayList<MovieDetailsResult>) {
        favoriteAdapter =
            FavoriteAdapter(this, movies)
        val favoriteMovieManager =
            GridLayoutManager(requireActivity(), 2)
        binding.rv.apply {
            layoutManager = favoriteMovieManager
            adapter = favoriteAdapter
            scrollToPosition(0)
        }
    }

    override fun onMovieItemClick(movieId: Int) {
        flag = true
        viewModel.requestMovieDetails(movieId)
    }

}