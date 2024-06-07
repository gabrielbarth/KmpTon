package com.example.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.home.components.ProductGrid

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = HomeViewModel()
) {
    val productGridUiState by homeViewModel.productGridUiState.collectAsState()
//    val bannersUiState by homeViewModel.bannersUiState.collectAsState()

    HomeScreen(
        productGridUiState = productGridUiState,
//        bannersUiState = bannersUiState,
        modifier = modifier,
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
