package com.siliconstack.rxkotlinassignment.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.siliconstack.rxkotlinassignment.data.model.MovieData
import com.siliconstack.rxkotlinassignment.data.model.ParentObject
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


interface ApiService {

//    https://movies-sample.herokuapp.com/api/movies

    @GET("movies")
        fun getMovieData(): Single<ParentObject>


    companion object {
        operator fun invoke(): ApiService {
            val URL = "https://movies-sample.herokuapp.com/api/"

            val logger: HttpLoggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .callTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(logger)

            val gson: Gson = GsonBuilder().setLenient().create()
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttp.build())
                .build()
                .create(ApiService::class.java)
        }
    }


}