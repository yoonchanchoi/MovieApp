package com.example.movieapp.util.dimodule

import android.content.Context
import androidx.room.Room
import com.example.movieapp.network.models.roomdb.MovieDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context, gson: Gson) =
        Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: MovieDatabase) = appDatabase.movieDao()
}