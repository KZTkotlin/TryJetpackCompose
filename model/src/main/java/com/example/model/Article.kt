package com.example.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "id")
    val id: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "body")
    val body: String,
    @Json(name = "created_at")
    val created_at: String,
    @Json(name = "updated_at")
    val updated_at: String,
    @Json(name = "user")
    val user: User
)

@JsonClass(generateAdapter = true)
data class User(
    val id: String,
    val name: String,
    val profile_image_url: String
)
