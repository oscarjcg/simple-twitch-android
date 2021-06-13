package com.example.simpletwitch.Repositories

import com.example.simpletwitch.Models.Channel
import com.example.simpletwitch.WebService.WebService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChannelRepository {
    private val BASE_URL =  "https://backend-simple-twitch.oscarcatarigutierrez.com/api/"

    suspend fun getChannels() : List<Channel> {
        return getRetrofit().create(WebService::class.java).getChannels()
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
}