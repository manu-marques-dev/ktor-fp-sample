package com.example.customer.infrastructure.routes

import com.example.customer.application.CustomerDTO
import com.example.customer.application.loadAllCustomers
import com.example.customer.application.loadCustomer
import com.example.customer.application.removeCustomer
import com.example.customer.application.saveCustomer
import com.example.customer.infrastructure.di.CustomerDIScope
import com.example.shared.infrastructure.routes.getParameterOrBadRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.customersRouting(customerDIScope: CustomerDIScope){

    route("/customers") {
        get {
            call.respond(customerDIScope.loadAllCustomers())
        }

        get("{id?}") {
            val id = call.getParameterOrBadRequest("id") as String
            val customer = customerDIScope.loadCustomer(id)
            call.respond(customer)
        }


        post {
            val customer = call.receive<CustomerDTO>()
            customerDIScope.saveCustomer(customer)
            call.respondText("com.example.customer.model.Customer stored correctly", status = HttpStatusCode.Created)
        }

        delete {
            val id = call.getParameterOrBadRequest("id") as String
            customerDIScope.removeCustomer(id)
            call.respondText("com.example.customer.model.Customer removed correctly", status = HttpStatusCode.Accepted)
        }
    }
}
