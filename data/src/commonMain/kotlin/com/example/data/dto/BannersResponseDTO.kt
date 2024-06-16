package com.example.data.dto


internal data class BannersResponseDTO(
    val banners: List<BannerItemResponseDTO>
)

internal data class BannerItemResponseDTO(
    val id: String,
    val title: String,
    val imageUrl: String
)
