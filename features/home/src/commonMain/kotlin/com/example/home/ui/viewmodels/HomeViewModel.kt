package com.example.home.ui.viewmodels

import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val productsViewModel: ProductsViewModel,
    private val bannersViewModel: BannersViewModel
) : StateScreenModel<HomeUiState>(HomeUiState.Loading) {

    init {

        combineViewModelStates()

        screenModelScope.launch {
            getData()
        }
    }


    private fun combineViewModelStates() {
        val combinedFlow = productsViewModel.state.combine(bannersViewModel.state) { productState, bannersState ->
            HomeUiState.Default(
                productGridUiState = productState as ProductGridUiState,
                bannersUiState = bannersState as BannersUiState,
                balanceUiState = BalanceUiState.Success(Color.Red)
            )
        }
        combinedFlow.onEach { newState ->
            mutableState.value = newState
        }.launchIn(screenModelScope)
    }

    suspend fun getData() {
        println("ViewModel get data")
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

