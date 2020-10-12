package com.siliconstack.rxkotlinassignment.data.remoterepoImpl

import com.siliconstack.rxkotlinassignment.data.MovieMapper
import com.siliconstack.rxkotlinassignment.data.api.ApiService
import com.siliconstack.rxkotlinassignment.domain.models.MovieDataModel
import com.siliconstack.rxkotlinassignment.domain.repo.RemoteRepo
import io.reactivex.Single
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(private val apiService: ApiService, private val shareMapper: dagger.Lazy<MovieMapper>):RemoteRepo{
    override fun getMovieData(): Single<MovieDataModel> {
        TODO("Not yet implemented")
    }

/*    override fun getMovieData(): Single<MovieDataModel> {
        return apiService.getMovieData().map {
            shareMapper.get().toMovieDetails()
        }
    }*/


}