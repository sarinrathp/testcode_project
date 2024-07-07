package com.sarinrath.testcode_project.services.api

import com.sarinrath.testcode_project.model.Article
import retrofit2.http.GET

interface APIInterface {

    @GET("/v2/everything?q=android&from=2024-07-05&to=2024-07-05&sortBy=popularity&apiKey=e8c625cbce934e50a130b4a9a902d777")
    suspend fun getNews(): Article

}