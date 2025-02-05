package com.example.catalogoapp.src.createRopa.data.repository

import com.example.catalogoapp.src.createRopa.data.model.CreateRopaRequest
import com.example.catalogoapp.src.createRopa.data.datasource.CreateRopaService

class RopaRepository(private val api: CreateRopaService) {
    suspend fun createRopa(name: String, description: String, price: Int, talla: String) =
        api.createRopa(CreateRopaRequest(name, description, price, talla))
}