package com.example.shared.infrastructure.di

import com.example.customer.infrastructure.repository.InMemoryCustomerRepository
import com.example.order.infrastructure.repository.InMemoryOrderRepository
import com.example.customer.model.CustomerRepository
import com.example.order.model.OrderRepository

abstract class AppScope {
    //val logger:org.slf4j.Logger by lazy { LoggerFactory.getLogger(AppScope::class.java)}
    //val ioDispatcher: CoroutineContext by lazy { Dispatchers.IO }
    val customerRepository: CustomerRepository by lazy { InMemoryCustomerRepository() }
    val orderRepository: OrderRepository by lazy { InMemoryOrderRepository() }
}