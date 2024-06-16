package com.example.data.mapper

import com.example.data.dto.BannerActionResponseDTO
import com.example.data.dto.BannersResponseDTO
import com.example.data.dto.BannerItemResponseDTO
import com.example.data.dto.BannerVisibilityResponseDTO
import com.example.domain.banners.Banner
import com.example.domain.banners.BannerAction
import com.example.domain.banners.BannerVisibility
import com.example.domain.banners.Banners

internal fun BannersResponseDTO.toDomain(): Banners = Banners(
    banners = data.map { it.toDomain() }
)
internal fun BannerActionResponseDTO.toDomain(): BannerAction = BannerAction(
    type = type,
    data = data
)
internal fun BannerVisibilityResponseDTO.toDomain(): BannerVisibility = BannerVisibility(
    type = type,
    data = data,
    show_on_fallback = show_on_fallback
)
private fun BannerItemResponseDTO.toDomain(): Banner = Banner(
    id = id,
    image = image,
    action = action.toDomain(),
    visibility = visibility.toDomain(),
    priority = priority
)
