package com.example.data.dto

import kotlinx.serialization.Serializable

@Serializable
internal data class ProductsResponseDTO(
    val data: List<ProductItemResponseDTO>
)

@Serializable
internal data class ProductItemResponseDTO(
    val buttonId: String,
    val order: Int
)

