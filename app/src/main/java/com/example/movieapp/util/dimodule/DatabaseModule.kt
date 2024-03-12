//package com.example.movieapp.util.dimodule
//
//import android.content.Context
//import androidx.room.Room
//import com.example.movieapp.network.models.roomdb.MovieDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//class DatabaseModule {
//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext context: Context) =
//        Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
//            .fallbackToDestructiveMigration()
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideMovieDao(appDatabase: MovieDatabase) = appDatabase.movieDao()
//}