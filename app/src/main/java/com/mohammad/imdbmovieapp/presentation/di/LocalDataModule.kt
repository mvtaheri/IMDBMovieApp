package com.mohammad.imdbmovieapp.presentation.di

import com.mohammad.imdbmovieapp.data.datasource.MovieLocalDataSource
import com.mohammad.imdbmovieapp.data.datasourceimplementation.MovieLocalDataSourceImp
import com.mohammad.imdbmovieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun providesLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImp(movieDao)
    }
}