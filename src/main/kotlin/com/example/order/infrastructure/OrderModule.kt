package com.example.order.infrastructure

import com.example.order.infrastructure.di.OrderDIScope
import com.example.order.infrastructure.routes.ordersRouting
import com.example.shared.infrastructure.di.SharedDIScope
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.orderModule(sharedDIScope: SharedDIScope) {
    val orderDIScope = object : OrderDIScope(sharedDIScope) {}
    configureOrdersRouting(orderDIScope)
}

fun Application.configureOrdersRouting(orderDIScope: OrderDIScope) {
    routing {
        ordersRouting(orderDIScope)
    }
}
