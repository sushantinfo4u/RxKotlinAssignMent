package com.siliconstack.rxkotlinassignment.data.model


import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("genre")
    val genre: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster")
    val poster: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: String
)