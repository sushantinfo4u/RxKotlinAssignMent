package com.siliconstack.rxkotlinassignment.domain.usecase

import com.siliconstack.rxkotlinassignment.data.model.MovieData
import com.siliconstack.rxkotlinassignment.data.repository.MovieRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val movieRepository: MovieRepository
                                              , subscribeScheduler: Scheduler,
                                              postExecutionScheduler: Scheduler)
    :MovieUseCase<List<MovieData>,Unit>(subscribeScheduler,postExecutionScheduler){

    override fun buildUseCaseSingle(params: Unit?): Single<List<MovieData>> {
       return movieRepository.getMovieData()
    }


}