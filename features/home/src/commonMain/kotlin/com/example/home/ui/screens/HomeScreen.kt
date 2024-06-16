package com.example.home.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.example.home.ui.viewmodels.BalanceUiState
import com.example.home.ui.viewmodels.BannersUiState
import com.example.home.ui.viewmodels.HomeUiState
import com.example.home.ui.viewmodels.HomeViewModel
import com.example.home.ui.viewmodels.ProductGridUiState
import com.example.theme.AppTheme


class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val homeViewModel = getScreenModel<HomeViewModel>()
        val homeUiState by homeViewModel.state.collectAsState()

        HomeScreen(
            homeUiState = homeUiState,
        )
    }

    @Composable
    internal fun HomeScreen(
        homeUiState: HomeUiState,
        modifier: Modifier = Modifier
    ) {
        when (homeUiState) {
            is HomeUiState.Default -> {
                val scrollState = rememberScrollState()
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color(0xFF00EA33))
                        .verticalScroll(state = scrollState)
                    ,
                ) {
                    Header(modifier = modifier)
                    Surface(
                        color = MaterialTheme.colors.background,
                        shape = RoundedCornerShape(
                            topStart = 32.dp,
                            topEnd = 32.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(AppTheme.space.large),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            UserBalance(homeUiState.balanceUiState)
                            Banners(homeUiState.bannersUiState)
                            Divider(modifier = Modifier.fillMaxWidth())
                            Products(homeUiState.productGridUiState, modifier)
                        }
                    }
                }
            }
            is HomeUiState.Loading -> {
                Text("Loading")
            }
        }

    }

}


@Composable
fun UserBalance(balanceUiState: BalanceUiState) {

    when (balanceUiState) {
        is BalanceUiState.Success -> {
            Balance()
        }
        is BalanceUiState.Loading -> {
            Text("Loading")
        }
        is BalanceUiState.Error -> {
            Text("Error")
        }
    }
}

@Composable
fun Banners(bannersUiState: BannersUiState) {
    when (bannersUiState) {
        is BannersUiState.Success -> {
            BannersList()
        }
        is BannersUiState.Loading -> {
            Text("Loading")
        }
        is BannersUiState.Error -> {

        }
    }
}

@Composable
fun Products(productGridUiState: ProductGridUiState, modifier: Modifier) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(AppTheme.space.large),
            verticalArrangement = Arrangement.spacedBy(AppTheme.space.large),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (productGridUiState) {
                is ProductGridUiState.Success -> {
                    val products = productGridUiState.products
                    ProductGrid(products.products)
                }
                is ProductGridUiState.Loading -> {
                    Text("Loading")
                }
                is ProductGridUiState.Error -> {
                    Text("Error")
                }
            }
        }
    }
}
