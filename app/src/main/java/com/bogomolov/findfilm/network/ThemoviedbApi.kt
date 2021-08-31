package com.bogomolov.findfilm.network

import com.bogomolov.findfilm.data.ServerItemsWrapper
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ThemoviedbApi {
    @GET("?")
    fun makeRequest(
        @Query("s") query: String,
        @Query("type") type: String
    ): Call<ServerItemsWrapper>

    @GET
    suspend fun downloadPoster(
        @Url posterUrl: String
    ): ResponseBody
}