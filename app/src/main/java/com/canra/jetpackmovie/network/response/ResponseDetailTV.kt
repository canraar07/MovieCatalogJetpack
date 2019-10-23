package com.canra.jetpackmovie.network.response

import com.canra.jetpackmovie.util.DataGenre
import com.google.gson.annotations.SerializedName

data class ResponseDetailTV (

    @SerializedName("original_name")
    val title : String?,

    @SerializedName("overview")
    val overview : String?,

    @SerializedName("poster_path")
    val poster : String?,

    @SerializedName("vote_average")
    val vote : Float?,

    @SerializedName("first_air_date")
    val releaseDate : String?,

    @SerializedName("genres")
    val genres: List<DataGenre>? = null

)