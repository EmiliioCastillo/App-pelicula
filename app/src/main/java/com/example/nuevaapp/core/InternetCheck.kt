package com.example.nuevaapp.core

import kotlinx.coroutines.coroutineScope
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketAddress

object InternetCheck {
    suspend fun isNetworkAvailable() = coroutineScope {
        return@coroutineScope try {
            val sock = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8" , 23)
            sock.connect(socketAddress, 2000)
            true
        }catch (e : Exception){
            false
        }
    }
}