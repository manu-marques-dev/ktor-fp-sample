package com.example.customer.application

import com.example.customer.model.CustomerId
import com.example.shared.infrastructure.di.AppScope

suspend fun AppScope.loadAllCustomers(): List<CustomerDTO> = customerRepository.loadAll().map { CustomerDTO.iso.reverseGet(it) }
suspend fun AppScope.loadCustomer(id: String): CustomerDTO = CustomerDTO.iso.reverseGet(customerRepository.loadCustomer(
    CustomerId(id)
)!!)
suspend fun AppScope.saveCustomer(customer: CustomerDTO) = customerRepository.saveCustomer(CustomerDTO.iso.get(customer))
suspend fun AppScope.removeCustomer(id: String) = customerRepository.removeCustomer(CustomerId(id))