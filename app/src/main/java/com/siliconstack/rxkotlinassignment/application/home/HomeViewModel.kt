package com.example.assignment1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siliconstack.rxkotlinassignment.R
import com.siliconstack.rxkotlinassignment.data.model.MovieData
import com.siliconstack.rxkotlinassignment.data.repository.MovieRepository
import com.siliconstack.rxkotlinassignment.domain.usecase.MovieUseCase
import io.reactivex.Scheduler
import javax.inject.Inject

class HomeViewModel @Inject constructor(movieRepository: MovieRepository) : ViewModel() {




    var responseData = MutableLiveData<ArrayList<MovieData>>()
    private var movieList = ArrayList<MovieData>()

    fun getMovieList() : LiveData<ArrayList<MovieData>>{


        movieList.add(MovieData("Animation",1,"https://goo.gl/1zUyyq","Dunkirt","2015"))
        movieList.add(MovieData("Heroistic",2,"https://image.tmdb.org/t/p/w370_and_h556_bestv2/bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg","Jumanji","2008"))

        responseData.value = movieList
        return responseData
    }



}
