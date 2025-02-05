package com.example.catalogoapp.src.viewCatalogo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogoapp.src.viewCatalogo.data.model.ViewCatalogoDTO
import com.example.catalogoapp.src.viewCatalogo.domain.ViewCatalogoaUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class ViewCatalogoViewModel(
    private val useCase: ViewCatalogoaUseCase
) : ViewModel()  {

    private val _ropas = MutableStateFlow<List<ViewCatalogoDTO>>(emptyList())
    val ropas: StateFlow<List<ViewCatalogoDTO>> = _ropas

    fun loadRopas() {
        viewModelScope.launch {
            _ropas.value = useCase.execute()
        }
    }
}