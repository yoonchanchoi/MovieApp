package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemProductionCompanyBinding
import com.example.movieapp.network.models.ProductionCompanyResult

class ProductionCmpAdapter(
    private val productionCompanies: ArrayList<ProductionCompanyResult>
) : RecyclerView.Adapter<ProductionCmpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductionCmpViewHolder {
        val itemBinding =
            ItemProductionCompanyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductionCmpViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProductionCmpViewHolder, position: Int) {
        holder.bind(productionCompanies[position])
    }

    override fun getItemCount(): Int {
        return productionCompanies.size
    }
}