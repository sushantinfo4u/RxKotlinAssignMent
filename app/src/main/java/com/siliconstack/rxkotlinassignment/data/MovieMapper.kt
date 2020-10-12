package com.siliconstack.rxkotlinassignment.data

import com.siliconstack.rxkotlinassignment.data.model.MovieData
import com.siliconstack.rxkotlinassignment.domain.models.MovieDataModel
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun toMovieDetails(moviewData: MovieData):MovieDataModel{
        return MovieDataModel(
            moviewData.genre?:"",
            moviewData.id?:0,
            moviewData.poster?:""
        )
    }
}