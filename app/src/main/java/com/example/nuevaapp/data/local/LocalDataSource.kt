package com.example.nuevaapp.data.local

import com.example.nuevaapp.application.AppConstant
import com.example.nuevaapp.data.model.MovieEntity
import com.example.nuevaapp.data.model.MovieList
import com.example.nuevaapp.data.model.toMovieList

class LocalDataSource(private val movieDao : MovieDao) {
    suspend fun getUpComingMovie(): MovieList{
        return movieDao.getAllMovies().filter{ it.movie_type == "upComing"}.toMovieList()
    }
    suspend fun getTopRatedMovies(): MovieList{
        return movieDao.getAllMovies().filter{ it.movie_type == "TopRated"}.toMovieList()
    }
    suspend fun getPopularMovies(): MovieList{
        return movieDao.getAllMovies().filter{ it.movie_type == "Popular"}.toMovieList()
    }

    suspend fun SaveMovies(movie : MovieEntity) {
        movieDao.SaveMovies(movie)
    }
}