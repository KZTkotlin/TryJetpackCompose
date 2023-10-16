package com.example.api

import com.example.model.Article
import retrofit2.Call
import retrofit2.http.GET

interface QiitaApi {

//    @GET("items")
//    suspend fun articleItems(
//        @Query("query") query: String?
//    ): Call<List<Article>>

    @GET("items")
    suspend fun articleItems(): Call<List<Article>>
}
