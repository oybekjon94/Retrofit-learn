package com.oybekdev.retrofitapp1

import android.app.DownloadManager.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.oybekdev.retrofitapp1.model.MarverData
import com.oybekdev.retrofitapp1.networking.ApiClient
import com.oybekdev.retrofitapp1.networking.ApiService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
        
        apiService.getMarvels()
                //callback murojatni taminlab beradi
            .enqueue(object :Callback<List<MarverData>>{
                override fun onResponse(
                    call: Call<List<MarverData>>,
                    response: Response<List<MarverData>>,
                ) {
                    if (response.isSuccessful && response.body()!= null){
                        
                    }
                }

                override fun onFailure(call: Call<List<MarverData>>, t: Throwable) {

                }

            })
        //okhttp3
        val okHttpClient = OkHttpClient()
        val request = okhttp3.Request.Builder().url("https://jsonplaceholder.typicode.com/users/1").build()
        okHttpClient.newCall(request).enqueue(object :okhttp3.Callback{ //enqueue navbatga quyib beradi
            override fun onFailure(call: okhttp3.Call, e: IOException) {

            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful){
                    Log.d(TAG, "onResponse: ${response.body?.string()}")
                }
            }

        })
    }
}