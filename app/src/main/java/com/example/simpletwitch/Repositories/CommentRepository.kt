package com.example.simpletwitch.Repositories

import com.example.simpletwitch.Models.Comment
import com.example.simpletwitch.WebService.WebService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CommentRepository {
    private val BASE_URL =  "https://backend-simple-twitch.oscarcatarigutierrez.com/api/"

    suspend fun getComments(channelId: Int) : List<Comment> {
        return getRetrofit().create(WebService::class.java).getComments(channelId)
    }

    private fun getRetrofit(): Retrofit {
        val gson = GsonBuilder()
            //.setLenient()//
            .create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            //.addConverterFactory(ScalarsConverterFactory.create())//
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    suspend fun createComment(author: String, channel_id: Int, comment: String) : Comment {
        val c = Comment()
        c.comment = comment
        c.author = author
        c.channelId = channel_id
        return getRetrofit().create(WebService::class.java).createComment(c)
    }

}