package com.example.simpletwitch.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpletwitch.Models.Category
import com.example.simpletwitch.Repositories.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    val categories = MutableLiveData<List<Category>>()
    private val categoryRepository = CategoryRepository()

    init {
        viewModelScope.launch {
            categories.value = categoryRepository.getCategories()
        }
    }
}