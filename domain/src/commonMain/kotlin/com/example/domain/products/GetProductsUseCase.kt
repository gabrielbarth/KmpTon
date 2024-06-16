package com.example.domain.products

import com.example.domain.utils.SuspendUseCaseInteractor
import com.example.domain.utils.UseCaseResult

class GetProductsUseCase(
    private val repository: ProductsRepository
) : SuspendUseCaseInteractor {

    suspend operator fun invoke(): UseCaseResult<Products> = run(repository.getProducts())
}