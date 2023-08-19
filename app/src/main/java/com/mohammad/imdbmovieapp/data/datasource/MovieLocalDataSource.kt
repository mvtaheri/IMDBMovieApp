package com.mohammad.imdbmovieapp.data.datasource

import com.mohammad.imdbmovieapp.data.model.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}