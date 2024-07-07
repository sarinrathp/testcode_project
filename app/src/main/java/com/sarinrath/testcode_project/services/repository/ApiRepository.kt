package com.sarinrath.testcode_project.services.repository

import com.sarinrath.testcode_project.model.Article
import com.sarinrath.testcode_project.services.api.APIClient

class ApiRepository {
    private val newsService = APIClient.getNewsService

    suspend fun getNews(): Article {
        return newsService.getNews()
    }

}