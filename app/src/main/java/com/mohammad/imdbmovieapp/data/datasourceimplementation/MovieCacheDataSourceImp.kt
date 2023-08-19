package com.mohammad.imdbmovieapp.data.datasourceimplementation

import com.mohammad.imdbmovieapp.data.datasource.MovieCacheDataSource
import com.mohammad.imdbmovieapp.data.model.Movie

class MovieCacheDataSourceImp : MovieCacheDataSource {
    private var moviesList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}