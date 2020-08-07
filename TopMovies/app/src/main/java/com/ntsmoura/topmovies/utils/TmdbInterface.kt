package com.ntsmoura.topmovies.utils

import com.ntsmoura.topmovies.models.PopularMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbInterface {
    @GET("popular")
    fun getMovies(
        @Query("api_key") key: String,
        @Query("language") language: String
    ): Call<PopularMovies>
}