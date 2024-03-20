package com.example.movieapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemCountryBinding
import com.example.movieapp.network.models.ProductionCountryResult

class CountryViewHolder(
    private val binding: ItemCountryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(productionCountry: ProductionCountryResult) {
        binding.itemTv.text = productionCountry.countryCode
    }
}