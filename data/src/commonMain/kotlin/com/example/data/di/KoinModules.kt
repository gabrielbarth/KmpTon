package com.example.data.di


import com.example.data.api.ApiServiceImpl
import com.example.data.api.ApiClient
import com.example.data.repository.BannersRepositoryImpl
import com.example.data.repository.ProductsRepositoryImpl
import com.example.domain.banners.BannersRepository
import com.example.domain.products.ProductsRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

private val repositoriesModules = module {
    single<HttpClient> { ApiClient }

    single { ApiServiceImpl(get()) }

    single<BannersRepository> { BannersRepositoryImpl(get()) }
    single<ProductsRepository> { ProductsRepositoryImpl(get()) }
}

val dataModule = repositoriesModules