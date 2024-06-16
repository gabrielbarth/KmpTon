package com.example.data.api

import com.example.data.dto.BannersResponseDTO
import com.example.data.dto.ProductsResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal interface ApiService {

    suspend fun getProducts(): Result<ProductsResponseDTO>

    suspend fun getBanners(): Result<BannersResponseDTO>
}

internal class ApiServiceImpl(
    private val httpClient: HttpClient = ApiClient
) : ApiService {

    override suspend fun getProducts(): Result<ProductsResponseDTO> {
        return runCatching {
           val response = httpClient.get("/v1/products")
            ProductsResponseDTO(response.body())
        }
    }

    override suspend fun getBanners(): Result<BannersResponseDTO> {
        return runCatching {
           val response = httpClient.get("/v1/banners")
            BannersResponseDTO(response.body())
        }
    }
}