package com.example.catalogoapp.src.viewCatalogo.data.datasource

import ViewCatalogoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientViewCatalogo{
    private const val BASE_URL = "http://192.168.28.120:3000"

    val api: ViewCatalogoService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ViewCatalogoService::class.java)
    }
}