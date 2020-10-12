package com.siliconstack.rxkotlinassignment.domain.usecase

import com.siliconstack.rxkotlinassignment.domain.models.MovieDataModel
import io.reactivex.Single

interface SingleUsecase<T> {
    fun execute():Single<MovieDataModel>
}