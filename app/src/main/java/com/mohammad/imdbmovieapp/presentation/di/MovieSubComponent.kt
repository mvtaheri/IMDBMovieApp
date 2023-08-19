package com.mohammad.imdbmovieapp.presentation.di

import com.mohammad.imdbmovieapp.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}
