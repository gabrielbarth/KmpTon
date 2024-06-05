package com.example.home

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
// todo: get banners and product grid from repositories
//    productsGridRepository: ProductGridRepository,
//    bannersRepository: BannersRepository
) : ViewModel() {

    val productGridUiState =  MutableStateFlow<ProductGridUiState>(
        ProductGridUiState.Success(
            listOf(Color.Red, Color.Blue, Color.Green)
        )
    ).asStateFlow()

    val bannersUiState = MutableStateFlow<BannersUiState?>(null).asStateFlow()
}



sealed interface ProductGridUiState {
    data class Success(val products: List<Color>) : ProductGridUiState
    object Error : ProductGridUiState
    object Loading : ProductGridUiState
}

sealed interface BannersUiState {
    data class Success(val banners: List<String>) : BannersUiState
    object Error : BannersUiState
    object Loading : BannersUiState
}
