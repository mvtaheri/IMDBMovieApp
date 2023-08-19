package com.mohammad.imdbmovieapp.presentation.di

import com.mohammad.imdbmovieapp.data.api.TMDBService
import com.mohammad.imdbmovieapp.data.datasource.MovieRemoteDataSource
import com.mohammad.imdbmovieapp.data.datasourceimplementation.MovieRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val api_key: String) {
    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(
        tmdbService: TMDBService
    ): MovieRemoteDataSource {
        return MovieRemoteDataSourceImp(api_key, tmdbService)
    }
}