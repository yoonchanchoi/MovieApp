package com.example.movieapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemProductionCompanyBinding
import com.example.movieapp.network.models.ProductionCompanyResult
import com.example.movieapp.util.Constants

class ProductionCmpViewHolder(
    private val binding: ItemProductionCompanyBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(productionCompany: ProductionCompanyResult) {

        Glide.with(itemView)
            .load(Constants.IMAGE_BASE_URL + "w154" + productionCompany.logoPath)
            .error(R.drawable.error_img)
            .fitCenter()
            .into(binding.itemCvIv)

        binding.itemTvProductionCompany.text = productionCompany.name
    }

}