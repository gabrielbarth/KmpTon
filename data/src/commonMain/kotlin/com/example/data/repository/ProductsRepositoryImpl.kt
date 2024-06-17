package com.example.data.repository

import com.example.data.api.ApiServiceImpl
import com.example.data.mapper.toDomain
import com.example.data.mapper.toRepositoryResult
import com.example.domain.products.Products
import com.example.domain.products.ProductsRepository
import com.example.domain.utils.RepositoryResult

internal class ProductsRepositoryImpl(
    private val api: ApiServiceImpl
) : ProductsRepository {

    override suspend fun getProducts(): RepositoryResult<Products> =
        api.getProducts()
            .mapCatching { it.toDomain() }
            .toRepositoryResult()
}
