package com.mohammad.imdbmovieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mohammad.imdbmovieapp.domain.usecase.GetMovieUseCase
import com.mohammad.imdbmovieapp.domain.usecase.UpdateMovieUseCase

class ViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return com.mohammad.imdbmovieapp.presentation.ViewModel(
            getMovieUseCase,
            updateMovieUseCase
        ) as T
    }
}