package com.canra.jetpackmovie.network

import com.canra.jetpackmovie.network.response.ResponseDetailMovie
import com.canra.jetpackmovie.network.response.ResponseDetailTV
import com.canra.jetpackmovie.network.response.ResponseMovie
import com.canra.jetpackmovie.network.response.ResponseTv
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndpoind {
    @GET("discover/movie?api_key=7baea0b7eb88df553c9d48a2fb89d1e4&")
    fun getListMovie(@Query("language") languange: String): Call<ResponseMovie>

    @GET("discover/tv?api_key=7baea0b7eb88df553c9d48a2fb89d1e4&")
    fun getListTvShow(@Query("language") languange: String): Call<ResponseTv>

    @GET("movie/{id}?api_key=7baea0b7eb88df553c9d48a2fb89d1e4&")
    fun getDetailMovie(
        @Path("id") id : String,
        @Query("language") lang: String): Call<ResponseDetailMovie>

    @GET("tv/{id}?api_key=7baea0b7eb88df553c9d48a2fb89d1e4&")
    fun getDetailTV(
        @Path("id") id : String,
        @Query("language") lang: String): Call<ResponseDetailTV>
}