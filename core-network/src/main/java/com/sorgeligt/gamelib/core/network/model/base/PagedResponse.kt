package com.sorgeligt.gamelib.core.network.model.base

import com.google.gson.annotations.SerializedName
import com.sorgeligt.gamelib.core.network.model.GameDto

data class PagedResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val nextPageUrl: String,
    @SerializedName("previous") val previousPageUrl: String,
    @SerializedName("results") val results: List<GameDto>?,
)