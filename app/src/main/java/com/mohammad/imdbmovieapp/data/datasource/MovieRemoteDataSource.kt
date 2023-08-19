package com.mohammad.imdbmovieapp.data.datasource

import com.mohammad.imdbmovieapp.data.model.Movie
import com.mohammad.imdbmovieapp.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}