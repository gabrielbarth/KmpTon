package com.example.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
            is HomeUiState.Success -> {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Header()
                    Balance()
                    BannerList(homeUiState.banners)
                    ProductGrid(homeUiState.products)
                }
            }

            is HomeUiState.Loading -> {
                Text("Loading")
            }

            else -> {
                Text("Error")
            }
        }

    }

}

@Composable
fun Header() {
    Text("Header")
}

@Composable
fun Balance() {
    Text("Balance")
}

@Composable
fun BannerList(items: List<Color>) {
    Text("BannerList")
}

@Composable
fun ProductGrid(items: List<Color>) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val rows = (items.size + 2) / 3
            repeat(rows) { rowIndex ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    val start = rowIndex * 3
                    val end = minOf(start + 3, items.size)
                    for (i in start until end) {
                        ProductItem(color = items[i])
                    }
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