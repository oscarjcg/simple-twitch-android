package com.example.simpletwitch.Repositories

import com.example.simpletwitch.Models.Category
import com.example.simpletwitch.WebService.WebService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class CategoryRepository {
    private val BASE_URL =  "https://backend-simple-twitch.oscarcatarigutierrez.com/api/"

    suspend fun getCategories() : List<Category> {
        return getRetrofit().create(WebService::class.java).getCategories()
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