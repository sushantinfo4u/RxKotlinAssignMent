package com.siliconstack.rxkotlinassignment.domain.repo

import com.siliconstack.rxkotlinassignment.domain.models.MovieDataModel
import io.reactivex.Single

interface RemoteRepo {
    fun getMovieData():Single<MovieDataModel>
}