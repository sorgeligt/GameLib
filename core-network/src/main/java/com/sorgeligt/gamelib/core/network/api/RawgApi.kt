package com.sorgeligt.gamelib.core.network.api

import com.sorgeligt.gamelib.core.network.model.base.PagedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {

    @GET("api/games")
    suspend fun games(
        @Query("page_size") elem_count: Int = 10,
        @Query("ordering") ordering: String = "",
        @Query("dates") dates: String = ""
    ): PagedResponse

}


