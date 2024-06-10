package di

import data.HomeApi
import io.ktor.client.HttpClient
import network.httpClient
import org.koin.dsl.module

private val networkModule = module {
    single<HttpClient> { httpClient }
}

private val dataModule = module {
    single { HomeApi(httpClient = get()) }
}

fun appModule() = listOf(
    networkModule,
    dataModule
)