package com.example.domain.banners


data class BannerAction(
    val type: String,
    val data: String
)

data class BannerVisibility(
    val type: String,
    val data: String,
    val show_on_fallback: Boolean? = null
)

data class Banner(
    val id: String,
    val image: String,
    val action: BannerAction,
    val visibility: BannerVisibility,
    val priority: Float
)

data class Banners(
    val banners: List<Banner>
)