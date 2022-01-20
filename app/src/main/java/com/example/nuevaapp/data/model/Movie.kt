package com.example.nuevaapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Movie(
    val id: Int = -1,
    val budget:Int = -1,
    val adult: Boolean = false,
    val genre_ids: List<Int> = listOf(),
    val backdrop_path: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date:String = "",
    val title:String = "",
    val video:Boolean = false,
    val vote_average:Double = -1.0,
    val vote_count:Int = -1,
    var movie_type:String = ""
)

data class MovieList(val results: List<Movie> = listOf())

//Room
    @Entity
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "adult")
    val id: Int = -1,
    @ColumnInfo(name = "backdrop_paths")
    val budget:Int = -1,
    @ColumnInfo(name = "original_title")
    val adult: Boolean = false,
    @ColumnInfo(name = "original_language")
    val backdrop_path: String = "",
    @ColumnInfo(name = "overview")
    val original_title: String = "",
    @ColumnInfo(name = "popularity")
    val original_language: String = "",
    @ColumnInfo(name = "poster_path")
    val overview: String = "",
    @ColumnInfo(name = "release_date")
    val popularity: Double = -1.0,
    @ColumnInfo(name = "video")
    val poster_path: String = "",
    @ColumnInfo(name = "vote_average")
    val release_date:String = "",
    @ColumnInfo(name = "vote_count")
    val title:String = "",
    @ColumnInfo(name = "title")
    val video:Boolean = false,
    val vote_average:Double = -1.0,
    val vote_count:Int = -1,
    @ColumnInfo(name = "movie_type")
    val movie_type:String = ""
)

fun List<MovieEntity>.toMovieList(): MovieList {
    val resultList = mutableListOf<Movie>()
    this.forEach{movieEntity ->
        resultList.add(movieEntity.toMovie())
    }
    return MovieList(resultList)
}


fun MovieEntity.toMovie() = Movie(
        this.id,
        this.budget,
        this.adult,
        this.backdrop_path,
        this.original_title,
        this.original_language,
        this.overview,
        this.popularity,
        this.poster_path,
        this.release_date,
        this.title,
        this.video,
        this.vote_average,
        this.vote_count,
        this.movie_type
)

fun Movie.tomovieEntity(movieType : String): MovieEntity{
    this.id,
    this.budget,
    this.adult,
    this.backdrop_path,
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    movie_type = movieType
}





