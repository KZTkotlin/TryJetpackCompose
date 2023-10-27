package com.example.api

import com.example.model.Article
import retrofit2.Response
import retrofit2.http.GET

interface QiitaApi {

    @GET("items")
    suspend fun articleItems(): Response<List<Article>>
}
