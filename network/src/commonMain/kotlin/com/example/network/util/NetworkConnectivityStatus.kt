package com.example.network.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn

class NetworkConnectivityObserver(
    private val connectivityObserver: ConnectivityObserver
)  {
    fun observe(): Flow<ConnectivityObserver.ConnectivityStatus> = callbackFlow {
        connectivityObserver.isNetworkConnected.collect { status ->
            trySend(
                if (status) {
                    ConnectivityObserver.ConnectivityStatus.Available
                } else {
                    ConnectivityObserver.ConnectivityStatus.Lost
                }
            )
        }

    }.flowOn(Dispatchers.IO).distinctUntilChanged()
}