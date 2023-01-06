package com.example.assesment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assesment.repository.BaseRepository

class MainViewModelFactory(private val baseRepository: BaseRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(baseRepository) as T
    }


}