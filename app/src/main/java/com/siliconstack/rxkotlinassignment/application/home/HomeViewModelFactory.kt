package com.siliconstack.rxkotlinassignment.application.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment1.ui.home.HomeViewModel
import com.siliconstack.rxkotlinassignment.R
import com.siliconstack.rxkotlinassignment.data.repository.MovieRepository
import com.siliconstack.rxkotlinassignment.domain.usecase.MovieUseCase

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(private val movieRepository: MovieRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(movieRepository) as T
    }

}