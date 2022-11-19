package com.example.customer.infrastructure

import com.example.customer.infrastructure.di.CustomerDIScope
import com.example.customer.infrastructure.routes.customersRouting
import com.example.shared.infrastructure.di.SharedDIScope
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.customerModule(sharedDIScope: SharedDIScope) {
    val customerDIScope = object : CustomerDIScope(sharedDIScope) {}
    configureCustomerRouting(customerDIScope)
}

fun Application.configureCustomerRouting(customerDIScope: CustomerDIScope) {
    routing {
        customersRouting(customerDIScope)
    }
}