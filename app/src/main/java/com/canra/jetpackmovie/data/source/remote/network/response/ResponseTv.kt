package com.canra.jetpackmovie.data.source.remote.network.response

import com.canra.jetpackmovie.data.source.remote.network.model.ResponseTvModel
import com.google.gson.annotations.SerializedName

data class ResponseTv(
    @SerializedName("results")
    val itemListTv: List<ResponseTvModel>? = null
)