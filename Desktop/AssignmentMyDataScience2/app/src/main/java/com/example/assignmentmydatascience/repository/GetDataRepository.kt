package com.example.assignmentmydatascience.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.assignmentmydatascience.data.SaveData
import com.example.assignmentmydatascience.data.SaveDataItem
import com.example.assignmentmydatascience.retrofit.RetrofitInstance
import com.example.paginglibrary.paging.ItemPagingSource
import retrofit2.Call

class GetDataRepository {

    fun getData(): Call<SaveData> {
        return RetrofitInstance.api.getData()
    }

    fun getDataPaging(): LiveData<PagingData<SaveDataItem>> = Pager(
        config = PagingConfig(
            10,
            5,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            ItemPagingSource(RetrofitInstance.api)
        }
    ).liveData

}