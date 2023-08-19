package com.mohammad.imdbmovieapp.domain.usecase

import com.mohammad.imdbmovieapp.data.model.Movie
import com.mohammad.imdbmovieapp.domain.repository.MovieRepository

class GetMovieUseCase(val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}