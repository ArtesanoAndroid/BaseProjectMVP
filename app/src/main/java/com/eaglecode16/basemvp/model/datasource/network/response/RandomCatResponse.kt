package com.eaglecode16.basemvp.model.datasource.network.response

import com.google.gson.annotations.SerializedName

data class RandomCatResponse(
    @SerializedName("file") val url: String = ""
)