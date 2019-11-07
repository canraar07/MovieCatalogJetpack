package com.canra.jetpackmovie.data.source.remote.network.model

import com.google.gson.annotations.SerializedName

data class ResponseTvModel(
    @field:SerializedName("original_name")
    val name: String?,

    @field:SerializedName("poster_path")
    val image: String?,

    @SerializedName("id")
    val id : String?,

    @SerializedName("overview")
    val overview : String?,

    @SerializedName("vote_average")
    val vote_Average: String?,

    @SerializedName("first_air_date")
    val release_Date: String?
)