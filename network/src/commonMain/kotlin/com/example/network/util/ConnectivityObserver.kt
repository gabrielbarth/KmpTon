package com.example.network.util

import kotlinx.coroutines.flow.MutableStateFlow



expect class ConnectivityObserver() {
    val isNetworkConnected: MutableStateFlow<Boolean>
    fun start()
    fun stop()
    fun getStatus(success: (Boolean) -> Unit)
    enum class ConnectivityStatus {
        Available, Lost
    }
}