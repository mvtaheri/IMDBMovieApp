package com.mohammad.imdbmovieapp.presentation.di

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}