package com.example.movieapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemVideoBinding
import com.example.movieapp.network.models.VideoInfoResult
import com.example.movieapp.ui.listener.VideoRecyclerListener
//import com.example.movieapp.ui.listener.VideoRecyclerListener
import com.example.movieapp.util.Constants


class VideoViewHolder(
    private val binding: ItemVideoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        videoRecyclerListener: VideoRecyclerListener,
        videoInfo: VideoInfoResult
    ) {
        val strUrl = Constants.VIDEO_URL + videoInfo.key
        Log.e("cyc", "strUrl--->${strUrl}")
        val uri = Uri.parse(Constants.VIDEO_URL + videoInfo.key)
        binding.itemTvVideo.text = videoInfo.name

        Glide.with(itemView)
            .load(Constants.VIDEO_THUMNAIL_URL_front + videoInfo.key + Constants.VIDEO_THUMNAIL_URL_back)
            .error(R.drawable.error_img)
            .fitCenter()
            .into(binding.itemCvIvThbnail)
        binding.videoItem.setOnClickListener { videoRecyclerListener.onVideoItemClick(uri) }
    }
}


