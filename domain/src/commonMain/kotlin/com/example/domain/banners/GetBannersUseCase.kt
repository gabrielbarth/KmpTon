package com.example.domain.banners

import com.example.domain.banners.Banners
import com.example.domain.banners.BannersRepository
import com.example.domain.utils.SuspendUseCaseInteractor
import com.example.domain.utils.UseCaseResult

class GetBannersUseCase(
    private val repository: BannersRepository
) : SuspendUseCaseInteractor {

    suspend operator fun invoke(): UseCaseResult<Banners> = run(repository.getBanners())
}