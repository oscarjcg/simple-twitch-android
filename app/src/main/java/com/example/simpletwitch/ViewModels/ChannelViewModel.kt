package com.example.simpletwitch.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpletwitch.Models.Channel
import com.example.simpletwitch.Models.Comment
import com.example.simpletwitch.Repositories.ChannelRepository
import com.example.simpletwitch.Repositories.CommentRepository
import kotlinx.coroutines.launch

class ChannelViewModel : ViewModel() {
    val channels = MutableLiveData<List<Channel>>()
    var useBigView = false
    val comments = MutableLiveData<List<Comment>>()
    var channelId = 0

    private val channelRepository = ChannelRepository()
    private val commentRepository = CommentRepository()

    init {
        viewModelScope.launch {
            channels.value = channelRepository.getChannels()
        }
    }

    fun getChat(channelId: Int) {
        viewModelScope.launch {
            comments.value = commentRepository.getComments(channelId)
        }
    }

    fun createComment(author: String, channel_id: Int, comment: String) {
        viewModelScope.launch {
            commentRepository.createComment(author, channel_id, comment)
        }
    }

}