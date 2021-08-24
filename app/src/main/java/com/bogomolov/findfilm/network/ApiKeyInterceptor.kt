package com.bogomolov.findfilm.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    companion object {
        private const val API_KEY = "3258c3c9b9befa0f6b26260b997a17ab"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalURL = chain.request().url()
        val newURL = originalURL.newBuilder()
            .addQueryParameter("apikey", API_KEY)
            .build()
        val newRequest = chain.request().newBuilder()
            .url(newURL)
            .build()
        return chain.proceed(newRequest)
    }
}