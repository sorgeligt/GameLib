package com.sorgeligt.gamelib.core.network.model

import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("id") var id: Long,
    @SerializedName("name") var name: String,
    @SerializedName("background_image") var imageUrl: String?,
    )
