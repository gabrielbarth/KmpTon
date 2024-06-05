package com.example.home.data

data class ProductItem(val id: Int, val title: String)

class ProductGridRepository {
    fun getProducts(): List<ProductItem> {
        return listOf(
            ProductItem(1, "Comprar agora"),
            ProductItem(2, "Tranferir"),
            ProductItem(3, "Pix"),
            ProductItem(4, "Seguros"),
            ProductItem(5, "Renda Extra")
        )
    }
}