package com.canra.jetpackmovie.data.source.remote.network.model

import com.google.gson.annotations.SerializedName

data class ResponseTvModel(
    @field:SerializedName("original_name")
    val name: String?,

    @field:SerializedName("poster_path")
    val image: String?,

    @SerializedName("id")
    val id : String?
)