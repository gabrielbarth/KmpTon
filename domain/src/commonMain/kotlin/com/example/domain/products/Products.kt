package com.example.domain.products

import org.jetbrains.compose.resources.DrawableResource

data class Products(val products: List<Product>)

data class Product(val id: String, val label: String, val icon: String)
