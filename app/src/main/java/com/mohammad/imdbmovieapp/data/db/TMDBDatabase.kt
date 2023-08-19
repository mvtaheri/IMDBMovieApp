package com.mohammad.imdbmovieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohammad.imdbmovieapp.data.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}