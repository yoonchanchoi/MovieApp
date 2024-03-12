package com.example.movieapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemFavoriteMovieBinding
import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.ui.listener.MovieRecyclerListener
import com.example.movieapp.util.Constants

class FavoriteViewHolder(
    private val binding: ItemFavoriteMovieBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movieRecyclerListener: MovieRecyclerListener, movie: MovieDetailsResult) {
        Glide.with(itemView)
            .load(Constants.IMAGE_BASE_URL + "w342" + movie.posterPath)
            .error(R.drawable.error_img)
            .fitCenter()
            .into(binding.itemCvIv)
        binding.itemTvMovieTitle.text = movie.title
        binding.itemTvPopularity.text = "Popularity" + movie.popularity.toString()
        binding.favoriteMovieItem.setOnClickListener { movieRecyclerListener.onMovieItemClick(movie.id) }

    }
}