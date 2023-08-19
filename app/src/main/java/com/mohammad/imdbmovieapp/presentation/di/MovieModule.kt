package com.mohammad.imdbmovieapp.presentation.di

import com.mohammad.imdbmovieapp.domain.usecase.GetMovieUseCase
import com.mohammad.imdbmovieapp.domain.usecase.UpdateMovieUseCase
import com.mohammad.imdbmovieapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): ViewModelFactory {
        return ViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }
}