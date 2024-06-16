package com.example.domain.products

import com.example.domain.utils.RepositoryResult

interface ProductsRepository {
    suspend fun getProducts(): RepositoryResult<Products>
}
