package pl.grinchscode.pizzaqr.service

import org.koin.dsl.module

fun serviceModule() = module {
	single<TokenService> { TokenServiceImpl(get()) }
}
