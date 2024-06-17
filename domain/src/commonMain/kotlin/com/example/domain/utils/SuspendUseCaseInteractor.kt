package com.example.domain.utils

interface SuspendUseCaseInteractor {

    suspend fun <R> SuspendUseCaseInteractor.run(response: RepositoryResult<R>): UseCaseResult<R> =
        response.doOnResult(
            onSuccess = { UseCaseResult.Success(it) },
            onError = { UseCaseResult.Error }
        )
}