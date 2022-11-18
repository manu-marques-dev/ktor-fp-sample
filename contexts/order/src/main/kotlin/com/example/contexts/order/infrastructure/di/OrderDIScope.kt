package com.example.contexts.order.infrastructure.di

import com.example.contexts.order.infrastructure.repository.InMemoryOrderRepository
import com.example.contexts.order.model.OrderRepository
import com.example.shared.infrastructure.di.SharedDIScope

abstract class OrderDIScope (private val sharedDIScope: SharedDIScope){
    val orderRepository: OrderRepository get() = InMemoryOrderRepository()
}
