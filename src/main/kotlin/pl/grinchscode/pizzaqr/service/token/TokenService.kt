package pl.grinchscode.pizzaqr.service.token

import pl.grinchscode.pizzaqr.model.Token

interface TokenService
{
	suspend fun addToken(token: Token): Boolean

	suspend fun useToken(token: String): Boolean?
}
