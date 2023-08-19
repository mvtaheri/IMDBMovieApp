package com.mohammad.imdbmovieapp.data.datasourceimplementation

import com.mohammad.imdbmovieapp.data.api.TMDBService
import com.mohammad.imdbmovieapp.data.datasource.MovieRemoteDataSource
import com.mohammad.imdbmovieapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImp(private val api_key: String, private val api: TMDBService) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return api.getPopularMovies(api_key)
    }
}