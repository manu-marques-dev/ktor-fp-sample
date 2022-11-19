package com.example.customer.model

interface CustomerRepository {
    suspend fun loadAll(): List<Customer>
    suspend fun loadCustomer(customerId: CustomerId): Customer?
    suspend fun saveCustomer(customer: Customer)
    suspend fun removeCustomer(customerId: CustomerId)
}