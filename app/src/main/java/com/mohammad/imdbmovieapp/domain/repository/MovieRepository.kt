package com.mohammad.imdbmovieapp.domain.repository

import com.mohammad.imdbmovieapp.data.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun updateMovies(): List<Movie>
}