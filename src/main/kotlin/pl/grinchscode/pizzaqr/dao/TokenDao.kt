package pl.grinchscode.pizzaqr.dao

import pl.grinchscode.pizzaqr.model.Token

interface TokenDao
{
	suspend fun insertToken(token: Token): Boolean

	suspend fun updateToken(token: String, active: Boolean): Boolean

	suspend fun findToken(token: String): Token?
}
