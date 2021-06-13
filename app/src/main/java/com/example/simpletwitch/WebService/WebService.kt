package com.example.simpletwitch.WebService

import com.example.simpletwitch.Models.Category
import com.example.simpletwitch.Models.Channel
import retrofit2.http.GET
import retrofit2.http.Headers

interface WebService {

    @GET("categories")
    suspend fun getCategories(): List<Category>

    @GET("channels")
    suspend fun getChannels(): List<Channel>
}