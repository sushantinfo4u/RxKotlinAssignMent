package com.siliconstack.rxkotlinassignment.domain.models

import com.google.gson.annotations.SerializedName

data class MovieDataModel(
    val genre: String,
    val id: Int,
    val poster: String
)