package com.example.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.home.ui.Balance
import com.example.home.ui.BannersList
import com.example.home.ui.ProductGrid
import com.example.theme.AppTheme
import com.example.theme.resources.Res
import com.example.theme.resources.menu_hamburger
import org.jetbrains.compose.resources.painterResource


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
                Column(
                    modifier = modifier.fillMaxSize().background(Color(0xFF00EA33)),
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
                            Products(homeUiState.productGridUiState)
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
fun Header(userFullName: String = "Nome Sobrenome", modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth().height(68.dp),
    ) {
        Row (
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(Res.drawable.menu_hamburger),
                contentDescription = "Menu",
                modifier = modifier.size(AppTheme.shape.extraLarge).padding(start = AppTheme.space.large)
            )
        }
        Row (
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
                Text(
                    text = userFullName,
                    style = MaterialTheme.typography.h6,
                )
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
fun Products(productGridUiState: ProductGridUiState) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(AppTheme.space.large),
            verticalArrangement = Arrangement.spacedBy(AppTheme.space.large),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (productGridUiState) {
                is ProductGridUiState.Success -> {
                    val items = productGridUiState.products
                    ProductGrid(items)
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

@Composable
fun ProductItem(color: Color) {
    Surface(
        modifier = Modifier.size(100.dp),
        shape = RoundedCornerShape(8.dp),
        color = color
    ) {
        // TODO
    }
}