package com.example.paginglibrary.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.assignmentmydatascience.data.SaveDataItem
import com.example.assignmentmydatascience.retrofit.Api


const val STARTING_INDEX =1

class ItemPagingSource(val api: Api): PagingSource<Int, SaveDataItem>()
{
    override fun getRefreshKey(state: PagingState<Int, SaveDataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SaveDataItem> {
        TODO("Not yet implemented")
    }


}