package com.example.catalogoapp.src.createRopa.data.model

data class CreateRopaRequest(
    val name: String,
    val description: String,
    val price : Int,
    val talla: String
)