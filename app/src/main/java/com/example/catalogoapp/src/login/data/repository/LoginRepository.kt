package com.example.catalogoapp.src.login.data.repository

import com.example.catalogoapp.src.login.data.datasource.LoginService
import com.example.catalogoapp.src.login.data.model.LoginRequest

class LoginRepository(private val api: LoginService) {
    suspend fun loginUser(name: String, password: String) =
        api.loginUser(LoginRequest(name, password))
}