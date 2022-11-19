package com.example.order.model

import Order
import OrderNumber

interface OrderRepository {
    suspend fun loadAll(): List<Order>
    suspend fun loadOrder(orderNumber: OrderNumber): Order?
    suspend fun saveOrder(order: Order)
    suspend fun removeOrder(orderNumber: OrderNumber)
}
