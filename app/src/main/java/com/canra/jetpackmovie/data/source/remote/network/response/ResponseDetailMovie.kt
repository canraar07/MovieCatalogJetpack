package com.canra.jetpackmovie.data.source.remote.network.response

import com.google.gson.annotations.SerializedName

data class ResponseDetailMovie (

    @SerializedName("title")
    val title : String?,

    @SerializedName("overview")
    val overview : String?,

    @SerializedName("poster_path")
    val poster : String?,

    @SerializedName("vote_average")
    val vote : Float?,

    @SerializedName("release_date")
    val releaseDate : String?


)