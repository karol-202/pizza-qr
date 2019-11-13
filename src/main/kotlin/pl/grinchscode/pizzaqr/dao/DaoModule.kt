package pl.grinchscode.pizzaqr.dao

import org.koin.dsl.module
import pl.grinchscode.pizzaqr.ARG_MONGODB

fun daoModule() = module {
	single { MongoDatabase(getProperty(ARG_MONGODB)) }
	single<TokenDao> { MongoTokenDao(get()) }
}
