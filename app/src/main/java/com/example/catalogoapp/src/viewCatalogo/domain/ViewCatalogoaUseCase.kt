package com.example.catalogoapp.src.viewCatalogo.domain

import com.example.catalogoapp.src.viewCatalogo.data.model.ViewCatalogoDTO
import com.example.catalogoapp.src.viewCatalogo.data.repository.ViewCatalogoRepository

class ViewCatalogoaUseCase(private val repository: ViewCatalogoRepository) {
    suspend fun execute(): List<ViewCatalogoDTO> {
        return repository.getTasks()
    }
}