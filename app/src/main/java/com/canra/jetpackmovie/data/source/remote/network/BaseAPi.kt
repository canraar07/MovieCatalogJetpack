package com.canra.jetpackmovie.data.source.remote.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseAPi {
    const val BASE_URL: String = "https://api.themoviedb.org/3/"

    fun retrofitInit(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> creatService(service: Class<T>): T {
        return retrofitInit()!!.create(service)
    }
}