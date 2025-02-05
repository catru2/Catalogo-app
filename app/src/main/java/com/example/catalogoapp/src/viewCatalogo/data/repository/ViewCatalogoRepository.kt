package com.example.catalogoapp.src.viewCatalogo.data.repository

import ViewCatalogoService
import com.example.catalogoapp.src.viewCatalogo.data.model.ViewCatalogoDTO

class ViewCatalogoRepository(private val api: ViewCatalogoService) {
    suspend fun getTasks(): List<ViewCatalogoDTO> {
        return api.viewTasks()
    }
}