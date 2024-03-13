package com.example.movieapp.network.services

import com.example.movieapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class HeadersInterceptor @Inject constructor(
) : Interceptor {

    companion object {
        private const val CLIENT_TOKEN = BuildConfig.CLIENT_TOKEN
    }
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", CLIENT_TOKEN)
            .build()
        return chain.proceed(request)
    }
}