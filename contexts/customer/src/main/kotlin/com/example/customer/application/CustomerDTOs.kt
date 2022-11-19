package com.example.customer.application

import com.example.customer.model.Customer
import com.example.customer.model.CustomerId
import com.example.customer.model.FirstName
import com.example.customer.model.LastName
import com.example.customer.model.Email
import arrow.optics.Iso
import kotlinx.serialization.Serializable

@Serializable
data class CustomerDTO(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
) {
    companion object {
        val iso: Iso<CustomerDTO, Customer> = Iso(
            get = {
                Customer(
                    id = CustomerId(it.id),
                    firstName = FirstName(it.firstName),
                    lastName = LastName(it.lastName),
                    email = Email(it.email)
                )
            },
            reverseGet = {
                CustomerDTO(
                    id = it.id.value,
                    firstName = it.firstName.value,
                    lastName = it.lastName.value,
                    email = it.email.value
                )
            }
        )
    }
}
