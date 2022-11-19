package com.example.customer.infrastructure.di

import com.example.customer.infrastructure.repository.InMemoryCustomerRepository
import com.example.customer.model.CustomerRepository
import com.example.shared.infrastructure.di.SharedDIScope

abstract class CustomerDIScope(private val sharedDIScope: SharedDIScope) {
    val customerRepository: CustomerRepository get() = InMemoryCustomerRepository()
}