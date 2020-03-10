package com.ntsmoura.topmovies.models

import com.google.gson.annotations.SerializedName


data class Results (
    @SerializedName("poster_path") val posterPath : String,
    val title : String,
    val overview : String
)