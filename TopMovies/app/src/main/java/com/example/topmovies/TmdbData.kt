package com.example.topmovies

import com.google.gson.annotations.SerializedName

data class PopularMovies(
    @SerializedName("results") val results : List<Results>
)

data class Results (
    @SerializedName("poster_path") val poster_path : String,
    @SerializedName("title") val title : String,
    @SerializedName("overview") val overview : String
)