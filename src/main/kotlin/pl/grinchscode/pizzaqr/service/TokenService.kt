package pl.grinchscode.pizzaqr.service

import pl.grinchscode.pizzaqr.model.Token

interface TokenService
{
	suspend fun isTokenActive(token: String): Boolean?

	suspend fun addToken(token: Token): Boolean
}
