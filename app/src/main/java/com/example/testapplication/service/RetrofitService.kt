package com.example.testapplication.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/tikivn/android-home-test/v2/"
        fun <S> create(serviceClass: Class<S>): S {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(serviceClass)
        }
    }
}