package di

import data.ProductGridRepository
import org.koin.dsl.module

val dataModule = module {
    single<ProductGridRepository> { ProductGridRepository() }
}

