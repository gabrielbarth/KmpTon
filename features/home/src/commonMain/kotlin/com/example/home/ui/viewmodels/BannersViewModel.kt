package com.example.home.ui.viewmodels

import cafe.adriel.voyager.core.model.StateScreenModel
import com.example.domain.banners.GetBannersUseCase
import com.example.domain.banners.Banners
import com.example.domain.utils.doOnResult

class BannersViewModel(
    private val getBannersUseCase: GetBannersUseCase,
) : StateScreenModel<BannersUiState>(BannersUiState.Loading) {

    suspend fun fetchBanners() {
        getBannersUseCase()
            .doOnResult(
                onSuccess = {
                    mutableState.value = BannersUiState.Success(it)
                },
                onError = {
                    mutableState.value = BannersUiState.Error
                }
            )
    }
}

sealed interface BannersUiState {
    data class Success(val banners: Banners) : BannersUiState
    data object Error : BannersUiState
    data object Loading : BannersUiState
}

