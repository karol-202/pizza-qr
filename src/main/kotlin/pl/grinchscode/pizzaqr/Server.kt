package pl.grinchscode.pizzaqr

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.HttpMethod
import io.ktor.request.receive
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.util.KtorExperimentalAPI
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject
import pl.grinchscode.pizzaqr.dao.daoModule
import pl.grinchscode.pizzaqr.model.Token
import pl.grinchscode.pizzaqr.service.TokenService
import pl.grinchscode.pizzaqr.service.serviceModule
import pl.grinchscode.pizzaqr.util.*

const val ARG_MONGODB = "mongodb.uri"

@KtorExperimentalAPI
fun Application.main()
{
	configure()
	routing()
}

@KtorExperimentalAPI
private fun Application.configure()
{
	install(DefaultHeaders)
	install(CallLogging)
	install(ContentNegotiation) {
		gson()
	}
	install(CORS) {
		anyHost()
		method(HttpMethod.Get)
		method(HttpMethod.Post)
		method(HttpMethod.Put)
		method(HttpMethod.Delete)
	}
	install(Koin) {
		propertiesByKtorEnvironment(environment, ARG_MONGODB)
		modules(listOf(daoModule(), serviceModule()))
	}
}

private fun Application.routing() = routing {
	val tokenService: TokenService by inject()

	route("api/token") {
		get("{token}") {
			val token = call.parameters["token"] ?: return@get badRequest()
			tokenService.isTokenActive(token)?.let { ok(it) } ?: notFound()
		}
		post {
			val token = call.receive<Token>()
			if(tokenService.addToken(token)) ok() else conflict()
		}
	}
}
