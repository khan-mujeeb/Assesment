package com.example.assesment.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.assesment.model.User
import com.example.assesment.repository.BaseRepository

class UserSource(private val baseRepository: BaseRepository): PagingSource<Int, User>() {
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val nextPage = params.key ?: 1
            val users = baseRepository.getUserData(nextPage).users
            LoadResult.Page(
                data = users,
                prevKey = if (nextPage==1) null else nextPage - 1,
                nextKey = nextPage.plus(1 )
            )
        } catch (e: java.lang.Exception) {
            LoadResult.Error(e)
        }
    }

}