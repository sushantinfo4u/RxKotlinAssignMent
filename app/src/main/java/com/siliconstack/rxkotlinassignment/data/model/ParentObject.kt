package com.siliconstack.rxkotlinassignment.data.model

import com.google.gson.annotations.SerializedName

 class ParentObject(
    @SerializedName("data")
    val movieData: List<MovieData>
)