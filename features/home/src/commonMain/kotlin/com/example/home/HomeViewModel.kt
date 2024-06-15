package com.example.home

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import cafe.adriel.voyager.core.model.StateScreenModel
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(
// todo: get banners and product grid from repositories
//    productsGridRepository: ProductGridRepository,
//    bannersRepository: BannersRepository
) : StateScreenModel<HomeUiState>(HomeUiState.Loading) {

    init {
        getData()
    }
    fun getData() {
        mutableState.update {
            HomeUiState.Default(
                productGridUiState = ProductGridUiState.Success(listOf(Color.Red, Color.Blue, Color.Green)),
                bannersUiState = BannersUiState.Success(listOf(Color.Red, Color.Blue, Color.Green)),
                balanceUiState = BalanceUiState.Success(Color.Red)
            )
        }
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


sealed interface ProductGridUiState {
    data class Success(val products: List<Color>) : ProductGridUiState
    object Error : ProductGridUiState
    object Loading : ProductGridUiState
}

sealed interface BalanceUiState {
    data class Success(val balance: Color) : BalanceUiState
    object Error : BalanceUiState
    object Loading : BalanceUiState
}

sealed interface BannersUiState {
    data class Success(val banners: List<Color>) : BannersUiState
    object Error : BannersUiState
    object Loading : BannersUiState
}

