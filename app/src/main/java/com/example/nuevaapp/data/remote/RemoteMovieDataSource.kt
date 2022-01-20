package com.example.nuevaapp.data.remote

import com.example.nuevaapp.application.AppConstant
import com.example.nuevaapp.data.model.MovieList
import com.example.nuevaapp.repository.WebServices

class RemoteMovieDataSource (private val WebServices: WebServices) {
    suspend fun getUpComingMovies(): MovieList = WebServices.getUpComingMovies(AppConstant.API_KEY)
   suspend fun getTopRatedMovies(): MovieList = WebServices.getTopRatedMovies(AppConstant.API_KEY)
    suspend fun getPopularMovies(): MovieList = WebServices.getPopularMovies(AppConstant.API_KEY)
}
