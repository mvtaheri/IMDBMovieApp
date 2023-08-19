package com.mohammad.imdbmovieapp.presentation.di

import com.mohammad.imdbmovieapp.data.datasource.MovieCacheDataSource
import com.mohammad.imdbmovieapp.data.datasourceimplementation.MovieCacheDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providesCacheData(): MovieCacheDataSource {
        return MovieCacheDataSourceImp()
    }
}