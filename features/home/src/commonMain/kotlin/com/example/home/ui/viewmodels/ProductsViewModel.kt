package com.example.home.ui.viewmodels

import cafe.adriel.voyager.core.model.StateScreenModel
import com.example.domain.products.GetProductsUseCase
import com.example.domain.products.Products
import com.example.domain.utils.doOnResult

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
) : StateScreenModel<ProductGridUiState>(ProductGridUiState.Loading) {

    suspend fun fetchProducts() {
        getProductsUseCase()
            .doOnResult(
                onSuccess = {
                    mutableState.value = ProductGridUiState.Success(it)
                },
                onError = {
                    mutableState.value = ProductGridUiState.Error
                }
            )
    }
}

sealed interface ProductGridUiState {
    data class Success(val products: Products) : ProductGridUiState
    data object Error : ProductGridUiState
    data object Loading : ProductGridUiState
}
