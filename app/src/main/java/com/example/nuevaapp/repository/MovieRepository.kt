package com.example.nuevaapp.repository

import com.example.nuevaapp.data.model.MovieList

interface MovieRepository {
   suspend fun getUpComingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}