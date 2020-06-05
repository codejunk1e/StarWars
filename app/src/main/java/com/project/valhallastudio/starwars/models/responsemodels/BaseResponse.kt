package com.project.valhallastudio.starwars.models.responsemodels

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<T>
)