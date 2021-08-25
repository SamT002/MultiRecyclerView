package com.example.multirecyclerview.retrofit

import com.example.multirecyclerview.URL.BOOK_URL
import com.example.multirecyclerview.URL.JOKE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    private lateinit var retrofit: Retrofit

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    fun getJokeInstance(): Request {

        retrofit = Retrofit.Builder()
            .baseUrl(JOKE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(Request::class.java)
    }

    fun getBookInstance(): Request {

        retrofit = Retrofit.Builder()
            .baseUrl(BOOK_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(Request::class.java)

    }
}