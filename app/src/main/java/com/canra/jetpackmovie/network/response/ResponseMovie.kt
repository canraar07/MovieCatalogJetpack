package com.canra.jetpackmovie.network.response

import com.canra.jetpackmovie.network.model.ResponseMovieModel
import com.google.gson.annotations.SerializedName

data class ResponseMovie(
    @SerializedName("results")
    val itemListMovie: List<ResponseMovieModel>? = null
)