package com.example.simpletwitch.Models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Comment {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("channel_id")
    @Expose
    var channelId: Int? = null

    @SerializedName("author")
    @Expose
    var author: String? = null

    @SerializedName("comment")
    @Expose
    var comment: String? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
}