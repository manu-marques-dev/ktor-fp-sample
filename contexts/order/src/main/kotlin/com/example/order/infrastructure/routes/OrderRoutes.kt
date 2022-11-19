package com.example.order.infrastructure.routes

import com.example.order.application.getTotal
import com.example.order.application.loadAllOrders
import com.example.order.application.loadOrder
import com.example.order.infrastructure.di.OrderDIScope
import com.example.shared.infrastructure.routes.getParameterOrBadRequest
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.ordersRouting(orderDIScope: OrderDIScope) {
    route("/orders") {
        get {
            call.respond(orderDIScope.loadAllOrders())
        }

        get("{id?}") {
            val id = call.getParameterOrBadRequest("id") as String
            val order = orderDIScope.loadOrder(id)
            call.respond(order)
        }

        get("{id?}:total") {
            val id = call.getParameterOrBadRequest("id") as String
            call.respond(orderDIScope.getTotal(id))
        }
    }
}
