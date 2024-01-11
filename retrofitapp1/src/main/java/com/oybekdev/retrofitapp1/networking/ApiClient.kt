package com.oybekdev.retrofitapp1.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    //qaysi URL ga murojat qilamiz
    //clientga nima imkoniyatlar berishimiz kere
    //qayerdan nimani olib kelsin

    const val BASE_URL = "https://simplifiedcoding.net/"
    fun getRetrofit():Retrofit{
        //interceptor
        val loginInterceptor = HttpLoggingInterceptor()
        loginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loginInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}