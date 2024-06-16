package com.example.data.mapper

import com.example.data.dto.BannersResponseDTO
import com.example.data.dto.BannerItemResponseDTO
import com.example.domain.banners.Banner
import com.example.domain.banners.Banners

internal fun BannersResponseDTO.toDomain(): Banners = Banners(
    banners = banners.map { it.toDomain() }
)
private fun BannerItemResponseDTO.toDomain(): Banner = Banner(
    id = id.toInt(),
    title = title,
    imageUrl = "https://example.com/$id.png"
)
