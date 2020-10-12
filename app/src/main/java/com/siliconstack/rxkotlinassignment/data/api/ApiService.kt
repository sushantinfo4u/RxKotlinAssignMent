package com.siliconstack.rxkotlinassignment.data.api

import com.siliconstack.rxkotlinassignment.data.model.MovieData
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

//    https://movies-sample.herokuapp.com/api/movies

    @GET("movies")
    fun getMovieData(): Single<List<MovieData>>

}