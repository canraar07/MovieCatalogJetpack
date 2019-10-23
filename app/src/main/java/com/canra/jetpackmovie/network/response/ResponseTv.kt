package com.canra.jetpackmovie.network.response

import com.canra.jetpackmovie.network.model.ResponseTvModel
import com.google.gson.annotations.SerializedName

data class ResponseTv(
    @SerializedName("results")
    val itemListTv: List<ResponseTvModel>? = null
)