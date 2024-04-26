package com.example.assignmentmydatascience.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private val retrofit by lazy {
        val gson: Gson = GsonBuilder().setLenient().create()
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }
}