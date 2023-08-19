package com.mohammad.imdbmovieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mohammad.imdbmovieapp.domain.usecase.GetMovieUseCase
import com.mohammad.imdbmovieapp.domain.usecase.UpdateMovieUseCase

class ViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movies = getMovieUseCase.execute()
        emit(movies)
    }

    fun updateMovies() = liveData {
        val updateMovies = updateMovieUseCase.ececute()
        emit(updateMovies)
    }

}