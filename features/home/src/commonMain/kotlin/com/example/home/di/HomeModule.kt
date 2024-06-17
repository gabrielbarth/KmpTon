package com.example.home.di

import com.example.domain.banners.GetBannersUseCase
import com.example.domain.products.GetProductsUseCase
import com.example.domain.products.ProductsRepository
import com.example.home.ui.viewmodels.BannersViewModel
import com.example.home.ui.viewmodels.HomeViewModel
import com.example.home.ui.viewmodels.ProductsViewModel

import org.koin.dsl.module

val homeViewModelModule = module {
    single { GetProductsUseCase(get()) }
    single { GetBannersUseCase(get()) }

    single { ProductsViewModel(get()) }
    single { BannersViewModel(get()) }
    single { HomeViewModel(get(), get()) }
}

fun homeModule() = listOf(
    homeViewModelModule,
)

