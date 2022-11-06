package com.example.customer.model

@JvmInline
value class CustomerId(val value: String)

@JvmInline
value class FirstName(val value: String)

@JvmInline
value class LastName(val value: String)

@JvmInline
value class Email(val value: String)

data class Customer(
    val id: CustomerId,
    val firstName: FirstName,
    val lastName: LastName,
    val email: Email
)
