package com.example.catalogoapp.src.register.data.datasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.28.120:3000"

    val api: RegisterService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RegisterService::class.java)
    }
}
