package com.oybekdev.retrofitapp1.networking

import com.oybekdev.retrofitapp1.model.MarverData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("demos/marvel/")
    fun getMarvels(): Call<List<MarverData>>
}