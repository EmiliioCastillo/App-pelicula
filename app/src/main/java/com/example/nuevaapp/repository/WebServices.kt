package com.example.nuevaapp.repository

import com.example.nuevaapp.application.AppConstant
import com.example.nuevaapp.data.model.MovieList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("/movie/upcoming")
    suspend fun getUpComingMovies(@Query("api_key")ApiKey:String): MovieList
    @GET("/movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key")ApiKey:String): MovieList
    @GET("/movie/popular")
    suspend fun getPopularMovies(@Query("api_key")ApiKey:String): MovieList
}

object RetroFitClient {

    val webservice by lazy{
         Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebServices::class.java)
    }

}



