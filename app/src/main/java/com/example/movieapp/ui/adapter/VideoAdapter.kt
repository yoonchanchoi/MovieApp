package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemVideoBinding
import com.example.movieapp.network.models.VideoInfoResult
import com.example.movieapp.ui.listener.VideoRecyclerListener

class VideoAdapter(
    private val videoRecyclerListener: VideoRecyclerListener,
    private val videoInfos: ArrayList<VideoInfoResult>
) : RecyclerView.Adapter<VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemBinding =
            ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videoRecyclerListener, videoInfos[position])
    }

    override fun getItemCount(): Int {
        return videoInfos.size
    }
}