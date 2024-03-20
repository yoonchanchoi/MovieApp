package com.example.movieapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApplication : Application() {
    companion object {
        lateinit var instance: MovieApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}