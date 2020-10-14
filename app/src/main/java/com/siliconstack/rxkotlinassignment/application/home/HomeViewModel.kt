package com.example.assignment1.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siliconstack.rxkotlinassignment.R
import com.siliconstack.rxkotlinassignment.data.model.MovieData
import com.siliconstack.rxkotlinassignment.data.model.ParentObject
import com.siliconstack.rxkotlinassignment.data.repository.MovieRepository
import com.siliconstack.rxkotlinassignment.domain.usecase.MovieUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    var listOfMovie = MutableLiveData<List<MovieData>>()
    private val compositeDisposable=CompositeDisposable()

    init {
        getData()
    }

    fun getData(){
        val list = ArrayList<MovieData>()
       val result= movieRepository.getMovieData()
            .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.movieData.map {
                    list.add(MovieData(it.genre, it.id, it.poster, it.title, it.year))
                     Log.d("DATA","-"+list.size)
                }
            },{
                Log.e("error","${it.printStackTrace()}")
                it.printStackTrace()
            })
        compositeDisposable.add(result)

//        return list

//        val listOfMovie = movieRepository.getMovieData()
//             .subscribeOn(Schedulers.io())
//             .subscribe({
//                 it.movieData.map {
//                     Log.e("TAG", "" + it.title)
//                     movieList.add(MovieData(it.genre, it.id, it.poster, it.title, it.year))
//                     adapter.notifyDataSetChanged()
//                 }
//
//
//             }
//                 , {
//                     Log.e("TAG", it.toString())
//                 })



    }


//    var responseData = MutableLiveData<ArrayList<MovieData>>()
//    private var movieList = ArrayList<MovieData>()
//
//    fun getMovieList() : LiveData<ArrayList<MovieData>>{
//
//
//        movieList.add(MovieData("Animation",1,"https://goo.gl/1zUyyq","Dunkirt","2015"))
//        movieList.add(MovieData("Heroistic",2,"https://image.tmdb.org/t/p/w370_and_h556_bestv2/bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg","Jumanji","2008"))
//
//        responseData.value = movieList
//        return responseData
//    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
