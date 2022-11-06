package com.example.order.infrastructure.di

import com.example.order.infrastructure.repository.InMemoryOrderRepository
import com.example.order.model.OrderRepository
import com.example.shared.infrastructure.di.SharedDIScope

abstract class OrderDIScope (private val sharedDIScope: SharedDIScope){
    val orderRepository: OrderRepository get() = InMemoryOrderRepository()
}