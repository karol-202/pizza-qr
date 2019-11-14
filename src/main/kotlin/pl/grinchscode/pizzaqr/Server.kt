package pl.grinchscode.pizzaqr

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.authenticate
import io.ktor.auth.basic
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.HttpMethod
import io.ktor.http.content.defaultResource
import io.ktor.http.content.resources
import io.ktor.http.content.static
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
import pl.grinchscode.pizzaqr.service.auth.AuthService
import pl.grinchscode.pizzaqr.service.serviceModule
import pl.grinchscode.pizzaqr.service.token.TokenService
import pl.grinchscode.pizzaqr.util.*

const val ARG_MONGODB = "mongodb.uri"
const val ARG_AUTH_USERNAME = "auth.username"
const val ARG_AUTH_PASSWORD = "auth.password"

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
	install(Authentication) {
		val authService: AuthService by inject()

		basic {
			realm = "PizzaQR"
			validate { authService.authenticate(it) }
		}
	}
	install(Koin) {
		propertiesByKtorEnvironment(environment, ARG_MONGODB, ARG_AUTH_USERNAME, ARG_AUTH_PASSWORD)
		modules(listOf(daoModule(), serviceModule()))
	}
}

private fun Application.routing() = routing {
	val tokenService: TokenService by inject()

	authenticate {
		route("api/token") {
			get("{token}") {
				val token = call.parameters["token"] ?: return@get badRequest()
				tokenService.useToken(token)?.let { ok(it) } ?: notFound()
			}
			post {
				val token = call.receive<Token>()
				if(tokenService.addToken(token)) ok() else conflict()
			}
		}

		static {
			resources("static")
			defaultResource("index.html", "static")
		}
	}
}
