package com.example.domain.products

import org.jetbrains.compose.resources.DrawableResource


data class Products(val products: List<Product>)

data class Product(
    val id: String,
    val name: String?,
    val icon: DrawableResource?,
    val order: Int
){}

