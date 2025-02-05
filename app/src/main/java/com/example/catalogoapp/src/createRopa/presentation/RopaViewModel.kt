package com.example.catalogoapp.src.createRopa.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogoapp.src.createRopa.domain.CreateRopaUseCase
import kotlinx.coroutines.launch

open class RopaViewModel(
    private val createRopaUseCase: CreateRopaUseCase,
) : ViewModel() {
    fun createRopa(name: String, description: String, price: Int, talla: String) {
        viewModelScope.launch {
            try {
                val response = createRopaUseCase.execute(name, description, price, talla)
                if (response.isSuccessful) {
                    println(" Ropa Agregada al catalogo: ${response.body()}")
                } else {
                    println("❌ Error al agregar la prenda: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                println("⚠️ Error en la solicitud: ${e.message}")
            }
        }
    }
}
