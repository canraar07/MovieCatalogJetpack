package com.canra.jetpackmovie.data.source.remote.network.model

import com.google.gson.annotations.SerializedName

data class ResponseMovieModel(

    @SerializedName("title")
    val name: String?,

    @SerializedName("poster_path")
    val image: String?,

    @SerializedName("id")
    val id : String?,

    @SerializedName("overview")
    val overview : String?,

    @SerializedName("vote_average")
    val vote_Average: String?,

    @SerializedName("release_date")
    val release_Date: String?

)