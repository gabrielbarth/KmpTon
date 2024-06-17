package com.example.domain.banners

import com.example.domain.utils.RepositoryResult

interface BannersRepository {
    suspend fun getBanners(): RepositoryResult<Banners>
}
