package com.example.movieapp.network.models.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.MovieResult

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieData:MovieDetailsResult)

    @Update
    suspend fun update(movieData:MovieDetailsResult)

    @Delete
    suspend fun delete(movieData:MovieDetailsResult)

    @Query("SELECT * FROM MovieTable")
    suspend fun getMovies() : List<MovieDetailsResult>

    @Query("SELECT * FROM MovieTable WHERE id = :id")
    suspend fun selectMovie(id: Int): MovieDetailsResult?

    @Query("DELETE FROM MovieTable WHERE id = :id")
    suspend fun deleteMovie(id: Int)
}