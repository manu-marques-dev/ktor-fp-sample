package com.example.order

import com.example.order.infrastructure.orderModule
import com.example.shared.infrastructure.plugins.configureSerialization
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class OrderTest {
    @Test
    fun `List all orders`() = testApplication {
        application {
            configureSerialization()
            orderModule()
        }
        client.get("/orders").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }
}