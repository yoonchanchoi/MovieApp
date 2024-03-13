package com.example.movieapp.network.models.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.network.models.MovieDetailsResult

@Database(entities = [MovieData::class], version = 2)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}