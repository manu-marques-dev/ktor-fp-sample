package com.example.customer.infrastructure

import com.example.customer.infrastructure.routes.customersRouting
import com.example.shared.infrastructure.di.AppScope
import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Application.customerModule() {
    val diScope = object : AppScope() {}
    configureCustomerRouting(diScope)
}

fun Application.configureCustomerRouting(diScope: AppScope) {
    routing {
        customersRouting(diScope)
    }
}