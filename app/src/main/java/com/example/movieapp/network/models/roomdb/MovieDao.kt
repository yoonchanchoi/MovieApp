package com.example.movieapp.network.models.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.movieapp.network.models.MovieDetailsResult

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieData:MovieData)

    @Update
    suspend fun update(movieData:MovieData)

    @Delete
    suspend fun delete(movieData:MovieData)

    @Query("SELECT * FROM MovieTable")
    suspend fun getMovies() : List<MovieData>

    @Query("SELECT * FROM MovieTable WHERE id = :id")
    suspend fun selectMovie(id: Int): MovieData?

    @Query("DELETE FROM MovieTable WHERE id = :id")
    suspend fun deleteMovie(id: Int)
}