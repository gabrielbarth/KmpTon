package com.example.data.repository

import com.example.data.api.ApiServiceImpl
import com.example.data.mapper.toDomain
import com.example.data.mapper.toRepositoryResult
import com.example.domain.banners.Banners
import com.example.domain.banners.BannersRepository
import com.example.domain.utils.RepositoryResult

internal class BannersRepositoryImpl(
    private val api: ApiServiceImpl
) : BannersRepository {

    override suspend fun getBanners(): RepositoryResult<Banners> =
        api.getBanners()
            .mapCatching { it.toDomain() }
            .toRepositoryResult()
}
