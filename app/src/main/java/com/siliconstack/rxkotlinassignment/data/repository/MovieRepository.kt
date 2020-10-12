package com.siliconstack.rxkotlinassignment.data.repository

import com.siliconstack.rxkotlinassignment.data.api.ApiService
import com.siliconstack.rxkotlinassignment.data.model.MovieData
import io.reactivex.Single
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    fun getMovieData():Single<List<MovieData>>{
        return apiService.getMovieData()
    }

}