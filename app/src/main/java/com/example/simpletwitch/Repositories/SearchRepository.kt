package com.example.simpletwitch.Repositories

import com.example.simpletwitch.Models.Category
import com.example.simpletwitch.Models.SearchResult
import com.example.simpletwitch.WebService.WebService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchRepository {
    private val BASE_URL =  "https://backend-simple-twitch.oscarcatarigutierrez.com/api/"

    suspend fun getSearchResults(term: String) : List<SearchResult> {
        return getRetrofit().create(WebService::class.java).getSearchResults(term)
    }

    private fun getRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
