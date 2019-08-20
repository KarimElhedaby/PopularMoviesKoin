package com.hamza.soluations.popularmovieskoin.service.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiKeyInterceptor(private val apikey: String?) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = original.newBuilder()
        if (apikey != null)
            request.header("api_key", Constant.API_KEY)
        request.method(original.method(), original.body())
        return chain.proceed(request.build())
    }
}
