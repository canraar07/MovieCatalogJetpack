package com.canra.jetpackmovie.network

import com.canra.jetpackmovie.data.source.remote.network.response.ResponseDetailTV
import com.canra.jetpackmovie.data.source.remote.network.response.ResponseMovie
import com.canra.jetpackmovie.data.source.remote.network.response.ResponseTv
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndpoind {
    @GET("discover/movie?api_key=7baea0b7eb88df553c9d48a2fb89d1e4&")
    fun getListMovie(@Query("language") languange: String): Call<ResponseMovie>

    @GET("discover/tv?api_key=7baea0b7eb88df553c9d48a2fb89d1e4&")
    fun getListTvShow(@Query("language") languange: String): Call<ResponseTv>
}