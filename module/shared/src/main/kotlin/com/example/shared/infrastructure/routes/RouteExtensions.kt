package com.example.shared.infrastructure.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun ApplicationCall.getParameterOrBadRequest(parameterName: String) =
    parameters[parameterName] ?: respondText("Missing parameter $parameterName", status = HttpStatusCode.BadRequest)