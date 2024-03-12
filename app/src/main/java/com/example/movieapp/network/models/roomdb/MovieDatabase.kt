package com.example.movieapp.network.models.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieapp.network.models.MovieDetailsResult
import com.example.movieapp.network.models.roomdb.converters.BelongsToCollectionTypeConverter
import com.example.movieapp.network.models.roomdb.converters.GenreResultListTypeConverter
import com.example.movieapp.network.models.roomdb.converters.ProductionCompanyResultTypeConverter
import com.example.movieapp.network.models.roomdb.converters.ProductionCountryResultTypeConverter
import com.example.movieapp.network.models.roomdb.converters.SpokenLanguageResultTypeConverter

@Database(entities = [MovieDetailsResult::class], version = 1)
@TypeConverters(
    value = [
        BelongsToCollectionTypeConverter::class,
        GenreResultListTypeConverter::class,
        ProductionCompanyResultTypeConverter::class,
        ProductionCountryResultTypeConverter::class,
        SpokenLanguageResultTypeConverter::class
    ]
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}