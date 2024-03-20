package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemPopularMovieBinding
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.ui.listener.MovieRecyclerListener

class PopularMovieAdapter(
    private val movieRecyclerListener: MovieRecyclerListener,
    private val movies: ArrayList<MovieResult>
) : RecyclerView.Adapter<PopularMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val itemBinding =
            ItemPopularMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularMovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        holder.bind(movieRecyclerListener, movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}