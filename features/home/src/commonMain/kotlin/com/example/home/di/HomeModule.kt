package com.example.home.di

import com.example.home.HomeViewModel
import com.example.home.data.ProductGridRepository
import org.koin.dsl.module

val homeDataModule = module {
    factory<ProductGridRepository> { ProductGridRepository() }
}

val homeViewModelModule = module {
    single { HomeViewModel() }
}

fun homeModule() = listOf(
    homeViewModelModule,
    homeDataModule
)

