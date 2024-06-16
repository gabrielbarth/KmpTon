package com.example.network.adapter

sealed class Failure(
    open val code: String = "",
    open val errorMessage: String = ""
) : Exception() {

    data class GenericError(
        override val code:  String = "",
        override val errorMessage:  String = ""
    ) : Failure()

    data class NetworkError(
        override val code: String ="10530",
        override val errorMessage: String = "No network connection Error"
    ) : Failure()
}
