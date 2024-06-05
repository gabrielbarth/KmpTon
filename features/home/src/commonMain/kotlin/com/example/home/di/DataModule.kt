package com.example.home.di

import com.example.home.data.ProductGridRepository
import org.koin.dsl.module

val dataModule = module {
    single<ProductGridRepository> { ProductGridRepository() }
}

