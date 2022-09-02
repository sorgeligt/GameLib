package com.sorgeligt.gamelib.core.network.di

import com.sorgeligt.gamelib.core.network.api.RawgApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkComponent {

    private const val BASE_URL = "https://api.rawg.io/"

    fun createApi(): RawgApi = Retrofit.Builder()
        .baseUrl(
            BASE_URL
        )
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val request = chain.request().newBuilder()
                    val originalHttpUrl = chain.request().url
                    val newUrl = originalHttpUrl.newBuilder()
                        .addQueryParameter("key", "006cc50ac0714e7e83a68c3bde392523")
                        .build()
                    request.url(newUrl)
                    chain.proceed(request.build())
                }
                ).build()
        )
        .build()
        .create(
            RawgApi::
            class.java
        )

}
