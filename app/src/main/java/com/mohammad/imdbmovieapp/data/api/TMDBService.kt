package com.mohammad.imdbmovieapp.data.api

import com.mohammad.imdbmovieapp.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        api_key: String
    ): Response<MovieList>
}