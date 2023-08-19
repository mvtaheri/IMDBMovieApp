package com.mohammad.imdbmovieapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.mohammad.imdbmovieapp.data.db.MovieDao
import com.mohammad.imdbmovieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "tmdb_client"
        ).build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }
}