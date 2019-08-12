package com.example.testapplication.service

import retrofit2.Call
import retrofit2.http.GET

interface KeyWordService {
    @GET("keywords.json")
    fun getKeyWords():Call<List<String>>
}