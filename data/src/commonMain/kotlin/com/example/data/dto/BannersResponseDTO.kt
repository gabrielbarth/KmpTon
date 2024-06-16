package com.example.data.dto

import kotlinx.serialization.Serializable

@Serializable
internal data class BannersResponseDTO(
    val data: List<BannerItemResponseDTO>
)

@Serializable
internal data class BannerActionResponseDTO (
    val type: String,
    val data: String
)

@Serializable
internal data class BannerVisibilityResponseDTO (
    val type: String,
    val data: String,
    val show_on_fallback: Boolean? = null
)

@Serializable
internal data class BannerItemResponseDTO(
    val id: String,
    val image: String,
    val action: BannerActionResponseDTO,
    val visibility: BannerVisibilityResponseDTO,
    val priority: Float
)
