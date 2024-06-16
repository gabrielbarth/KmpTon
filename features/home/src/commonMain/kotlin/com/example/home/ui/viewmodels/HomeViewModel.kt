package com.example.home.ui.viewmodels

import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.combine


import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val productsViewModel: ProductsViewModel,
    private val bannersViewModel: BannersViewModel
) : StateScreenModel<HomeUiState>(HomeUiState.Loading) {

    init {
        combine(
            productsViewModel.state,
            bannersViewModel.state
        ) { states ->
            val (productGridUiState, bannersUiState) = states

            mutableState.update {
                HomeUiState.Default(
                    productGridUiState = productGridUiState as ProductGridUiState,
                    bannersUiState = bannersUiState as BannersUiState,
                    balanceUiState = BalanceUiState.Success(Color.Red)
                )
            }
        }

        screenModelScope.launch {
            getData()
        }
    }

    suspend fun getData() {
        productsViewModel.fetchProducts()
        bannersViewModel.fetchBanners()
    }
}

sealed interface HomeUiState {
    data class Default(
        val productGridUiState: ProductGridUiState,
        val bannersUiState: BannersUiState,
        val balanceUiState: BalanceUiState
    ) : HomeUiState
    object Loading : HomeUiState
}



sealed interface BalanceUiState {
    data class Success(val balance: Color) : BalanceUiState
    data object Error : BalanceUiState
    data object Loading : BalanceUiState
}

