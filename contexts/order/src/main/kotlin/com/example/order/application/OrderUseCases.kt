package com.example.order.application

import OrderNumber
import com.example.order.infrastructure.di.OrderDIScope
suspend fun OrderDIScope.loadAllOrders(): List<OrderDTO> =  orderRepository.loadAll().map { com.example.order.application.OrderDTO.iso.reverseGet(it) }
suspend fun OrderDIScope.loadOrder(orderNumber: String): OrderDTO = com.example.order.application.OrderDTO.iso.reverseGet(orderRepository.loadOrder(OrderNumber(orderNumber))!!)
suspend fun OrderDIScope.getTotal(orderNumber: String): Double = orderRepository.loadOrder(OrderNumber(orderNumber))!!.getTotal()
