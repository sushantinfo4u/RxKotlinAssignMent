package com.siliconstack.rxkotlinassignment.data.di

import com.siliconstack.rxkotlinassignment.data.api.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    fun bindApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}