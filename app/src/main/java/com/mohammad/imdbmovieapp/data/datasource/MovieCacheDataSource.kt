package com.mohammad.imdbmovieapp.data.datasource

import com.mohammad.imdbmovieapp.data.model.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}