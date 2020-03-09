package com.ntsmoura.topmovies.models

import com.google.gson.annotations.SerializedName


data class Results (
    @SerializedName("poster_path") val poster_path : String,
    @SerializedName("title") val title : String,
    @SerializedName("overview") val overview : String
)