package com.example.assignmentmydatascience.retrofit

import com.example.assignmentmydatascience.data.SaveData
import com.example.assignmentmydatascience.data.SaveDataItem
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {


    @GET("posts")
    fun getData(
        ): Call<SaveData>


}