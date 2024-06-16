package com.example.domain.banners

data class Banner(
    val id: Int,
    val title: String,
    val imageUrl: String
)
data class Banners(
    val banners: List<Banner>
)