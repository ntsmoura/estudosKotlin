package com.ntsmoura.topmovies.models

import com.google.gson.annotations.SerializedName

data class PopularMovies(
    @SerializedName("results") val results : List<Results>
)