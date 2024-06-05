package com.example.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.home.HomeRoute

fun NavGraphBuilder.addHomeScreen() {
    composable(
        route = "home",
    ) {
        HomeRoute()
    }
}