package com.mohammad.imdbmovieapp.data.datasourceimplementation

import com.mohammad.imdbmovieapp.data.datasource.MovieLocalDataSource
import com.mohammad.imdbmovieapp.data.db.MovieDao
import com.mohammad.imdbmovieapp.data.db.TMDBDatabase
import com.mohammad.imdbmovieapp.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImp(private val tmdbDatabase: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return tmdbDatabase.getAllMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            tmdbDatabase.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tmdbDatabase.deleteAllMovies()
        }
    }
}