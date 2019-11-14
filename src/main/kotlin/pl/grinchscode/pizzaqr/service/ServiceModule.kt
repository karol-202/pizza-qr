package pl.grinchscode.pizzaqr.service

import org.koin.dsl.module
import pl.grinchscode.pizzaqr.ARG_AUTH_PASSWORD
import pl.grinchscode.pizzaqr.ARG_AUTH_USERNAME
import pl.grinchscode.pizzaqr.service.auth.AuthService
import pl.grinchscode.pizzaqr.service.auth.AuthServiceImpl
import pl.grinchscode.pizzaqr.service.token.TokenService
import pl.grinchscode.pizzaqr.service.token.TokenServiceImpl

fun serviceModule() = module {
	single<TokenService> { TokenServiceImpl(get()) }
	single<AuthService> { AuthServiceImpl(getProperty(ARG_AUTH_USERNAME), getProperty(ARG_AUTH_PASSWORD)) }
}
