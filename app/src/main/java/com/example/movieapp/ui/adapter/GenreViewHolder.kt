package com.example.movieapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemGenreBinding
import com.example.movieapp.network.models.GenreResult

class GenreViewHolder(
    private val binding: ItemGenreBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(genre: GenreResult) {
        binding.itemTv.text = genre.name
    }
}