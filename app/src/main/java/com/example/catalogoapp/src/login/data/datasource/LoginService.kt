package com.example.catalogoapp.src.login.data.datasource

import com.example.catalogoapp.src.login.data.model.LoginDTO
import com.example.catalogoapp.src.login.data.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/users/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginDTO>
}