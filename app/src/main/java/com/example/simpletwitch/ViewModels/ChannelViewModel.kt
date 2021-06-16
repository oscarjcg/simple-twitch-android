package com.example.simpletwitch.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpletwitch.Models.Channel
import com.example.simpletwitch.Repositories.ChannelRepository
import kotlinx.coroutines.launch

class ChannelViewModel : ViewModel() {
    val channels = MutableLiveData<List<Channel>>()
    var useBigView = false

    private val channelRepository = ChannelRepository()

    init {
        viewModelScope.launch {
            channels.value = channelRepository.getChannels()
        }
    }

}