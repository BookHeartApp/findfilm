package com.bogomolov.findfilm.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Network {
    private const val API_URI = "http://www.omdbapi.com/" // Что-то апишка с https://www.themoviedb.org/ не залетела, поменял на ту, что нашел на просторах гугла
    const val REQUEST_URI = "https://www.imdb.com/title/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(ApiKeyInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(API_URI)
        .build()

    val api: ThemoviedbApi
        get() = retrofit.create()
}