package com.example

import com.example.customer.infrastructure.customerModule
import com.example.contexts.order.infrastructure.orderModule
import com.example.shared.infrastructure.di.SharedDIScope
import com.example.shared.infrastructure.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*
fun main() {
    embeddedServer(Netty, port = 8080) {
        val sharedDIScope = object : SharedDIScope() {}
        configureSerialization()
        customerModule(sharedDIScope)
        orderModule(sharedDIScope)
    }.start(wait = true)
}
