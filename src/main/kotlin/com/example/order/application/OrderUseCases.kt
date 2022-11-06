package com.example.order.application

import OrderNumber
import com.example.shared.infrastructure.di.AppScope

suspend fun AppScope.loadAllOrders(): List<OrderDTO> =  orderRepository.loadAll().map { OrderDTO.iso.reverseGet(it) }
suspend fun AppScope.loadOrder(orderNumber: String): OrderDTO = OrderDTO.iso.reverseGet(orderRepository.loadOrder(OrderNumber(orderNumber))!!)
suspend fun AppScope.getTotal(orderNumber: String): Double = orderRepository.loadOrder(OrderNumber(orderNumber))!!.getTotal()