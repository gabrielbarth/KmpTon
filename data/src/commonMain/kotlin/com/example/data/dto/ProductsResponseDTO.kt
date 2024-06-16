package com.example.data.dto


internal data class ProductsResponseDTO(
    val products: List<ProductItemResponseDTO>
)

internal data class ProductItemResponseDTO(
    val id: String,
    val label: String
)

