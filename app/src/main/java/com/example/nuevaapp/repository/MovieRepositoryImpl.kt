package com.example.nuevaapp.repository

import com.example.nuevaapp.core.InternetCheck
import com.example.nuevaapp.data.local.LocalDataSource
import com.example.nuevaapp.data.model.MovieList
import com.example.nuevaapp.data.model.tomovieEntity
import com.example.nuevaapp.data.remote.RemoteMovieDataSource


class MovieRepositoryImpl(private val dataSourceRemote : RemoteMovieDataSource,
private val dataSourceLocal : LocalDataSource
): MovieRepository {
    override suspend fun getUpComingMovies(): MovieList {
        return if(InternetCheck.isNetworkAvailable()){
            dataSourceRemote.getUpComingMovies().results.forEach { movie ->
                dataSourceLocal.SaveMovies(movie.tomovieEntity("upcoming"))
        }
             dataSourceLocal.getUpComingMovie()
        }else{
             dataSourceLocal.getUpComingMovie()
        }
    }

    override suspend fun getTopRatedMovies(): MovieList {
        return if(InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getUpComingMovies().results.forEach { movie ->
                dataSourceLocal.SaveMovies(movie.tomovieEntity("toprated"))
            }
            dataSourceLocal.getTopRatedMovies ()
        }else{
                dataSourceLocal.getTopRatedMovies()
            }
        }


    override suspend fun getPopularMovies(): MovieList {
        return if(InternetCheck.isNetworkAvailable()){
            dataSourceRemote.getUpComingMovies().results.forEach { movie ->
                dataSourceLocal.SaveMovies(movie.tomovieEntity("popular"))
            }
            dataSourceLocal.getPopularMovies()
        }else{
            dataSourceLocal.getPopularMovies()
        }
    }
}