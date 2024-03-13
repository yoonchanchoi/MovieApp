package com.example.movieapp.network.models.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieData(
    @PrimaryKey
    var id: Int
)
