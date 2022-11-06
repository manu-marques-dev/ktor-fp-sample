package com.example

import com.example.customer.infrastructure.customerModule
import com.example.order.infrastructure.orderModule
import com.example.shared.infrastructure.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        configureSerialization()
        customerModule()
        orderModule()
    }.start(wait = true)
}