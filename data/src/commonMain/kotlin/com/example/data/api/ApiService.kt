package com.example.data.api

import com.example.data.dto.BannerItemResponseDTO
import com.example.data.dto.BannersResponseDTO
import com.example.data.dto.ProductsResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.serializersModule
import kotlinx.serialization.modules.SerializersModule

internal interface ApiService {

    suspend fun getProducts(): Result<ProductsResponseDTO>

    suspend fun getBanners(): Result<BannersResponseDTO>
}



internal class ApiServiceImpl(
    private val httpClient: HttpClient = ApiClient
) : ApiService {

    override suspend fun getProducts(): Result<ProductsResponseDTO> {
        return runCatching {
           httpClient.get("/v1/products").body<ProductsResponseDTO>()
        }
    }

    override suspend fun getBanners(): Result<BannersResponseDTO> {
        return runCatching {
          httpClient.get("/v1/banners").body<BannersResponseDTO>()
        }
    }
}