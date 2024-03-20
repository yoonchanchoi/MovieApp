package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemPosterMovieBinding
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.ui.listener.MovieRecyclerListener

class PosterMovieAdapter(
    private val movieRecyclerListener: MovieRecyclerListener,
) : RecyclerView.Adapter<PosterMovieViewHolder>() {

    private var movieList = arrayListOf<MovieResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterMovieViewHolder {
        val itemBinding =
            ItemPosterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PosterMovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PosterMovieViewHolder, position: Int) {
        holder.bind(movieRecyclerListener, movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setData(movies: ArrayList<MovieResult>) {
        movies?.let {
            this.movieList = it
        }
        notifyDataSetChanged()
    }

    fun addData(movies: ArrayList<MovieResult>) {
        movies?.let {
            movieList.addAll(it)
        }
        notifyDataSetChanged()
    }
}