package com.example.customer

import com.example.customer.infrastructure.customerModule
import com.example.shared.infrastructure.di.SharedDIScope
import com.example.shared.infrastructure.plugins.configureSerialization
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerTest {
    @Test
    fun `List all customers`() = testApplication {
        application {
            configureSerialization()
            customerModule(sharedDIScope = object : SharedDIScope() {})
        }
        client.get("/customers").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }
}