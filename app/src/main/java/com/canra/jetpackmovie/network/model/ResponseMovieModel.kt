package com.canra.jetpackmovie.network.model

import com.google.gson.annotations.SerializedName

data class ResponseMovieModel(

    @SerializedName("title")
    val name: String?,

    @SerializedName("poster_path")
    val image: String?,

    @SerializedName("id")
    val id : String?

)