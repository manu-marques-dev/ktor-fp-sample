package com.example.order.infrastructure.routes

import com.example.order.application.getTotal
import com.example.order.application.loadAllOrders
import com.example.order.application.loadOrder
import com.example.shared.infrastructure.di.AppScope
import com.example.shared.infrastructure.routes.getParameterOrBadRequest
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.ordersRouting(diScope: AppScope) {
    route("/orders") {
        get {
            call.respond(diScope.loadAllOrders())
        }

        get("{id?}") {
            val id = call.getParameterOrBadRequest("id") as String
            val order = diScope.loadOrder(id)
            call.respond(order)
        }

        get("{id?}:total") {
            val id = call.getParameterOrBadRequest("id") as String
            call.respond(diScope.getTotal(id))
        }
    }
}