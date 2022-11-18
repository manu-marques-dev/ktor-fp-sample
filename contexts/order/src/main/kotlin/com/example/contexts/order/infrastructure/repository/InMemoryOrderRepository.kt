package com.example.contexts.order.infrastructure.repository

import Amount
import Item
import Order
import OrderItem
import OrderNumber
import Price
import com.example.contexts.order.model.OrderRepository

class InMemoryOrderRepository: OrderRepository {

    private val orderStorage = mutableListOf(
        Order(
            OrderNumber("2020-04-06-01"),
            listOf(
                OrderItem(Item("Ham Sandwich"), Amount(2), Price(5.50)),
                OrderItem(Item("Water"), Amount(1), Price(1.50)),
                OrderItem(Item("Beer"), Amount(3), Price(2.30)),
                OrderItem(Item("Cheesecake"), Amount(1), Price(3.75))
            )
        ),
        Order(
            OrderNumber("2020-04-03-01"),
            listOf(
                OrderItem(Item("Cheesburger"), Amount(1), Price(8.50)),
                OrderItem(Item("Water"), Amount(2), Price(1.50)),
                OrderItem(Item("Coke"), Amount(3), Price(1.76)),
                OrderItem(Item("Ice Cream"), Amount(1), Price(2.35))
            )
        )
    )
    override suspend fun loadAll(): List<Order> = orderStorage

    override suspend fun loadOrder(orderNumber: OrderNumber): Order? = orderStorage.find { it.number == orderNumber }

    override suspend fun saveOrder(order: Order) {
        orderStorage.add(order)
    }

    override suspend fun removeOrder(orderNumber: OrderNumber) {
        orderStorage.removeIf { it.number == orderNumber }
    }
}
