package com.siliconstack.rxkotlinassignment.data.repository

import com.siliconstack.rxkotlinassignment.data.api.ApiService
import com.siliconstack.rxkotlinassignment.data.model.MovieData
import com.siliconstack.rxkotlinassignment.data.model.ParentObject
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    fun getMovieData():Single<ParentObject>{
        return apiService.getMovieData().subscribeOn(io())
    }

}