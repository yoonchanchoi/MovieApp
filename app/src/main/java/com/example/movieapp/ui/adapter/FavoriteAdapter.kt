package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemCountryBinding
import com.example.movieapp.databinding.ItemFavoriteMovieBinding
import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.ProductionCountryResult
import com.example.movieapp.ui.listener.MovieRecyclerListener

class FavoriteAdapter (
    private val movieRecyclerListener: MovieRecyclerListener,
    private val movies: ArrayList<MovieDetailsResult>
    ) : RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemBinding =
            ItemFavoriteMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(movieRecyclerListener, movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}