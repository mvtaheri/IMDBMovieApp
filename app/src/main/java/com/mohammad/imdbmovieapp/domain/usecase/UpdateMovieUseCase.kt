package com.mohammad.imdbmovieapp.domain.usecase

import com.mohammad.imdbmovieapp.data.model.Movie
import com.mohammad.imdbmovieapp.domain.repository.MovieRepository

class UpdateMovieUseCase(val movieRepository: MovieRepository) {
    suspend fun ececute(): List<Movie>? = movieRepository.updateMovies()
}