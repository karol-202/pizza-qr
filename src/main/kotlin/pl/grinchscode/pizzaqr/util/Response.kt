package pl.grinchscode.pizzaqr.util

import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.util.pipeline.PipelineContext

private typealias Context = PipelineContext<*, ApplicationCall>

suspend fun Context.ok() = call.respond(HttpStatusCode.OK)

suspend fun Context.ok(message: Any) = call.respond(HttpStatusCode.OK, message)

suspend fun Context.badRequest() = call.respond(HttpStatusCode.BadRequest)

suspend fun Context.notFound() = call.respond(HttpStatusCode.NotFound)

suspend fun Context.conflict() = call.respond(HttpStatusCode.Conflict)
