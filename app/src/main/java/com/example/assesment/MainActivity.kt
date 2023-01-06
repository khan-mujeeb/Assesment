package com.example.assesment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.assesment.api.RetrofitInstance
import com.example.assesment.model.User
import com.example.assesment.repository.BaseRepository
import com.example.assesment.tablayout.TabViewLayout
import com.example.assesment.viewmodel.MainViewModel
import com.example.assesment.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userApi = RetrofitInstance.apiUser
            val baseRepository = BaseRepository(userApi)
            val mainViewModelFactory = MainViewModelFactory(baseRepository)
            val mainViewModel = ViewModelProvider(
                this,
                mainViewModelFactory
            ).get(MainViewModel::class.java)

            user = mainViewModel.user.collectAsLazyPagingItems()

            TabViewLayout()
        }
    }
    companion object {
        lateinit var user: LazyPagingItems<User>
    }
}
