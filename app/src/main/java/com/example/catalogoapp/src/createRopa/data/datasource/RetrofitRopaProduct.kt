package com.example.catalogoapp.src.createRopa.data.datasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientRopa {
    private const val BASE_URL = "http://192.168.28.120:3000"

    val api: CreateRopaService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CreateRopaService::class.java)
    }
}