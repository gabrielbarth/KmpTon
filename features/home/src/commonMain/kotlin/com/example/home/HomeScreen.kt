package com.example.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.example.home.components.ProductGrid

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val homeViewModel = getScreenModel<HomeViewModel>()
        val productGridUiState by homeViewModel.state.collectAsState()
//    val bannersUiState by homeViewModel.bannersUiState.collectAsState()

        HomeScreen(
            productGridUiState = productGridUiState,
//        bannersUiState = bannersUiState,
            //modifier = modifier,
        )
    }

    @Composable
    internal fun HomeScreen(
        productGridUiState: ProductGridUiState,
//    bannersUiState: BannersUiState?,
        modifier: Modifier = Modifier
    ) {
        when (productGridUiState) {
            is ProductGridUiState.Success -> {
                ProductGrid(
                    productGridUiState.products
                )
            }

            is ProductGridUiState.Loading -> {
                Text("Loading")
            }

            else -> {
                Text("Error")
            }
        }

    }

}
