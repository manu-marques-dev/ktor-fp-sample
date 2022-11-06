package com.example.customer.infrastructure.repository

import com.example.customer.model.Customer
import com.example.customer.model.CustomerId
import com.example.customer.model.Email
import com.example.customer.model.FirstName
import com.example.customer.model.LastName
import com.example.customer.model.CustomerRepository

class InMemoryCustomerRepository: CustomerRepository {

    private val customerStorage = mutableListOf<Customer>(
        Customer(CustomerId("manu"), FirstName("Manuel"), LastName("Marqués Reija"), Email("manuadai@gmail.com"))
    )

    override suspend fun loadAll(): List<Customer> = customerStorage

    override suspend fun loadCustomer(customerId: CustomerId): Customer? = customerStorage.find { it.id == customerId }

    override suspend fun saveCustomer(customer: Customer) {
        customerStorage.add(customer)
    }

    override suspend fun removeCustomer(customerId: CustomerId) {
        customerStorage.removeIf { it.id == customerId }
    }

}