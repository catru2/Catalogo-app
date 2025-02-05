package com.example.catalogoapp.src.createRopa.domain

import com.example.catalogoapp.src.createRopa.data.model.RopaDTO
import com.example.catalogoapp.src.createRopa.data.repository.RopaRepository
import retrofit2.Response

class CreateRopaUseCase(private val repository: RopaRepository) {
    suspend fun execute(name: String, description: String, price: Int, talla: String): Response<RopaDTO> {
        return repository.createRopa(name, description, price, talla)
    }
}
