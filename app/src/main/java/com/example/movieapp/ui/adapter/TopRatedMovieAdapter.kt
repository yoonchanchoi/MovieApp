package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemTopRatedMovieBinding
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.ui.listener.MovieRecyclerListener

class TopRatedMovieAdapter (
    private val movieRecyclerListener: MovieRecyclerListener,
    private val movies: ArrayList<MovieResult>
) : RecyclerView.Adapter<TopRatedMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieViewHolder {
        val itemBinding =
            ItemTopRatedMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopRatedMovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TopRatedMovieViewHolder, position: Int) {
        holder.bind(movieRecyclerListener, movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}