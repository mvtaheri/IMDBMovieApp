package com.mohammad.imdbmovieapp.presentation.di

import com.mohammad.imdbmovieapp.data.datasource.MovieCacheDataSource
import com.mohammad.imdbmovieapp.data.datasource.MovieLocalDataSource
import com.mohammad.imdbmovieapp.data.datasource.MovieRemoteDataSource
import com.mohammad.imdbmovieapp.domain.repository.MovieRepository
import com.mohammad.imdbmovieapp.domain.repository.MovieRepositoryImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImp(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }
}