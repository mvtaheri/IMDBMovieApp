package com.mohammad.imdbmovieapp.data.model

import com.google.gson.annotations.SerializedName
import com.mohammad.imdbmovieapp.data.model.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)
