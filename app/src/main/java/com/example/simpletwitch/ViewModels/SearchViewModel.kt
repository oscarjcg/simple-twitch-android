package com.example.simpletwitch.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpletwitch.Models.SearchResult
import com.example.simpletwitch.Repositories.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {
    val searchResults = MutableLiveData<List<SearchResult>>()
    private val searchRepository = SearchRepository()
    var showingSearchResults = false

    fun search(term: String) {
        viewModelScope.launch {
            searchResults.value = searchRepository.getSearchResults(term)
        }
    }

}
