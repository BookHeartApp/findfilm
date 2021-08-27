package com.bogomolov.findfilm.network

import com.bogomolov.findfilm.data.ServerItemsWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ThemoviedbApi {
    @GET("?")
    fun makeRequest(
        @Query("s") query: String,
        @Query("type") type: String
    ): Call<ServerItemsWrapper>

}