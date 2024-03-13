package com.example.movieapp.ui.listener

import android.net.Uri

interface VideoRecyclerListener {
    fun onVideoItemClick(uri: Uri)
}