package com.example.topmovies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbInterface {
    @GET("3/movie/popular?api_key=f6bb68c7b93579c67fac95dd598d4098")
    fun getMovies(
        //@Query("api_key") key: String
    ): Call<PopularMovies>
}