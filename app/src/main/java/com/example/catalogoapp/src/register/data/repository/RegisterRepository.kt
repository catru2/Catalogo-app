package com.example.catalogoapp.src.register.data.repository

import com.example.catalogoapp.src.register.data.datasource.RegisterService
import com.example.catalogoapp.src.register.data.model.CreateUserRequest

class RegisterRepository(private val api: RegisterService) {
    suspend fun registerUser(name: String, password: String) =
        api.registerUser(CreateUserRequest(name,  password))
}