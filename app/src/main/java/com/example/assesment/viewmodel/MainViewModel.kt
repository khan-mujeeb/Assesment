package com.example.assesment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.assesment.model.User
import com.example.assesment.repository.BaseRepository
import com.example.assesment.source.UserSource
import kotlinx.coroutines.flow.Flow

class MainViewModel(private val baseRepository: BaseRepository): ViewModel() {

    val user: Flow<PagingData<User>> = Pager(PagingConfig(pageSize = 1)) {
        UserSource( baseRepository = baseRepository)
    }.flow.cachedIn(viewModelScope)

}