package com.example.nuevaapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nuevaapp.data.model.MovieEntity


@Dao
interface MovieDao {

    @Query("SELECT * FROM MovieEntity")
    suspend fun getAllMovies() : List<MovieEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun SaveMovies(movie : MovieEntity)
}