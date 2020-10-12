package com.siliconstack.rxkotlinassignment.domain.usecase

import com.siliconstack.rxkotlinassignment.domain.models.MovieDataModel
import com.siliconstack.rxkotlinassignment.domain.repo.RemoteRepo
import io.reactivex.Single
import javax.inject.Inject

class GetMovieDettailUseCase @Inject constructor(val apirepo:RemoteRepo):SingleUsecase<MovieDataModel> {
    override fun execute(): Single<MovieDataModel> {
     return  apirepo.getMovieData()
    }


}