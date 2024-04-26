package com.example.assignmentmydatascience.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.assignmentmydatascience.data.SaveData
import com.example.assignmentmydatascience.repository.GetDataRepository
import kotlinx.coroutines.launch
import retrofit2.Call

class GetDataViewModel(app:Application) : AndroidViewModel(app) {

     val responseData: MutableLiveData<Call<SaveData>> = MutableLiveData()
    private val getDataRepository: GetDataRepository = GetDataRepository()

    fun getResponseData() {
        viewModelScope.launch {
            val response = getDataRepository.getData()
            responseData.value = response
        }
    }





}