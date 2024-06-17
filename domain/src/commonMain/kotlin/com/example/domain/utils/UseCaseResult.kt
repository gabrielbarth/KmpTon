package com.example.domain.utils

sealed class UseCaseResult<out D> {
    data class Success<D>(val data: D) : UseCaseResult<D>()
    object Error: UseCaseResult<Nothing>()
}

inline fun <D, F> RepositoryResult<D>.doOnResult(
    onSuccess: (D) -> UseCaseResult<F>,
    onError: (ErrorType) -> UseCaseResult<F>
): UseCaseResult<F> {
    return when (this) {
        is RepositoryResult.Success -> onSuccess(data)
        is RepositoryResult.Error -> onError(errorType)
    }
}

inline fun <D> UseCaseResult<D>.doOnResult(
    onSuccess: (D) -> Unit,
    onError: () -> Unit
) {
    when (this) {
        is UseCaseResult.Success -> onSuccess(data)
        is UseCaseResult.Error -> onError()
    }
}

suspend fun <A, B> UseCaseResult<A>.map(
    map: suspend (A) -> B
): UseCaseResult<B> {
    return when (this) {
        is UseCaseResult.Success -> UseCaseResult.Success(map(data))
        is UseCaseResult.Error -> this
    }
}