package com.example.customer.application

import com.example.customer.infrastructure.di.CustomerDIScope
import com.example.customer.model.CustomerId

suspend fun CustomerDIScope.loadAllCustomers(): List<CustomerDTO> = customerRepository.loadAll().map { CustomerDTO.iso.reverseGet(it) }
suspend fun CustomerDIScope.loadCustomer(id: String): CustomerDTO = CustomerDTO.iso.reverseGet(customerRepository.loadCustomer(
    CustomerId(id)
)!!)
suspend fun CustomerDIScope.saveCustomer(customer: CustomerDTO) = customerRepository.saveCustomer(CustomerDTO.iso.get(customer))
suspend fun CustomerDIScope.removeCustomer(id: String) = customerRepository.removeCustomer(CustomerId(id))