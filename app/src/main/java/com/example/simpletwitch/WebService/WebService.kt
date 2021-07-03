package com.example.simpletwitch.WebService

import com.example.simpletwitch.Models.Category
import com.example.simpletwitch.Models.Channel
import com.example.simpletwitch.Models.Comment
import retrofit2.http.*

interface WebService {

    @GET("categories")
    suspend fun getCategories(): List<Category>

    @GET("channels")
    suspend fun getChannels(): List<Channel>

    @GET("comments/{channel_id}")
    suspend fun getComments(@Path("channel_id") channelId: Int): List<Comment>

    @POST("comments")
    suspend fun createComment(@Body comment: Comment): Comment
}