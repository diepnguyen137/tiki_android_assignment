package com.example.testapplication.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.testapplication.service.KeyWordService
import com.example.testapplication.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KeyWordRepository {
    private var keyWordService: KeyWordService? = null

    init {
        keyWordService = RetrofitService.create(KeyWordService::class.java)
    }

    fun getKeyWords(): MutableLiveData<List<String>> {
        val data = MutableLiveData<List<String>>()

        keyWordService?.getKeyWords()?.enqueue(object : Callback<List<String>> {
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.e(KeyWordService::class.java.simpleName, "Cannot fetch data")
            }

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                data.value = response.body()
            }

        })
        return data
    }
}