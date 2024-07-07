package com.sarinrath.testcode_project.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarinrath.testcode_project.model.Article
import com.sarinrath.testcode_project.services.api.APIClient
import com.sarinrath.testcode_project.services.api.APIInterface
import com.sarinrath.testcode_project.services.repository.ApiRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel() : ViewModel() {

    private val repository = ApiRepository()

    private val _news = MutableLiveData<Article>()
    val news: LiveData<Article> = _news

    fun fetchNews() {
        viewModelScope.launch {
            val response = repository.getNews()
            _news.value = response
        }
    }
}