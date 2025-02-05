package com.example.catalogoapp.src.login.domain

import com.example.catalogoapp.src.login.data.model.LoginDTO
import com.example.catalogoapp.src.login.data.repository.LoginRepository
import retrofit2.Response

class LoginUseCase(private val repository: LoginRepository) {
    suspend fun execute(name: String, password: String): Response<LoginDTO> {
        return repository.loginUser(name, password)
    }
}