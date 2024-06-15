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
            HomeUiState.Success(
                products = listOf(Color.Red, Color.Blue, Color.Green),
                banners = listOf(Color.Red, Color.Blue, Color.Green)
            )
        }
    }
}
sealed interface HomeUiState {
    data class Success(val products: List<Color>, val banners: List<Color>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}

