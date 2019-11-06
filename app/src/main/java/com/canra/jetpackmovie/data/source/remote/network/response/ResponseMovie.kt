package com.canra.jetpackmovie.data.source.remote.network.response

import com.canra.jetpackmovie.data.source.remote.network.model.ResponseMovieModel
import com.google.gson.annotations.SerializedName

data class ResponseMovie(
    @SerializedName("results")
    val itemListMovie: List<ResponseMovieModel>? = null
)