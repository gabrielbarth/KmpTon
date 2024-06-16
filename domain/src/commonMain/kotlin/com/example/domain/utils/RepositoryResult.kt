package com.example.domain.utils

sealed class RepositoryResult<out T> {

    data class Success<out T>(val data: T) : RepositoryResult<T>()

    data class Error(val errorType: ErrorType) : RepositoryResult<Nothing>()
}