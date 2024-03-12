package com.example.movieapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemTopRatedMovieBinding
import com.example.movieapp.network.models.MovieResult
import com.example.movieapp.ui.listener.MovieRecyclerListener
import com.example.movieapp.util.Constants

class TopRatedMovieViewHolder(
    private val binding: ItemTopRatedMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movieRecyclerListener: MovieRecyclerListener, movie: MovieResult) {
        Glide.with(itemView)
            .load(Constants.IMAGE_BASE_URL + "w342" + movie.posterPath)
            .error(R.drawable.error_img)
            .fitCenter()
            .into(binding.itemCvIv)
        binding.itemTvMovieTitle.text = movie.originalTitle
        binding.itemTvPopularity.text = "Popularity" + movie.popularity.toString()
        binding.topRatedMovieItem.setOnClickListener { movieRecyclerListener.onMovieItemClick(movie.id) }

    }
}