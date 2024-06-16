package com.example.data.mapper

import com.example.data.dto.ProductItemResponseDTO
import com.example.data.dto.ProductsResponseDTO
import com.example.domain.products.Product
import com.example.domain.products.Products

internal fun ProductsResponseDTO.toDomain(): Products =
    Products(
        products = data.map { it.toDomain() }
    )

private fun ProductItemResponseDTO.toDomain(): Product = Product(
    buttonId = buttonId,
    order = order,
)
