package com.example.simpletwitch.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchResult {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null
}
