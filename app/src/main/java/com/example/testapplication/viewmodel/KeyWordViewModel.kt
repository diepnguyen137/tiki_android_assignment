package com.example.testapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.repository.KeyWordRepository

class KeyWordViewModel :ViewModel(){
    private var keyWordRepository:KeyWordRepository ?= null

    init {
        keyWordRepository = KeyWordRepository()
    }

    fun getAllKeyWords():MutableLiveData<List<String>>{
        return keyWordRepository!!.getKeyWords()
    }
}