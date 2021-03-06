package com.eaglecode16.basemvp.model.datasource.network

import com.eaglecode16.basemvp.model.datasource.network.response.RandomCatResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 *
 */
object RetrofitClient {

    interface MeowService {

        @GET("meow")
        suspend fun getRandomCat(): RandomCatResponse

    }

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    val service: MeowService = Retrofit.Builder().apply {
        baseUrl("https://aws.random.cat/")
        addConverterFactory(GsonConverterFactory.create())
        client(okHttpClient)
    }.build().create(MeowService::class.java)
}

