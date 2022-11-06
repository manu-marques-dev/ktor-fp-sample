package com.example.order.infrastructure

import com.example.order.infrastructure.routes.ordersRouting
import com.example.shared.infrastructure.di.AppScope
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.orderModule() {
    val diScope = object : AppScope() {}
    configureOrdersRouting(diScope)
}

fun Application.configureOrdersRouting(diScope: AppScope) {
    routing {
        ordersRouting(diScope)
    }
}
