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
) : StateScreenModel<ProductGridUiState>(ProductGridUiState.Loading) {

    val bannersUiState = MutableStateFlow<BannersUiState?>(null).asStateFlow()

    init {
        getData()
    }
    fun getData() {
        mutableState.update {
            ProductGridUiState.Success(
                listOf(Color.Red, Color.Blue, Color.Green)
            )
        }
    }
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
