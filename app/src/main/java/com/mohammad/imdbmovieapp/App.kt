package com.mohammad.imdbmovieapp

import android.app.Application
import com.mohammad.imdbmovieapp.presentation.di.AppComponent
import com.mohammad.imdbmovieapp.presentation.di.AppModule
import com.mohammad.imdbmovieapp.presentation.di.DaggerAppComponent
import com.mohammad.imdbmovieapp.presentation.di.Injector
import com.mohammad.imdbmovieapp.presentation.di.MovieSubComponent
import com.mohammad.imdbmovieapp.presentation.di.NetModule
import com.mohammad.imdbmovieapp.presentation.di.RemoteDataModule

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

}