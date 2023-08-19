package com.mohammad.imdbmovieapp.domain.repository

import com.mohammad.imdbmovieapp.data.datasource.MovieCacheDataSource
import com.mohammad.imdbmovieapp.data.datasource.MovieLocalDataSource
import com.mohammad.imdbmovieapp.data.datasource.MovieRemoteDataSource
import com.mohammad.imdbmovieapp.data.model.Movie

class MovieRepositoryImp(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newMovieList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMovieList)
        movieCacheDataSource.saveMoviesToCache(newMovieList)
        return newMovieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var moviesList: List<Movie>
        moviesList = movieCacheDataSource.getMoviesFromCache()
        if (moviesList.size > 0)
            return moviesList
        else
            moviesList = getMoviesFromRoom()
        movieCacheDataSource.saveMoviesToCache(moviesList)
        return moviesList
    }

    private suspend fun getMoviesFromRoom(): List<Movie> {
        lateinit var movieList: List<Movie>
        movieList = movieLocalDataSource.getMoviesFromDB()
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
            return movieList
        }
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        var response = movieRemoteDataSource.getMovies()
        var body = response.body()
        if (body != null) {
            movieList = body.movies
        }
        return movieList
    }
}