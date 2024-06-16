package com.example.data.mapper

import com.example.domain.utils.ErrorType
import com.example.domain.utils.RepositoryResult

fun <T> Result<T>.toRepositoryResult(): RepositoryResult<T> = map {
    RepositoryResult.Success(it)
}.getOrElse {
    RepositoryResult.Error(it.toErrorResult())
}


internal fun Throwable.toErrorResult() = when (this) {
    else -> ErrorType.GENERIC_ERROR
}