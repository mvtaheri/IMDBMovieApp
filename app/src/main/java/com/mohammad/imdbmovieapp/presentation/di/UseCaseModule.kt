package com.mohammad.imdbmovieapp.presentation.di

import com.mohammad.imdbmovieapp.domain.repository.MovieRepository
import com.mohammad.imdbmovieapp.domain.usecase.GetMovieUseCase
import com.mohammad.imdbmovieapp.domain.usecase.UpdateMovieUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetUsecase(movieRepository: MovieRepository): GetMovieUseCase {
        return GetMovieUseCase(movieRepository)
    }

    @Provides
    fun providesUpdateUseCase(movieRepository: MovieRepository): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }
}